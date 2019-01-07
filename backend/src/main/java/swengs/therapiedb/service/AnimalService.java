package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.model.animal.AnimalRepository;

import java.util.Optional;

@Service()
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal save(Animal entity) {
        return animalRepository.save(entity);
    }
}
