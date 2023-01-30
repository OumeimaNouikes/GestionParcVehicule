package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oumeima.stage.Models.Vehicule;

import oumeima.stage.Repositories.VehiculeRepository;
import oumeima.stage.Service.VehiculeService;

import java.util.ArrayList;
import java.util.List;
@Service
public class VehiculeServiceImplem implements VehiculeService {


    @Autowired
    VehiculeRepository vehiculeRepository;


    @Override
    public List<Vehicule> getVehicules() {
        List<Vehicule> vehicules = new ArrayList<>();
        vehiculeRepository.findAll().forEach(vehicules::add);
        return vehicules;
    }



    @Override
    public Vehicule getVehiculeById(Integer id) {

        return vehiculeRepository.findById(id).get();
    }

    @Override
    public Vehicule insertVehicule (Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void updateVehicule (Integer id, Vehicule veh) {
        Vehicule VehiculeFromDb = vehiculeRepository.findById(id).get();
        System.out.println(VehiculeFromDb.toString());
        VehiculeFromDb.setImmatriculation(veh.getImmatriculation());
        VehiculeFromDb.setMarque(veh.getMarque());
        VehiculeFromDb.setNb_places(veh.getNb_places());
        VehiculeFromDb.setPuissanceFiscale(veh.getPuissanceFiscale());
        VehiculeFromDb.setTypeCarburant(veh.getTypeCarburant());
        vehiculeRepository.save(VehiculeFromDb);
    }

    @Override
    public void deleteVehicule(Integer id) {
        vehiculeRepository.deleteById(id);
    }
}
