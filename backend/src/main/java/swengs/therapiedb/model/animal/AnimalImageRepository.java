package swengs.therapiedb.model.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimalImageRepository extends PagingAndSortingRepository<AnimalImage, Long>, JpaRepository<AnimalImage, Long>, CrudRepository<AnimalImage, Long> {
}
