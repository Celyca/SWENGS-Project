package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swengs.therapiedb.dto.AnimalDTO;
import swengs.therapiedb.facade.AnimalFacade;

import javax.validation.Valid;

@RestController
public class AnimalController {

    @Autowired
    private AnimalFacade animalFacade;

    @GetMapping("/dto/animals/{id}")
    AnimalDTO getById(@PathVariable Long id) {
        return animalFacade.getById(id);
    }

    @PostMapping("/dto/animals")
    AnimalDTO create(@RequestBody @Valid AnimalDTO dto) {
        return animalFacade.create(dto);
    }

    @PutMapping("/dto/animals/{id}")
    AnimalDTO update(@RequestBody @Valid AnimalDTO dto, @PathVariable Long id) {
        return animalFacade.update(id, dto);
    }
}
