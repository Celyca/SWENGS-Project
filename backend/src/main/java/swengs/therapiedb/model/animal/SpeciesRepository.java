package swengs.therapiedb.model.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpeciesRepository extends PagingAndSortingRepository<Species, Long>, JpaRepository<Species, Long>, CrudRepository<Species, Long> {
}
