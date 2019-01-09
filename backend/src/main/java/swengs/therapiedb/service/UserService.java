package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.model.user.UserProfile;
import swengs.therapiedb.model.user.UserProfileRepository;
import swengs.therapiedb.model.user.UserRepository;

import java.util.BitSet;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User entity) {
        return userRepository.save(entity);
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
