package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.therapie.Offer;
import swengs.therapiedb.model.therapie.OfferRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    // ---------------------------------------------------------------------------------

    public Optional<Offer> findById(Long id) {
        return offerRepository.findById(id);
    }

    public Offer save(Offer entity) {
        return offerRepository.save(entity);
    }

    public void delete(Long id) { offerRepository.deleteById(id); }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public Offer getOffer(Long id) {
        Offer entity = findById(id).get();
        return entity;
    }

    public Set<Offer> getOffers(Set<Long> dtos) {
        Set<Offer> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(offerRepository.findById(dto).get()));
        }
        return entities;
    }

    // ---------------------------------------------------------------------------------

}
