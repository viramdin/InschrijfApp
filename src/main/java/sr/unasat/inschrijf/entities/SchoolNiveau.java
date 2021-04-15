package sr.unasat.inschrijf.entities;

import javax.persistence.*;

@Entity
@Table(name = "school_niveau")
public class SchoolNiveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "niveau_id")
    private long niveauId;
    @Column
    private String naam;
    @Column
    private double prijs;

    public SchoolNiveau(long niveauId, String naam, double prijs) {
        this.niveauId = niveauId;
        this.naam = naam;
        this.prijs = prijs;
    }

    public long getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(long niveauId) {
        this.niveauId = niveauId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public String toString() {
        return "SchoolNiveau{" +
                "niveauId=" + niveauId +
                ", naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}
