package oumeima.stage.Service;

import oumeima.stage.Models.Vehicule;

import java.util.List;

public interface VehiculeService {

    public List<Vehicule> getVehicules();

    public Vehicule getVehiculeById(Integer imma);

    public Vehicule insertVehicule(Vehicule v);

    public void updateVehicule(Integer imma, Vehicule v);

    public void deleteVehicule(Integer imma);
}
