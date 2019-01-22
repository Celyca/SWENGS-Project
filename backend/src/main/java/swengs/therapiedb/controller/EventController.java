package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.EventDTO;
import swengs.therapiedb.facade.EventFacade;
import swengs.therapiedb.model.therapie.Event;
import swengs.therapiedb.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dto/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventFacade eventFacade;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<EventDTO> getById(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!eventService.findById(id).isPresent()) {
            return new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
        }

        EventDTO dto = eventFacade.getById(id);
        return new ResponseEntity<EventDTO>(dto,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @PostMapping("")
    ResponseEntity<EventDTO> create(@RequestBody @Valid EventDTO dto, UriComponentsBuilder ucBuilder) {
        // ---------------------------------------------------------------------------------

        EventDTO result = eventFacade.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/events/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<EventDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("{id}")
    ResponseEntity<EventDTO> update(@RequestBody @Valid EventDTO dto, @PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!eventService.findById(id).isPresent()) {
            return new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
        }

        eventFacade.update(id, dto);
        return new ResponseEntity<EventDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @DeleteMapping("{id}")
    ResponseEntity<EventDTO> delete(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!eventService.findById(id).isPresent()) {
            return new ResponseEntity<EventDTO>(HttpStatus.NOT_FOUND);
        }

        eventFacade.delete(id);
        return new ResponseEntity<EventDTO>(HttpStatus.NO_CONTENT);
    }
/*
    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<EventDTO>> getAll() {
        // ---------------------------------------------------------------------------------

        List<Event> entities = eventService.findAll();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<EventDTO>>(HttpStatus.NO_CONTENT);
        }

        List<EventDTO> dtos = eventFacade.getAll();
        return new ResponseEntity<List<EventDTO>>(dtos, HttpStatus.OK);
    }
*/
    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<EventDTO>> getAllByUser() {
    // ---------------------------------------------------------------------------------

        List<Event> entities = eventService.getEventsByUser();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<EventDTO>>(HttpStatus.NO_CONTENT);
        }

        List<EventDTO> dtos = eventFacade.getAllByUser();
        return new ResponseEntity<List<EventDTO>>(dtos,HttpStatus.OK);
    }
}
