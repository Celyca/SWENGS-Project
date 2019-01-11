package swengs.therapiedb.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, Long>, JpaRepository<UserProfile, Long>, CrudRepository<UserProfile, Long> {

}
