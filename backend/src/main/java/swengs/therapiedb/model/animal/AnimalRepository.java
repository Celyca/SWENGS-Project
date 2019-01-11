package swengs.therapiedb.model.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AnimalRepository extends PagingAndSortingRepository<Animal,Long>, JpaRepository<Animal, Long>, CrudRepository<Animal, Long> {
    public List<Animal> findAllBySpecies(@Param("id") Long id);
}
