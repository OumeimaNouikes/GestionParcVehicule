package oumeima.stage.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "vidange")
@Data
public class Vidange {


    @Id
    @GeneratedValue
    @Column(name = "idVidange")
    private int idVidange;

    @Column(name = "DateVidange")
    private Date date_vidange;

    @Column(name = "indexVidange")
    private int index_vidange;

    @Column(name = "Huile")
    private double huile;

    @Column(name = "FiltreAir")
    private int filtre_air;

    @Column(name = "Filtregaz")
    private int filtre_gaz;

    @Column(name = "Filtreh")
    private int filtre_h;

    @Column(name = "montant")
    private float montant;

    public Vidange(int idVidange, Date date_vidange, int index_vidange, double huile, int filtre_air,
                   int filtre_gaz, int filtre_h, float montant, Vehicule vehicule) {
        this.idVidange = idVidange;
        this.date_vidange = date_vidange;
        this.index_vidange = index_vidange;
        this.huile = huile;
        this.filtre_air = filtre_air;
        this.filtre_gaz = filtre_gaz;
        this.filtre_h = filtre_h;
        this.montant = montant;
        this.vehicule = vehicule;
    }

    public Vidange() {
    }

    public int getIdVidange() {
        return idVidange;
    }

    public void setIdVidange(int idVidange) {
        this.idVidange = idVidange;
    }

    public Date getDate_vidange() {
        return date_vidange;
    }

    public void setDate_vidange(Date date_vidange) {
        this.date_vidange = date_vidange;
    }

    public int getIndex_vidange() {
        return index_vidange;
    }

    public void setIndex_vidange(int index_vidange) {
        this.index_vidange = index_vidange;
    }

    public double getHuile() {
        return huile;
    }

    public void setHuile(double huile) {
        this.huile = huile;
    }

    public int getFiltre_air() {
        return filtre_air;
    }

    public void setFiltre_air(int filtre_air) {
        this.filtre_air = filtre_air;
    }

    public int getFiltre_gaz() {
        return filtre_gaz;
    }

    public void setFiltre_gaz(int filtre_gaz) {
        this.filtre_gaz = filtre_gaz;
    }

    public int getFiltre_h() {
        return filtre_h;
    }

    public void setFiltre_h(int filtre_h) {
        this.filtre_h = filtre_h;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @ManyToOne
    @JoinColumn
    private Vehicule vehicule;
}
