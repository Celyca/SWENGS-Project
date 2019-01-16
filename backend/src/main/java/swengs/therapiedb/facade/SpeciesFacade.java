package swengs.therapiedb.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swengs.therapiedb.dto.SpeciesDTO;
import swengs.therapiedb.model.animal.Species;
import swengs.therapiedb.service.SpeciesService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SpeciesFacade {

    @Autowired
    private SpeciesService speciesService;

    // ---------------------------------------------------------------------------------

    private void mapEntityToDto(Species entity, SpeciesDTO dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

    // ---------------------------------------------------------------------------------

    public List<SpeciesDTO> getAll() {
        List<SpeciesDTO> dtos = new ArrayList<>();
        speciesService.findAll().forEach(entity -> {
            SpeciesDTO dto = new SpeciesDTO();
            mapEntityToDto(entity, dto);
            dtos.add(dto);
        });
        return dtos;
    }


}
