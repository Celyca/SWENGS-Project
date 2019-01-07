package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.AnimalDTO;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.service.AnimalService;
import swengs.therapiedb.service.SpeciesService;

@Service()
@Transactional
public class AnimalFacade {

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private AnimalService animalService;

    void mapDtoToEntity(AnimalDTO dto, Animal entity) {
        entity.setName(dto.getName());
        entity.setBreed(dto.getBreed());
        entity.setColor(dto.getColor());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setDescription(dto.getDescription());
        entity.setSpecies(speciesService.getSpecies(dto.getSpecies()));
    }

    private void mapEntityToDto(Animal entity, AnimalDTO dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setBreed(entity.getBreed());
        dto.setColor(entity.getColor());
        dto.setAge(entity.getAge());
        dto.setGender(entity.getGender());
        dto.setDescription(entity.getDescription());
        dto.setSpecies(entity.getSpecies().getId());
        dto.setImage(entity.getImage().getId());
    }

    public AnimalDTO update(Long id, AnimalDTO dto) {
        Animal entity = animalService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(animalService.save(entity), dto);
        return dto;
    }

    public AnimalDTO create(AnimalDTO dto) {
        Animal entity = new Animal();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(animalService.save(entity), dto);
        return dto;
    }

    public AnimalDTO getById(Long id) {
        Animal entity = animalService.findById(id).get();
        AnimalDTO dto = new AnimalDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

}
