package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.EntretienPneu;
import oumeima.stage.Models.Fournisseur;
import oumeima.stage.Repositories.EntretienPneuRepository;
import oumeima.stage.Repositories.FournisseurRepository;
import oumeima.stage.Service.EntretienPneuService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntretienPneuServiceImplem implements EntretienPneuService {
    @Autowired
    EntretienPneuRepository entretienPneuRepository;


    @Override
    public List<EntretienPneu> getEntretienPneus() {
        List<EntretienPneu> EntretienPneus = new ArrayList<>();
        entretienPneuRepository.findAll().forEach(EntretienPneus::add);
        return EntretienPneus;
    }



    @Override
    public EntretienPneu getEntretienPneuById(Integer id) {

        return entretienPneuRepository.findById(id).get();
    }

    @Override
    public EntretienPneu insertEntretienPneu (EntretienPneu fournisseur) {
        return entretienPneuRepository.save(fournisseur);
    }

    @Override
    public void updateEntretienPneu (Integer id, EntretienPneu f) {
        EntretienPneu EntretienPneuFromDb = entretienPneuRepository.findById(id).get();
        System.out.println(EntretienPneuFromDb.toString());
        EntretienPneuFromDb.setIdEntretien(f.getIdEntretien());
        EntretienPneuFromDb.setModelePneu(f.getModelePneu());
        EntretienPneuFromDb.setNbPneuChange(f.getNbPneuChange());
        EntretienPneuFromDb.setDateChangementPneu(f.getDateChangementPneu());
        EntretienPneuFromDb.setIndexChangementPneu(f.getIndexChangementPneu());
        EntretienPneuFromDb.setMontant(f.getMontant());
        EntretienPneuFromDb.setVehicule(f.getVehicule());
        entretienPneuRepository.save(EntretienPneuFromDb);
    }

    @Override
    public void deleteEntretienPneu(Integer id) {
        entretienPneuRepository.deleteById(id);
    }
}
