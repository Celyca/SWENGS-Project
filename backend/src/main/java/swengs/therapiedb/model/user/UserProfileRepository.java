package therapie.db.model.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile,Long> {

}
