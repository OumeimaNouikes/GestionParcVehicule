package oumeima.stage.Service;

import oumeima.stage.Models.Fournisseur;

import java.util.List;

public interface FournisseurService {
    public List<Fournisseur> getFournisseurs();

    public Fournisseur getFournisseurById(Integer id);

    public Fournisseur insertFournisseur(Fournisseur f);

    public void updateFournisseur(Integer id, Fournisseur f);

    public void deleteFournisseur(Integer id);
}
