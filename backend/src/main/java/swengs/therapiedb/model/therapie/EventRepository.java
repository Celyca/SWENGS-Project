package swengs.therapiedb.model.therapie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import swengs.therapiedb.model.user.User;

import java.util.List;

public interface EventRepository extends PagingAndSortingRepository<Event, Long>, JpaRepository<Event, Long>, CrudRepository<Event, Long> {
    public List<Event> findAllByUser(@Param("user") User user);
}
