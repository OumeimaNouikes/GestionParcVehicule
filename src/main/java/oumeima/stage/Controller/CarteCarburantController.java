package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import oumeima.stage.Models.CarteCarburant;

import oumeima.stage.ServiceImplem.CarteCarburantserviceImplem;


@Controller
public class CarteCarburantController {
    @Autowired
    CarteCarburantserviceImplem carteCarburantserviceImplem;

    @GetMapping("/cartecarburant")
    public String viewCarteCarburant(Model model) {
        model.addAttribute("allcarburantlist", carteCarburantserviceImplem.getCarteCarburants());
        return "cartecarburant";
    }

    @GetMapping("/addnewcartecarburant")
    public String addNewCarteCarburant(Model model) {
        CarteCarburant carteCarburant = new CarteCarburant();
        model.addAttribute("carteCarburant", carteCarburant);
        return "newcartecarburant";
    }

    @PostMapping("/savecartecarburant")
    public String savecarteCarburant(@ModelAttribute("carteCarburant") CarteCarburant carteCarburant) {
        carteCarburantserviceImplem.insertCarteCarburant(carteCarburant);
        return "redirect:/cartecarburant";
    }

    @GetMapping("/showFormForUpdatecartecarburant/{id}")
    public String updateFormcarteCarburant(@PathVariable(value = "id") String id, Model model) {
        CarteCarburant carteCarburant = carteCarburantserviceImplem.getCarteCarburantById(id);
        model.addAttribute("carteCarburant", carteCarburant);
        return "updatecartecarburant";
    }
    @GetMapping("/deletecartecarburant/{id}")
    public String deleteThroughIdCarteCarburant(@PathVariable(value = "id") String id) {
        carteCarburantserviceImplem.deleteCarteCarburant(id);
        return "redirect:/cartecarburant";
    }
}
