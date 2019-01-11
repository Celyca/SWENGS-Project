package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.animal.Species;
import swengs.therapiedb.model.animal.SpeciesRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service()
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    // ---------------------------------------------------------------------------------

    public Optional<Species> findById(Long id) {
        return speciesRepository.findById(id);
    }

    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    // ---------------------------------------------------------------------------------

    public Species getSpecie(Long id) {
        Species entity = findById(id).get();
        return entity;
    }

    public Set<Species> getSpecies(Set<Long> dtos) {
        Set<Species> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(speciesRepository.findById(dto).get()));
        }
        return entities;
    }

    // ---------------------------------------------------------------------------------

}
