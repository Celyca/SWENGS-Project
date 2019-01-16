package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.model.animal.AnimalImage;
import swengs.therapiedb.model.animal.AnimalImageRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class AnimalImageService {

    private static final String UPLOAD_FOLDER = "uploads/animal";

    @Autowired
    private AnimalImageRepository animalImageRepository;

    @Autowired
    private AnimalService animalService;

    // ---------------------------------------------------------------------------------

    public AnimalImage save(AnimalImage media) {
        return animalImageRepository.save(media);
    }

    @Transactional(readOnly = true)
    public Optional<AnimalImage> findOne(Long id) {
        return animalImageRepository.findById(id);
    }

    public void delete(Long id) {
        animalImageRepository.deleteById(id);
    }

    // ---------------------------------------------------------------------------------

    public AnimalImage createMedia(MultipartFile multipartFile, Long id) throws IOException {
        AnimalImage dbMedia = new AnimalImage();
        dbMedia.setOriginalFileName(multipartFile.getOriginalFilename());
        dbMedia.setContentType(multipartFile.getContentType());
        dbMedia.setSize(multipartFile.getSize());

        Animal animal = animalService.findById(id).get();
        if (animal.getImage() == null) {
            dbMedia.setAnimal(animal);
        } else {
            deleteMediaFile(animal.getImage());
            dbMedia.setAnimal(animal);
        }
        AnimalImage savedDbMedia = save(dbMedia);

        File dest = retrieveMediaFile(savedDbMedia);
        try (FileOutputStream fos = new FileOutputStream(dest)) {
            fos.write(multipartFile.getBytes());
        }
        return savedDbMedia;
    }

    // ---------------------------------------------------------------------------------

    public File retrieveMediaFile(AnimalImage media) {
        File uploadsDir = retrieveUploadsDirectory();
        String filePath = uploadsDir.getAbsolutePath() + "/" + media.getId();
        return new File(filePath);
    }

    public void deleteMediaFile(AnimalImage media) {
        File uploadsDir = retrieveUploadsDirectory();
        String filePath = uploadsDir.getAbsolutePath() + "/" + media.getId();
        File file = new File(filePath);
        delete(media.getId());
        file.delete();
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
