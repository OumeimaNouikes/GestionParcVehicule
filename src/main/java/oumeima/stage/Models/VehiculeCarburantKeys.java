package oumeima.stage.Models;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class VehiculeCarburantKeys implements Serializable {

    @OneToOne
    private CarteCarburant carteCarburant;

    @OneToOne
    private Vehicule vehicule;

    public VehiculeCarburantKeys(CarteCarburant carteCarburant, Vehicule vehicule) {
        this.carteCarburant = carteCarburant;
        this.vehicule = vehicule;
    }

    public VehiculeCarburantKeys() {
    }
}
