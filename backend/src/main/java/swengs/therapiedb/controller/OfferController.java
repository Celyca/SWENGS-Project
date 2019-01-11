package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.OfferDTO;
import swengs.therapiedb.facade.OfferFacade;
import swengs.therapiedb.model.therapie.Offer;
import swengs.therapiedb.service.OfferService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dto/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @Autowired
    private OfferFacade offerFacade;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<OfferDTO> getById(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!offerService.findById(id).isPresent()) {
            return new ResponseEntity<OfferDTO>(HttpStatus.NOT_FOUND);
        }

        OfferDTO dto = offerFacade.getById(id);
        return new ResponseEntity<OfferDTO>(dto,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @PostMapping("")
    ResponseEntity<OfferDTO> create(@RequestBody @Valid OfferDTO dto, UriComponentsBuilder ucBuilder) {
        // ---------------------------------------------------------------------------------

        OfferDTO result = offerFacade.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/animals/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<OfferDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("{id}")
    ResponseEntity<OfferDTO> update(@RequestBody @Valid OfferDTO dto, @PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!offerService.findById(id).isPresent()) {
            return new ResponseEntity<OfferDTO>(HttpStatus.NOT_FOUND);
        }

        offerFacade.update(id, dto);
        return new ResponseEntity<OfferDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @DeleteMapping("{id}")
    ResponseEntity<OfferDTO> delete(@PathVariable Long id) {
        // ---------------------------------------------------------------------------------

        if (!offerService.findById(id).isPresent()) {
            return new ResponseEntity<OfferDTO>(HttpStatus.NOT_FOUND);
        }

        offerFacade.delete(id);
        return new ResponseEntity<OfferDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("")
    ResponseEntity<List<OfferDTO>> getAll() {
        // ---------------------------------------------------------------------------------

        List<Offer> entities = offerService.findAll();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<OfferDTO>>(HttpStatus.NO_CONTENT);
        }

        List<OfferDTO> dtos = offerFacade.getAll();
        return new ResponseEntity<List<OfferDTO>>(dtos,HttpStatus.OK);
    }
}
