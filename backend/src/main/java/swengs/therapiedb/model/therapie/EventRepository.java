package swengs.therapiedb.model.therapie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, Long>, JpaRepository<Event, Long>, CrudRepository<Event, Long> {
}
