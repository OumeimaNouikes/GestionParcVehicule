package oumeima.stage.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Reparartion")
public class Reparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Rep")
    private int idReparation;
    @Column(name = "Date_Rep")
    private Date dateRep;
    @Column(name = "Nature_rep")
    private String natureRep;
    @Column(name = "DateMiseEnService")
    private Date dateMiseEnService;
    @Column(name = "Depenses")
    private double Depenses;

    public Reparation() {
    }

    public Reparation(int idReparation, Date dateRep, String natureRep, Date dateMiseEnService, double depenses, Vehicule vehicule, Fournisseur fournisseur) {
        this.idReparation = idReparation;
        this.dateRep = dateRep;
        this.natureRep = natureRep;
        this.dateMiseEnService = dateMiseEnService;
        this.Depenses=Depenses;
        this.vehicule = vehicule;
        this.fournisseur = fournisseur;
    }

    public int getIdReparation() {
        return idReparation;
    }

    public void setIdReparation(int idReparation) {
        this.idReparation = idReparation;
    }

    public Date getDateRep() {
        return dateRep;
    }

    public void setDateRep(Date dateRep) {
        this.dateRep = dateRep;
    }

    public String getNatureRep() {
        return natureRep;
    }

    public void setNatureRep(String natureRep) {
        this.natureRep = natureRep;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public double getDepenses() {
        return Depenses;
    }

    public void setDepenses(double depenses) {
        Depenses = depenses;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    @ManyToOne
    private Vehicule vehicule;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_fournisseur")
    private Fournisseur fournisseur;
}
