package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.Reparation;
import oumeima.stage.Models.Vehicule;
import oumeima.stage.Service.ReparationService;
import oumeima.stage.ServiceImplem.VehiculeServiceImplem;

@Controller
public class ReparationController {

    @Autowired
    ReparationService reparationServiceImplem;

    @GetMapping("/reparation")
    public String viewReparation(Model model) {
        model.addAttribute("allreparationlist", reparationServiceImplem.getReparations());
        return "reparation";
    }

    @GetMapping("/addnewreparation")
    public String addNewReparation(Model model) {
        Reparation reparation = new Reparation();
        model.addAttribute("reparation", reparation);
        return "newreparation";
    }

    @PostMapping("/savereparation")
    public String saveReparation(@ModelAttribute("reparation") Reparation reparation) {
        reparationServiceImplem.insertReparation(reparation);
        return "redirect:/reparation";
    }

    @GetMapping("/showFormForUpdateReparation/{id}")
    public String updateFormReparation(@PathVariable(value = "id") Integer id, Model model) {
        Reparation reparation = reparationServiceImplem.getReparationById(id);
        model.addAttribute("vehicule", reparation);
        return "updatereparation";
    }

    @GetMapping("/deleteReparation/{id}")
    public String deleteThroughIdReparation(@PathVariable(value = "id") Integer id) {
        reparationServiceImplem.deleteReparation(id);
        return "redirect:/reparation";
    }
}
