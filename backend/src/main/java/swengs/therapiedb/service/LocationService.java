package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.therapie.Location;
import swengs.therapiedb.model.therapie.LocationRepository;

import java.util.*;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // ---------------------------------------------------------------------------------

    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public Location save(Location entity) {
        return locationRepository.save(entity);
    }

    public void delete(Long id) { locationRepository.deleteById(id); }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public Location getLocation(Long id) {
        Location entity = findById(id).get();
        return entity;
    }

    public Set<Location> getLocations(Set<Long> dtos) {
        Set<Location> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(locationRepository.findById(dto).get()));
        }
        return entities;
    }

    // ---------------------------------------------------------------------------------

}
