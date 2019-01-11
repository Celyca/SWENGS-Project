package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.LocationDTO;
import swengs.therapiedb.model.therapie.Location;
import swengs.therapiedb.service.AnimalService;
import swengs.therapiedb.service.LocationService;
import swengs.therapiedb.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service()
@Transactional
public class LocationFacade {

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnimalService animalService;

    // ---------------------------------------------------------------------------------

    void mapDtoToEntity(LocationDTO dto, Location entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setZip(dto.getZip());
        entity.setCity(dto.getCity());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        entity.setAnimals(animalService.getAnimals(dto.getAnimals()));
        entity.setUsers(userService.getUsers(dto.getUsers()));
    }

    private void mapEntityToDto(Location entity, LocationDTO dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setZip(entity.getZip());
        dto.setCity(entity.getCity());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
    }

    // ---------------------------------------------------------------------------------

    public LocationDTO update(Long id, LocationDTO dto) {
        Location entity = locationService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(locationService.save(entity), dto);
        return dto;
    }

    public LocationDTO create(LocationDTO dto) {
        Location entity = new Location();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(locationService.save(entity), dto);
        return dto;
    }

    public LocationDTO getById(Long id) {
        Location entity = locationService.findById(id).get();
        LocationDTO dto = new LocationDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public void delete(Long id) {
        locationService.delete(id);
    }

    // ---------------------------------------------------------------------------------

    public List<LocationDTO> getAll() {
        List<LocationDTO> dtos = new ArrayList<>();
        locationService.findAll().forEach(entity -> {
            LocationDTO dto = new LocationDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }
}
