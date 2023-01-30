package oumeima.stage.Service;

import oumeima.stage.Models.CarteCarburant;
import oumeima.stage.Models.Fournisseur;

import java.util.List;

public interface CarteCarburantService {


    public List<CarteCarburant> getCarteCarburants();

    public CarteCarburant getCarteCarburantById(String id);

    public CarteCarburant insertCarteCarburant(CarteCarburant f);

    public void updateCarteCarburant(String id, CarteCarburant f);

    public void deleteCarteCarburant(String id);
}
