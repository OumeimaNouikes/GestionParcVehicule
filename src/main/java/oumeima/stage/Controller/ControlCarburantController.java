package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.ControlCarburant;
import oumeima.stage.ServiceImplem.ControlCarburantServiceImplem;

@Controller
public class ControlCarburantController {

@Autowired
    ControlCarburantServiceImplem controlCarburantServiceImplem;


    @GetMapping("/suivicarburant")
    public String viewVehicule(Model model) {
        model.addAttribute("allsuiviCarburantlist", controlCarburantServiceImplem.getSuiviCarburants());
        return "suivicarburant";
    }

    @GetMapping("/addnewsuivicarburant")
    public String addNewSuiviCarburant(Model model) {
        ControlCarburant suivicarburant = new ControlCarburant();
        model.addAttribute("suivicarburant", suivicarburant);
        return "newsuivicarburant";
    }

    @PostMapping("/savesuivicarburant")
    public String saveSuiviCarburant(@ModelAttribute("suivicarburant") ControlCarburant suivicarburant) {
        controlCarburantServiceImplem.insertSuiviCarburant(suivicarburant);
        return "redirect:/suivicarburant";
    }

    @GetMapping("/showFormForUpdatesuivicarburant/{id}")
    public String updateFormSuiviCarburant(@PathVariable(value = "id") Integer id, Model model) {
        ControlCarburant suivicarburant = controlCarburantServiceImplem.getSuiviCarburantById(id);
        model.addAttribute("suivicarburant", suivicarburant);
        return "updatesuivicarburant";
    }

    @GetMapping("/deletesuivicarburant/{id}")
    public String deleteThroughIdSuiviCarburant(@PathVariable(value = "id") Integer id) {
        controlCarburantServiceImplem.deleteSuiviCarburant(id);
        return "redirect:/suivicarburant";
    }
}
