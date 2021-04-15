package sr.unasat.inschrijf.entities;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "naw_gegevens")
public class NawGegevens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gegevens_id")
    private long gegevensId;
    private String familienaam;
    @Column
    private String naam;
    @Column
    private LocalDate dob;
    @Column(name = "id_nummer")
    private String idNummer;
    @Column
    private String geslacht;
    @Column(name = "telefoon_nr")
    private String telefoonNr;
    @Column
    private String email;

    public NawGegevens(long gegevensId, String familienaam, String naam, LocalDate dob, String idNummer, String geslacht, String telefoonNr, String email) {
        this.gegevensId = gegevensId;
        this.familienaam = familienaam;
        this.naam = naam;
        this.dob = dob;
        this.idNummer = idNummer;
        this.geslacht = geslacht;
        this.telefoonNr = telefoonNr;
        this.email = email;
    }

    public long getGegevensId() {
        return gegevensId;
    }

    public void setGegevensId(long gegevensId) {
        this.gegevensId = gegevensId;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getIdNummer() {
        return idNummer;
    }

    public void setIdNummer(String idNummer) {
        this.idNummer = idNummer;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    public String getTelefoonNr() {
        return telefoonNr;
    }

    public void setTelefoonNr(String telefoonNr) {
        this.telefoonNr = telefoonNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NawGegevens{" +
                "gegevensId=" + gegevensId +
                ", familienaam='" + familienaam + '\'' +
                ", naam='" + naam + '\'' +
                ", dob=" + dob +
                ", idNummer='" + idNummer + '\'' +
                ", geslacht='" + geslacht + '\'' +
                ", telefoonNr='" + telefoonNr + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
