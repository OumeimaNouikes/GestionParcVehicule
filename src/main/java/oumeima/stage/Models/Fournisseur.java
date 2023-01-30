package oumeima.stage.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

@Table(name = "Fournisseur")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fournisseur")
    private int idFournisseur;

    @Column(name = "nomFournisseur")
    private String nom;
    @Column(name = "AdresseFournisseur")
    private String adresse;

    @Column(name = "TelFournisseur")
    private int Telephone;

	@OneToMany(mappedBy = "fournisseur")
	private List<Reparation> reparartions;
    

	public Fournisseur() {
		super();
	}

	public Fournisseur(int idFournisseur, String nom, String adresse, int telephone) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.adresse = adresse;
		Telephone = telephone;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return Telephone;
	}

	public void setTelephone(int telephone) {
		Telephone = telephone;
	}
    
    
    
}
