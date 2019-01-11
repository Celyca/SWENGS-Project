package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.OfferDTO;
import swengs.therapiedb.model.therapie.Offer;
import swengs.therapiedb.service.LocationService;
import swengs.therapiedb.service.OfferService;
import swengs.therapiedb.service.SpeciesService;
import swengs.therapiedb.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service()
@Transactional
public class OfferFacade {

    @Autowired
    private LocationService locationService;

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private UserService userService;

    // ---------------------------------------------------------------------------------

    void mapDtoToEntity(OfferDTO dto, Offer entity) {
        entity.setDescription(dto.getDescription());
        entity.setDuration(dto.getDuration());
        entity.setLocation(locationService.getLocation(dto.getLocation()));
        entity.setSpecies(speciesService.getSpecie(dto.getSpecies()));
        entity.setEmployee(userService.getUser(dto.getUser()));
    }

    private void mapEntityToDto(Offer entity, OfferDTO dto) {
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setDuration(entity.getDuration());
        dto.setLocation(entity.getLocation().getId());
        dto.setSpecies(entity.getSpecies().getId());
        dto.setUser(entity.getEmployee().getId());
    }

    // ---------------------------------------------------------------------------------

    public OfferDTO update(Long id, OfferDTO dto) {
        Offer entity = offerService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(offerService.save(entity), dto);
        return dto;
    }

    public OfferDTO create(OfferDTO dto) {
        Offer entity = new Offer();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(offerService.save(entity), dto);
        return dto;
    }

    public OfferDTO getById(Long id) {
        Offer entity = offerService.findById(id).get();
        OfferDTO dto = new OfferDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public void delete(Long id) {
        offerService.delete(id);
    }

    // ---------------------------------------------------------------------------------

    public List<OfferDTO> getAll() {
        List<OfferDTO> dtos = new ArrayList<>();
        offerService.findAll().forEach(entity -> {
            OfferDTO dto = new OfferDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }
}
