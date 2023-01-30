package oumeima.stage.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicule")
@Data


public class Vehicule {


    @Id
    @Column(name = "imatriculation")
    private int immatriculation ;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Column(name = "marque")
    private String marque;

    @Column(name = "TypeCarburant")
    private String typeCarburant;

    @Column(name = "PuissanceFiscale")
    private int PuissanceFiscale;

    @Column(name = "NbPlaces")
    private int nb_places;

    @OneToMany
    private List<Vidange> vidanges;

    @OneToMany
    private List<EntretienPneu> entretienPneus ;

    @OneToMany(mappedBy = "vehicule")
    private List<Reparation> reparations;

    @Override
    public String toString() {
        return "Vehicule{" +
                "immatriculation=" + immatriculation +
                ", marque='" + marque + '\'' +
                ", typeCarburant='" + typeCarburant + '\'' +
                ", PuissanceFiscale=" + PuissanceFiscale +
                ", nb_places=" + nb_places +
                ", vidanges=" + vidanges +
                ", entretienPneus=" + entretienPneus +
                ", reparations=" + reparations +
                '}';
    }

    public Vehicule() {
    }


    public int getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(String typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public int getPuissanceFiscale() {
        return PuissanceFiscale;
    }

    public void setPuissanceFiscale(int puissanceFiscale) {
        PuissanceFiscale = puissanceFiscale;
    }

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    public Vehicule(int immatriculation, String marque, String typeCarburant, int puissanceFiscale, int nb_places) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.typeCarburant = typeCarburant;
        PuissanceFiscale = puissanceFiscale;
        this.nb_places = nb_places;
    }
}
