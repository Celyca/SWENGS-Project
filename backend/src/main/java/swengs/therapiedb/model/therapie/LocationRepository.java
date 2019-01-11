package swengs.therapiedb.model.therapie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long>, JpaRepository<Location, Long>, CrudRepository<Location, Long> {
}
