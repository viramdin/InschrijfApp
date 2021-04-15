package sr.unasat.inschrijf.entities;

import javax.persistence.*;

@Entity(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private long schoolId;
    @ManyToOne()
    @JoinColumn(name = "district_id")
    private District district;
    @ManyToOne()
    @JoinColumn(name = "niveau_id")
    private SchoolNiveau schoolNiveau;
    private String naam;
    private String adres;
    private String omschrijving;

    public School(long schoolId, District district, SchoolNiveau schoolNiveau, String naam, String adres, String omschrijving) {
        this.schoolId = schoolId;
        this.district = district;
        this.schoolNiveau = schoolNiveau;
        this.naam = naam;
        this.adres = adres;
        this.omschrijving = omschrijving;
    }

    public School() {
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public SchoolNiveau getSchoolNiveau() {
        return schoolNiveau;
    }

    public void setSchoolNiveau(SchoolNiveau schoolNiveau) {
        this.schoolNiveau = schoolNiveau;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
