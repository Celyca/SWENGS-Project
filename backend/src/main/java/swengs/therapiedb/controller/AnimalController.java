package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.AnimalDTO;
import swengs.therapiedb.facade.AnimalFacade;
import swengs.therapiedb.model.animal.Animal;
import swengs.therapiedb.service.AnimalService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dto/animals")
public class AnimalController {

    @Autowired
    private AnimalFacade animalFacade;

    @Autowired
    private AnimalService animalService;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<AnimalDTO> getById(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!animalService.findById(id).isPresent()) {
            return new ResponseEntity<AnimalDTO>(HttpStatus.NOT_FOUND);
        }

        AnimalDTO dto = animalFacade.getById(id);
        return new ResponseEntity<AnimalDTO>(dto,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @PostMapping("")
    ResponseEntity<AnimalDTO> create(@RequestBody @Valid AnimalDTO dto, UriComponentsBuilder ucBuilder) {
    // ---------------------------------------------------------------------------------

        AnimalDTO result = animalFacade.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/animals/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<AnimalDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("{id}")
    ResponseEntity<AnimalDTO> update(@RequestBody @Valid AnimalDTO dto, @PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!animalService.findById(id).isPresent()) {
            return new ResponseEntity<AnimalDTO>(HttpStatus.NOT_FOUND);
        }

        animalFacade.update(id, dto);
        return new ResponseEntity<AnimalDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @DeleteMapping("{id}")
    ResponseEntity<AnimalDTO> delete(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!animalService.findById(id).isPresent()) {
            return new ResponseEntity<AnimalDTO>(HttpStatus.NOT_FOUND);
        }

        animalFacade.delete(id);
        return new ResponseEntity<AnimalDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<AnimalDTO>> getAll() {
    // ---------------------------------------------------------------------------------

        List<Animal> entities = animalService.findAll();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<AnimalDTO>>(HttpStatus.NO_CONTENT);
        }

        List<AnimalDTO> dtos = animalFacade.getAll();
        return new ResponseEntity<List<AnimalDTO>>(dtos,HttpStatus.OK);
    }
}
