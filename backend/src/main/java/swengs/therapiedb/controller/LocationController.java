package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.LocationDTO;
import swengs.therapiedb.facade.LocationFacade;
import swengs.therapiedb.model.therapie.Location;
import swengs.therapiedb.service.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dto/locations")
public class LocationController {
    
    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationFacade locationFacade;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<LocationDTO> getById(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!locationService.findById(id).isPresent()) {
            return new ResponseEntity<LocationDTO>(HttpStatus.NOT_FOUND);
        }

        LocationDTO dto = locationFacade.getById(id);
        return new ResponseEntity<LocationDTO>(dto,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @PostMapping("")
    ResponseEntity<LocationDTO> create(@RequestBody @Valid LocationDTO dto, UriComponentsBuilder ucBuilder) {
        // ---------------------------------------------------------------------------------

        LocationDTO result = locationFacade.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/locations/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<LocationDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("{id}")
    ResponseEntity<LocationDTO> update(@RequestBody @Valid LocationDTO dto, @PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!locationService.findById(id).isPresent()) {
            return new ResponseEntity<LocationDTO>(HttpStatus.NOT_FOUND);
        }

        locationFacade.update(id, dto);
        return new ResponseEntity<LocationDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @DeleteMapping("{id}")
    ResponseEntity<LocationDTO> delete(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!locationService.findById(id).isPresent()) {
            return new ResponseEntity<LocationDTO>(HttpStatus.NOT_FOUND);
        }

        locationFacade.delete(id);
        return new ResponseEntity<LocationDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<LocationDTO>> getAll() {
        // ---------------------------------------------------------------------------------

        List<Location> entities = locationService.findAll();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<LocationDTO>>(HttpStatus.NO_CONTENT);
        }

        List<LocationDTO> dtos = locationFacade.getAll();
        return new ResponseEntity<List<LocationDTO>>(dtos,HttpStatus.OK);
    }
}
