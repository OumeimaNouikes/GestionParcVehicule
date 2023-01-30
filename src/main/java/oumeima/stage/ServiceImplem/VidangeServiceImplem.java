package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.Vidange;
import oumeima.stage.Repositories.VidangeRepository;
import oumeima.stage.Service.VidangeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VidangeServiceImplem implements VidangeService {
    @Autowired
    VidangeRepository vidangeRepository;

    @Override
    public List<Vidange> getVidanges() {
        List<Vidange> vidanges = new ArrayList<>();
        vidangeRepository.findAll().forEach(vidanges::add);
        return vidanges;
    }

    @Override
    public Vidange getVidangeById(Integer id) {
        return vidangeRepository.findById(id).get();
    }

    @Override
    public Vidange insertVidange(Vidange vidange) {
        return vidangeRepository.save(vidange);
    }

    @Override
    public void updateVidange(Integer id, Vidange v) {
        Vidange vidangeFromDb = vidangeRepository.findById(id).get();
        System.out.println(vidangeFromDb.toString());
        vidangeFromDb.setDate_vidange(v.getDate_vidange());
        vidangeFromDb.setFiltre_air(v.getFiltre_air());
        vidangeFromDb.setFiltre_gaz(v.getFiltre_gaz());
        vidangeFromDb.setHuile(v.getHuile());
        vidangeFromDb.setFiltre_h(v.getFiltre_h());
        vidangeFromDb.setMontant(v.getMontant());
        vidangeFromDb.setVehicule(v.getVehicule());
        vidangeRepository.save(vidangeFromDb);
    }

    @Override
    public void deleteVidange(Integer id) {

        vidangeRepository.deleteById(id);
    }


}
