package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.model.user.UserImage;
import swengs.therapiedb.service.UserImageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/dto/animals/user")
public class UserImageController {

    @Autowired
    private UserImageService userImageService;

    // ---------------------------------------------------------------------------------
    @PostMapping("")
    public ResponseEntity<UserImage> uploadMedia(@RequestPart MultipartFile file, UriComponentsBuilder ucBuilder) throws IOException, URISyntaxException {
        // ---------------------------------------------------------------------------------

        UserImage result = userImageService.createMedia(file);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/users/image/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<UserImage>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    public ResponseEntity<InputStreamResource> getMediaDownload(@PathVariable Long id) throws FileNotFoundException {
        // ---------------------------------------------------------------------------------

        Optional<UserImage> mediaResult = userImageService.findOne(id);
        if (!mediaResult.isPresent()) {
            return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
        }
        UserImage media = mediaResult.get();
        File mediaFile = userImageService.retrieveMediaFile(media);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(mediaFile));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + media.getOriginalFileName());
        headers.setContentType(MediaType.parseMediaType(media.getContentType()));
        headers.setContentLength(media.getSize());
        return new ResponseEntity<InputStreamResource>(resource ,headers, HttpStatus.OK);
    }
}
