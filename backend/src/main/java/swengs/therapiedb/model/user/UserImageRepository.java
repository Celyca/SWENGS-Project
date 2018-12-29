package swengs.therapiedb.model.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserImageRepository extends PagingAndSortingRepository<UserImage,Long> {
}
