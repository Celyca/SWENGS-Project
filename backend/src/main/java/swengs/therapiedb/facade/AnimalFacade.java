package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.AnimalDTO;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.service.AnimalImageService;
import swengs.therapiedb.service.AnimalService;
import swengs.therapiedb.service.LocationService;
import swengs.therapiedb.service.SpeciesService;

import java.util.ArrayList;
import java.util.List;

@Service()
@Transactional
public class AnimalFacade {

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private AnimalImageService animalImageService;

    // ---------------------------------------------------------------------------------

    void mapDtoToEntity(AnimalDTO dto, Animal entity) {
        entity.setName(dto.getName());
        entity.setBreed(dto.getBreed());
        entity.setColor(dto.getColor());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setDescription(dto.getDescription());
        entity.setSpecies(speciesService.getSpecie(dto.getSpecies()));
        entity.setLocation(locationService.getLocation(dto.getLocation()));
        entity.setImage(animalImageService.getImage(dto.getImage()));
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
        dto.setLocation(entity.getLocation().getId());
        dto.setImage(animalService.getImage(entity).getId());
    }

    // ---------------------------------------------------------------------------------

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

    public void delete(Long id) {
        animalService.delete(id);
    }

    // ---------------------------------------------------------------------------------

    public List<AnimalDTO> getAll() {
        List<AnimalDTO> dtos = new ArrayList<>();
        animalService.findAll().forEach(entity -> {
            AnimalDTO dto = new AnimalDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }

    public List<AnimalDTO> getAllBySpecies(Long id) {
        List<AnimalDTO> dtos = new ArrayList<>();
        animalService.findBySpecies(id).forEach(entity -> {
            AnimalDTO dto = new AnimalDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }


}
