package oumeima.stage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oumeima.stage.Models.Vidange;
import oumeima.stage.ServiceImplem.VidangeServiceImplem;

@Controller
public class VidangeController {


    @Autowired
    VidangeServiceImplem vidangeServiceImplem;

    @GetMapping("/vidange")
    public String viewVidange(Model model) {
        model.addAttribute("allvidangelist", vidangeServiceImplem.getVidanges());
        return "vidange";
    }

    @GetMapping("/addnewvidange")
    public String addNewVidange(Model model) {
        Vidange vidange = new Vidange();
        model.addAttribute("vidange", vidange);
        return "newvidange";
    }

    @PostMapping("/savevidange")
    public String saveVidange(@ModelAttribute("vidange") Vidange vidange) {
        vidangeServiceImplem.insertVidange(vidange);
        return "redirect:/vidange";
    }

    @GetMapping("/showFormForUpdateVidange/{id}")
    public String updateFormVidange(@PathVariable(value = "id") Integer id, Model model) {
        Vidange vidange = vidangeServiceImplem.getVidangeById(id);
        model.addAttribute("vidange", vidange);
        return "updatevidange";
    }

    @GetMapping("/deleteVidange/{id}")
    public String deleteThroughIdVidange(@PathVariable(value = "id") Integer id) {
        vidangeServiceImplem.deleteVidange(id);
        return "redirect:/vidange";
    }
}
