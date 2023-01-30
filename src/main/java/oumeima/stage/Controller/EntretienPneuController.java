package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.EntretienPneu;
import oumeima.stage.Models.Vidange;
import oumeima.stage.ServiceImplem.EntretienPneuServiceImplem;
import oumeima.stage.ServiceImplem.VidangeServiceImplem;
@Controller
public class EntretienPneuController {

    @Autowired
    EntretienPneuServiceImplem entretienPneuServiceImplem;

    @GetMapping("/EntretienPneu")
    public String viewEntretienPneu(Model model) {
        model.addAttribute("allEntretienPneulist", entretienPneuServiceImplem.getEntretienPneus());
        return "EntretienPneu";
    }

    @GetMapping("/addnewEntretienPneu")
    public String addNewEntretienPneu(Model model) {
        EntretienPneu entretienPneu = new EntretienPneu();
        model.addAttribute("entretienPneu", entretienPneu);
        return "newEntretienPneu";
    }

    @PostMapping("/saveentretienPneu")
    public String saveEntretienPneu(@ModelAttribute("entretienPneu") EntretienPneu entretienPneu) {
        entretienPneuServiceImplem.insertEntretienPneu(entretienPneu);
        return "redirect:/EntretienPneu";
    }

    @GetMapping("/showFormForUpdateEntretienpneu/{id}")
    public String updateFormEntretienPneu(@PathVariable(value = "id") Integer id, Model model) {
        EntretienPneu entretienPneu = entretienPneuServiceImplem.getEntretienPneuById(id);
        model.addAttribute("entretienPneu", entretienPneu);
        return "updateEntretienPneu";
    }

    @GetMapping("/deleteEntretienPneu/{id}")
    public String deleteThroughIdEntretienPneu(@PathVariable(value = "id") Integer id) {
        entretienPneuServiceImplem.deleteEntretienPneu(id);
        return "redirect:/EntretienPneu";
    }
}
