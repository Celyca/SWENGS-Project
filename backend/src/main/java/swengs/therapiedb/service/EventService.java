package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.therapie.Event;
import swengs.therapiedb.model.therapie.EventRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // ---------------------------------------------------------------------------------

    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Event save(Event entity) {
        return eventRepository.save(entity);
    }

    public void delete(Long id) { eventRepository.deleteById(id); }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public Event getEvent(Long id) {
        Event entity = findById(id).get();
        return entity;
    }

    public Set<Event> getEvent(Set<Long> dtos) {
        Set<Event> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(eventRepository.findById(dto).get()));
        }
        return entities;
    }

    // ---------------------------------------------------------------------------------
}
