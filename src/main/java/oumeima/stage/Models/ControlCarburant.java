package oumeima.stage.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ControlCarburant")
@Data
public class ControlCarburant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "libelleCarte",referencedColumnName = "libelleCarte")
    private CarteCarburant carteCarburant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "immatriculation",referencedColumnName = "imatriculation")
    private Vehicule vehicule;

    @Column(name = "DateChargementCarburant")
    private Date dateChargementCarburant;

    @Column(name = "IndexchargementCarburant")
    private int IndexChargementCarburant;

    @Column(name = "MontantVerse")
    private int MontantVerse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ControlCarburant(int id, CarteCarburant carteCarburant, Vehicule vehicule, Date dateChargementCarburant, int indexChargementCarburant, int montantVerse) {
        this.id = id;
        this.carteCarburant = carteCarburant;
        this.vehicule = vehicule;
        this.dateChargementCarburant = dateChargementCarburant;
        IndexChargementCarburant = indexChargementCarburant;
        MontantVerse = montantVerse;
    }

    public ControlCarburant() {
    }

    public CarteCarburant getCarteCarburant() {
        return carteCarburant;
    }

    public void setCarteCarburant(CarteCarburant carteCarburant) {
        this.carteCarburant = carteCarburant;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getDateChargementCarburant() {
        return dateChargementCarburant;
    }

    public void setDateChargementCarburant(Date dateChargementCarburant) {
        this.dateChargementCarburant = dateChargementCarburant;
    }

    public int getIndexChargementCarburant() {
        return IndexChargementCarburant;
    }

    public void setIndexChargementCarburant(int indexChargementCarburant) {
        IndexChargementCarburant = indexChargementCarburant;
    }

    public int getMontantVerse() {
        return MontantVerse;
    }

    public void setMontantVerse(int montantVerse) {
        MontantVerse = montantVerse;
    }
}
