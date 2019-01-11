package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.model.animal.AnimalRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service()
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // ---------------------------------------------------------------------------------

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public Animal save(Animal entity) {
        return animalRepository.save(entity);
    }

    public void delete(Long id) { animalRepository.deleteById(id); }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public Animal getAnimal(Long id) {
        Animal entity = findById(id).get();
        return entity;
    }

    public Set<Animal> getAnimals(Set<Long> dtos) {
        Set<Animal> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(animalRepository.findById(dto).get()));
        }
        return entities;
    }

    // ---------------------------------------------------------------------------------

    public List<Animal> findBySpecies(Long id) {
        return animalRepository.findAllBySpecies(id);
    }

}
