package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.Fournisseur;
import oumeima.stage.Service.FournisseurService;
import oumeima.stage.ServiceImplem.FournisseurServiceImplem;

@Controller
public class FournisseurController {
    @Autowired
    FournisseurServiceImplem fournisseurServiceImplem;

    @GetMapping("/fournisseur")
    public String viewFournisseur(Model model) {
        model.addAttribute("allfournisseurlist", fournisseurServiceImplem.getFournisseurs());
        return "fournisseur";
    }

    @GetMapping("/addnew")
    public String addNewFournisseur(Model model) {
        Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur", fournisseur);
        return "newfournisseur";
    }

    @PostMapping("/save")
    public String saveFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
        fournisseurServiceImplem.insertFournisseur(fournisseur);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        Fournisseur fournisseur = fournisseurServiceImplem.getFournisseurById(id);
        model.addAttribute("fournisseur", fournisseur);
        return "update";
    }

    @GetMapping("/deleteFournisseur/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        fournisseurServiceImplem.deleteFournisseur(id);
        return "redirect:/";
    }
}
