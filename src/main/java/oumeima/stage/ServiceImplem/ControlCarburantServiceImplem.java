package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.ControlCarburant;
import oumeima.stage.Repositories.ControlCarburantRepository;
import oumeima.stage.Service.ControlCarburantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControlCarburantServiceImplem implements ControlCarburantService {

    @Autowired
    ControlCarburantRepository controlCarburantRepository;



    @Override
    public List<ControlCarburant> getSuiviCarburants() {
        List<ControlCarburant> suiviCarburants = new ArrayList<>();
        controlCarburantRepository.findAll().forEach(suiviCarburants::add);
        return suiviCarburants;
    }



    @Override
    public ControlCarburant getSuiviCarburantById(Integer id) {

        return controlCarburantRepository.findById(id).get();
    }

    @Override
    public ControlCarburant insertSuiviCarburant (ControlCarburant suiviCarburant) {
        return controlCarburantRepository.save(suiviCarburant);
    }

    @Override
    public void updateSuiviCarburant (Integer id, ControlCarburant veh) {
        ControlCarburant SuiviCarburantFromDb = controlCarburantRepository.findById(id).get();
        System.out.println(SuiviCarburantFromDb.toString());
        SuiviCarburantFromDb.setId(veh.getId());
        SuiviCarburantFromDb.setDateChargementCarburant(veh.getDateChargementCarburant());
        SuiviCarburantFromDb.setIndexChargementCarburant(veh.getIndexChargementCarburant());
        SuiviCarburantFromDb.setMontantVerse(veh.getMontantVerse());
        SuiviCarburantFromDb.setCarteCarburant(veh.getCarteCarburant());
        SuiviCarburantFromDb.setVehicule(veh.getVehicule());
        controlCarburantRepository.save(SuiviCarburantFromDb);
    }

    @Override
    public void deleteSuiviCarburant(Integer id) {
        controlCarburantRepository.deleteById(id);
    }
}


