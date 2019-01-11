package swengs.therapiedb.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaRepository<User, Long>, CrudRepository<User, Long> {
    public User findByUsername(@Param("username") String username);

    public List<User> findAllByEmployee(@Param("employee") boolean employee);
}
