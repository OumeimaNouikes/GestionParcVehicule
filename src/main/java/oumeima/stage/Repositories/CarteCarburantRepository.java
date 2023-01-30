package oumeima.stage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import oumeima.stage.Models.CarteCarburant;

public interface CarteCarburantRepository extends JpaRepository<CarteCarburant,String> {
}
