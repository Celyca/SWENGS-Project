package swengs.therapiedb.model.therapie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfferRepository extends PagingAndSortingRepository<Offer, Long>, JpaRepository<Offer, Long>, CrudRepository<Offer, Long> {
}
