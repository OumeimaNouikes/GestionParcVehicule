package oumeima.stage.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

@Table(name = "CarteCarburant")
public class CarteCarburant {


    @Id
    @Column(name = "libelleCarte")
    private String libelleCarte;



    public CarteCarburant(String libelleCarte) {
        this.libelleCarte = libelleCarte;
    }

    public String getLibelleCarte() {
        return libelleCarte;
    }

    public void setLibelleCarte(String libelleCarte) {
        this.libelleCarte = libelleCarte;
    }

    public CarteCarburant() {
    }
}
