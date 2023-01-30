package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import oumeima.stage.Service.VehiculeService;
import oumeima.stage.Service.VidangeService;
import oumeima.stage.ServiceImplem.VehiculeServiceImplem;

@Controller
public class meuniprincipaleController {


    @Autowired
    VehiculeService vehiculeService;
    @Autowired
    VidangeService vidangeService;


    @GetMapping("/menuprincipale")
    public String goToHome(Model model){
        model.addAttribute("NBR_Vehicule", vehiculeService.getVehicules().size());
        model.addAttribute("NBR_Vidange", vidangeService.getVidanges().size());
        return "menuprincipale";

    }

}
