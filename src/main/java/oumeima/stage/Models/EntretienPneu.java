package oumeima.stage.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EntretienPneu")
@Data


public class EntretienPneu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEntretien")
    private int IdEntretien;

    @Column(name = "ModelePneu")
    private String ModelePneu;

    @Column(name = "NbPneuChange")
    private int NbPneuChange;

    @Column(name = "IndexChangementPneu")
    private int IndexChangementPneu;

    @Column(name = "DateChangementPneu")
    private Date DateChangementPneu;

    @Column(name = "Montant")
    private float Montant;

    @ManyToOne
    @JoinColumn
    private Vehicule vehicule;

    public EntretienPneu() {

    }

    public EntretienPneu(int idEntretien, String modelePneu, int nbPneuChange, int indexChangementPneu, Date dateChangementPneu, float montant, Vehicule vehicule) {
        IdEntretien = idEntretien;
        ModelePneu = modelePneu;
        NbPneuChange = nbPneuChange;
        IndexChangementPneu = indexChangementPneu;
        DateChangementPneu = dateChangementPneu;
        Montant = montant;
        this.vehicule = vehicule;
    }

    public int getIdEntretien() {
        return IdEntretien;
    }

    public void setIdEntretien(int idEntretien) {
        IdEntretien = idEntretien;
    }

    public String getModelePneu() {
        return ModelePneu;
    }

    public void setModelePneu(String modelePneu) {
        ModelePneu = modelePneu;
    }

    public int getNbPneuChange() {
        return NbPneuChange;
    }

    public void setNbPneuChange(int nbPneuChange) {
        NbPneuChange = nbPneuChange;
    }

    public int getIndexChangementPneu() {
        return IndexChangementPneu;
    }

    public void setIndexChangementPneu(int indexChangementPneu) {
        IndexChangementPneu = indexChangementPneu;
    }

    public Date getDateChangementPneu() {
        return DateChangementPneu;
    }

    public void setDateChangementPneu(Date dateChangementPneu) {
        DateChangementPneu = dateChangementPneu;
    }

    public float getMontant() {
        return Montant;
    }

    public void setMontant(float montant) {
        Montant = montant;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
