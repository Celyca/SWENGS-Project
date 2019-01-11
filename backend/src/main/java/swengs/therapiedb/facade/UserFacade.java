package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.model.user.UserProfile;
import swengs.therapiedb.service.LocationService;
import swengs.therapiedb.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service()
@Transactional
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private LocationService locationService;

    // ---------------------------------------------------------------------------------

    void mapDtoToEntity(UserDTO dto, User entity) {
        UserProfile profile = userService.getProfile(entity);
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setDayOfBirth(dto.getDayOfBirth());
        profile.setEmail(dto.getEmail());
        profile.setZip(dto.getZip());
        profile.setCity(dto.getCity());
        profile.setAddress(dto.getAddress());
        profile.setPhone(dto.getPhone());
        entity.setLocations(locationService.getLocations(dto.getLocations()));
        entity.setUserProfile(profile);
    }

    private void mapEntityToDto(User entity, UserDTO dto) {
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getUserProfile().getFirstName());
        dto.setLastName(entity.getUserProfile().getLastName());
        dto.setDayOfBirth(entity.getUserProfile().getDayOfBirth());
        dto.setEmail(entity.getUserProfile().getEmail());
        dto.setZip(entity.getUserProfile().getZip());
        dto.setCity(entity.getUserProfile().getCity());
        dto.setAddress(entity.getUserProfile().getAddress());
        dto.setPhone(entity.getUserProfile().getPhone());
        dto.setLocations(entity.getLocations().stream().map((m) -> m.getId()).collect(Collectors.toSet()));
    }

    // ---------------------------------------------------------------------------------

    public UserDTO update(Long id, UserDTO dto) {
        User entity = userService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public UserDTO create(Long id, UserDTO dto) {
        User entity = userService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public UserDTO getById(Long id) {
        User entity = userService.findById(id).get();
        UserDTO dto = new UserDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public void delete(Long id) {
        userService.delete(id);
    }

    // ---------------------------------------------------------------------------------

    public List<UserDTO> getAll() {
        List<UserDTO> dtos = new ArrayList<>();
        userService.findAll().forEach(entity -> {
            UserDTO dto = new UserDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }

    public List<UserDTO> getAllByEmployee() {
        List<UserDTO> dtos = new ArrayList<>();
        userService.findByEmployee().forEach(entity -> {
            UserDTO dto = new UserDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }
}
