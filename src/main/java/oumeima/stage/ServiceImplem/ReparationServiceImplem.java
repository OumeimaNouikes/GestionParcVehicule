package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.Reparation;
import oumeima.stage.Repositories.ReparationRepository;
import oumeima.stage.Service.ReparationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReparationServiceImplem implements ReparationService {

    @Autowired
    ReparationRepository reparationRepository;


    @Override
    public List<Reparation> getReparations() {
        List<Reparation> reparations = new ArrayList<>();
        reparationRepository.findAll().forEach(reparations::add);
        return reparations;
    }

    @Override
    public Reparation getReparationById(Integer id) {

        return reparationRepository.findById(id).get();
    }

    @Override
    public Reparation insertReparation (Reparation rep) {
        return reparationRepository.save(rep);
    }

    @Override
    public void updateReparation (Integer id, Reparation r) {
        Reparation reparationFromDb = reparationRepository.findById(id).get();
        System.out.println(reparationFromDb.toString());
        reparationFromDb.setIdReparation(r.getIdReparation());
        reparationFromDb.setDateRep(r.getDateRep());
        reparationFromDb.setDateMiseEnService(r.getDateMiseEnService());
        reparationFromDb.setDepenses(r.getDepenses());

        reparationFromDb.setNatureRep(r.getNatureRep());
        reparationRepository.save(reparationFromDb);
    }

    @Override
    public void deleteReparation(Integer id) {
        reparationRepository.deleteById(id);
    }
}
