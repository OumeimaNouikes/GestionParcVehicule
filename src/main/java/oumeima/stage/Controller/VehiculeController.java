package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.Fournisseur;
import oumeima.stage.Models.Vehicule;
import oumeima.stage.ServiceImplem.FournisseurServiceImplem;
import oumeima.stage.ServiceImplem.VehiculeServiceImplem;

@Controller
public class VehiculeController {



    @Autowired
    VehiculeServiceImplem vehiculeServiceImplem;

    @GetMapping("/vehicule")
    public String viewVehicule(Model model) {
        model.addAttribute("allvehiculelist", vehiculeServiceImplem.getVehicules());
        return "vehicule";
    }

    @GetMapping("/addnewvehicule")
    public String addNewVehicule(Model model) {
        Vehicule vehicule = new Vehicule();
        model.addAttribute("vehicule", vehicule);
        return "newvehicule";
    }

    @PostMapping("/savevehicule")
    public String saveVehicule(@ModelAttribute("vehicule") Vehicule vehicule) {
        vehiculeServiceImplem.insertVehicule(vehicule);
        return "redirect:/vehicule";
    }

    @GetMapping("/showFormForUpdateVehicule/{id}")
    public String updateFormVehicule(@PathVariable(value = "id") Integer id, Model model) {
        Vehicule vehicule = vehiculeServiceImplem.getVehiculeById(id);
        model.addAttribute("vehicule", vehicule);
        return "updatevehicule";
    }

    @GetMapping("/deleteVehicule/{id}")
    public String deleteThroughIdVehicule(@PathVariable(value = "id") Integer id) {
        vehiculeServiceImplem.deleteVehicule(id);
        return "redirect:/vehicule";
    }
}
