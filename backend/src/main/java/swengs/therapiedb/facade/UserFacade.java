package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.model.user.UserProfile;
import swengs.therapiedb.service.UserService;

@Service()
@Transactional
public class UserFacade {

    @Autowired
    private UserService userService;

    void mapDtoToEntity(UserDTO dto, User entity) {
        UserProfile profile = entity.getUserProfile();
        entity.setUsername(dto.getUsername());
        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setDayOfBirth(dto.getDayOfBirth());
        profile.setEmail(dto.getEmail());
        profile.setZip(dto.getZip());
        profile.setCity(dto.getCity());
        profile.setAddress(dto.getAddress());
        profile.setPhone(dto.getPhone());
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
    }

    public UserDTO update(Long id, UserDTO dto) {
        User entity = userService.getProfile(userService.findById(id).get());
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public UserDTO create(UserDTO dto) {
        User entity = userService.getProfile(new User());
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
}
