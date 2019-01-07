package swengs.therapiedb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swengs.therapiedb.model.animal.Species;
import swengs.therapiedb.model.animal.SpeciesRepository;

@Service()
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    public Species getSpecies(Long id) {
        Species species = speciesRepository.findById(id).get();
        return species;
    }
}
