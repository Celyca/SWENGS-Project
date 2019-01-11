package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.EventDTO;
import swengs.therapiedb.model.therapie.Event;
import swengs.therapiedb.service.AnimalService;
import swengs.therapiedb.service.EventService;
import swengs.therapiedb.service.OfferService;
import swengs.therapiedb.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service()
@Transactional
public class EventFacade {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private EventService eventService;

    // ---------------------------------------------------------------------------------

    void mapDtoToEntity(EventDTO dto, Event entity) {
        entity.setEvent(dto.getEvent());
        entity.setAnimal(animalService.getAnimal(dto.getAninmal()));
        entity.setUser(userService.getUser(dto.getUser()));
        entity.setOffer(offerService.getOffer(dto.getOffer()));
    }

    private void mapEntityToDto(Event entity, EventDTO dto) {
        dto.setId(entity.getId());
        dto.setEvent(entity.getEvent());
        dto.setAninmal(entity.getAnimal().getId());
        dto.setUser(entity.getUser().getId());
        dto.setOffer(entity.getOffer().getId());
    }

    // ---------------------------------------------------------------------------------

    public EventDTO update(Long id, EventDTO dto) {
        Event entity = eventService.findById(id).get();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;
    }

    public EventDTO create(EventDTO dto) {
        Event entity = new Event();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(eventService.save(entity), dto);
        return dto;
    }

    public EventDTO getById(Long id) {
        Event entity = eventService.findById(id).get();
        EventDTO dto = new EventDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public void delete(Long id) {
        eventService.delete(id);
    }

    // ---------------------------------------------------------------------------------

    public List<EventDTO> getAll() {
        List<EventDTO> dtos = new ArrayList<>();
        eventService.findAll().forEach(entity -> {
            EventDTO dto = new EventDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }


}
