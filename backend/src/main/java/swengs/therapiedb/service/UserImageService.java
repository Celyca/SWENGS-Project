package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import swengs.therapiedb.model.user.UserImage;
import swengs.therapiedb.model.user.UserImageRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService {

    private static final String UPLOAD_FOLDER = "uploads/animal";

    @Autowired
    private UserImageRepository userImageRepository;

    // ---------------------------------------------------------------------------------

    public UserImage save(UserImage media) {
        return userImageRepository.save(media);
    }

    @Transactional(readOnly = true)
    public Optional<UserImage> findOne(Long id) {
        return userImageRepository.findById(id);
    }

    public void delete(Long id) {
        userImageRepository.deleteById(id);
    }

    // ---------------------------------------------------------------------------------

    public UserImage createMedia(MultipartFile multipartFile) throws IOException {
        UserImage dbMedia = new UserImage();
        dbMedia.setOriginalFileName(multipartFile.getOriginalFilename());
        dbMedia.setContentType(multipartFile.getContentType());
        dbMedia.setSize(multipartFile.getSize());
        UserImage savedDbMedia = save(dbMedia);

        File dest = retrieveMediaFile(savedDbMedia);
        try (FileOutputStream fos = new FileOutputStream(dest)) {
            fos.write(multipartFile.getBytes());
        }
        return savedDbMedia;
    }

    // ---------------------------------------------------------------------------------

    public File retrieveMediaFile(UserImage media) {
        File uploadsDir = retrieveUploadsDirectory();
        String filePath = uploadsDir.getAbsolutePath() + "/" + media.getId();
        return new File(filePath);
    }

    private File retrieveUploadsDirectory() {
        String uploadsDirPath = UPLOAD_FOLDER;
        File uploadsDir = new File(uploadsDirPath);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdir();
        }
        return uploadsDir;
    }
}
