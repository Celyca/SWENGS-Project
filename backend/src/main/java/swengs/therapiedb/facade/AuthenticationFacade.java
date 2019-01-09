package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.AuthenticationDTO;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.service.AuthenticationService;
import swengs.therapiedb.service.UserService;

@Service()
@Transactional
public class AuthenticationFacade {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    void mapDtoToEntity(AuthenticationDTO dto, User entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setAdmin(dto.isAdmin());
    }

    private void mapEntityToDto(User entity, AuthenticationDTO dto) {
        dto.setUsername(entity.getUsername());
        dto.setAdmin(dto.isAdmin());
    }

    public AuthenticationDTO create(AuthenticationDTO dto) {
        User entity = new User();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public AuthenticationDTO getById(Long id) {
        User entity = userService.findById(id).get();
        AuthenticationDTO dto = new AuthenticationDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public AuthenticationDTO update(Long id, AuthenticationDTO dto) {
        User entity = userService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(userService.save(entity), dto);
        return dto;
    }

    public AuthenticationDTO getAuth() {
        User entity = authenticationService.getAuthentication();
        AuthenticationDTO dto = new AuthenticationDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
