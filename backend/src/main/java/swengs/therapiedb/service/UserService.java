package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.user.*;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    // ---------------------------------------------------------------------------------

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User entity) {
        return userRepository.save(entity);
    }

    public void delete(Long id) {
        User user = findById(id).get();
        if (user.getUserProfile() != null){
            userProfileRepository.delete(user.getUserProfile());
        }
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public User getUser(Long id) {
        User entity = findById(id).get();
        return entity;
    }

    public Set<User> getUsers(Set<Long> dtos) {
        Set<User> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(userRepository.findById(dto).get()));
        }
        return entities;
    }

    public UserImage getImage(User entity) {
        if (entity.getImage() == null) {
            return new UserImage();
        }
        return entity.getImage();
    }

    // ---------------------------------------------------------------------------------

    public List<User> findByEmployee() {
        return userRepository.findAllByEmployee(true);
    }

    public UserProfile getProfile(User entity) {
        if (entity.getUserProfile() == null) {
            UserProfile profile = new UserProfile();
            profile.setUser(entity);
            userProfileRepository.save(profile);
            entity.setUserProfile(profile);
            save(entity);
        }
        return entity.getUserProfile();
    }
}
