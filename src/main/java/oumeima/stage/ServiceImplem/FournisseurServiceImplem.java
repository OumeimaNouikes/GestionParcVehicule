package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.Fournisseur;
import oumeima.stage.Repositories.FournisseurRepository;
import oumeima.stage.Service.FournisseurService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FournisseurServiceImplem implements FournisseurService {
    @Autowired
    FournisseurRepository fournisseurRepository;


    @Override
    public List<Fournisseur> getFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurRepository.findAll().forEach(fournisseurs::add);
        return fournisseurs;
    }



    @Override
    public Fournisseur getFournisseurById(Integer id) {

        return fournisseurRepository.findById(id).get();
    }

    @Override
    public Fournisseur insertFournisseur (Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void updateFournisseur (Integer id, Fournisseur f) {
        Fournisseur fournisseurFromDb = fournisseurRepository.findById(id).get();
        System.out.println(fournisseurFromDb.toString());
        fournisseurFromDb.setIdFournisseur(f.getIdFournisseur());
        fournisseurFromDb.setAdresse(f.getAdresse());
        fournisseurFromDb.setNom(f.getNom());
        fournisseurFromDb.setTelephone(f.getTelephone());
        fournisseurRepository.save(fournisseurFromDb);
    }

    @Override
    public void deleteFournisseur(Integer id) {
        fournisseurRepository.deleteById(id);
    }

}
