package oumeima.stage.ServiceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oumeima.stage.Models.CarteCarburant;
import oumeima.stage.Repositories.CarteCarburantRepository;
import oumeima.stage.Service.CarteCarburantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarteCarburantserviceImplem implements CarteCarburantService {

    @Autowired
    CarteCarburantRepository carteCarburantRepository;


    @Override
    public List<CarteCarburant> getCarteCarburants() {
        List<CarteCarburant> CarteCarburants = new ArrayList<>();
        carteCarburantRepository.findAll().forEach(CarteCarburants::add);
        return CarteCarburants;
    }

    @Override
    public CarteCarburant getCarteCarburantById (String id) {

        return carteCarburantRepository.findById(id).get();
    }

    @Override
    public CarteCarburant insertCarteCarburant (CarteCarburant carte) {
        return carteCarburantRepository.save(carte);
    }

    @Override
    public void updateCarteCarburant (String id, CarteCarburant f) {
        CarteCarburant carteCarburantFromDb = carteCarburantRepository.findById(id).get();
        System.out.println(carteCarburantFromDb.toString());
        carteCarburantFromDb.setLibelleCarte(f.getLibelleCarte());

        carteCarburantRepository.save(carteCarburantFromDb);
    }

    @Override
    public void deleteCarteCarburant(String id) {
        carteCarburantRepository.deleteById(id);
    }


}
