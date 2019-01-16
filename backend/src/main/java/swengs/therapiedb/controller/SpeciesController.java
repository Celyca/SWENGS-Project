package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swengs.therapiedb.dto.AnimalDTO;
import swengs.therapiedb.dto.SpeciesDTO;
import swengs.therapiedb.facade.AnimalFacade;
import swengs.therapiedb.facade.SpeciesFacade;
import swengs.therapiedb.model.animal.Species;
import swengs.therapiedb.service.SpeciesService;

import java.util.List;

@RestController
@RequestMapping("/dto/species")
public class SpeciesController {

    @Autowired
    private AnimalFacade animalFacade;

    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private SpeciesFacade speciesFacade;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<List<AnimalDTO>> getAllBySpecies(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        List<AnimalDTO> dtos = animalFacade.getAllBySpecies(id);

        if (dtos == null || !dtos.iterator().hasNext()) {
            return new ResponseEntity<List<AnimalDTO>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<AnimalDTO>>(dtos,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<SpeciesDTO>> getAll() {
    // ---------------------------------------------------------------------------------

        List<Species> species = speciesService.findAll();

        if (species == null || !species.iterator().hasNext()) {
            return new ResponseEntity<List<SpeciesDTO>>(HttpStatus.NOT_FOUND);
        }

        List<SpeciesDTO> dtos = speciesFacade.getAll();
        return new ResponseEntity<List<SpeciesDTO>>(dtos,HttpStatus.OK);
    }
}
