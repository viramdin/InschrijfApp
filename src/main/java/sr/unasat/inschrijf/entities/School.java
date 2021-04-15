package sr.unasat.inschrijf.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private long schoolId;
    @Column(name = "niveau_id")
    private long niveauId;
    @Column(name = "district_id")
    private long districtId;
    @Column
    private String naam;
    @Column
    private String adres;
    @Column
    private String omschrijving;
    @ManyToOne
    @JoinColumn(name = "niveau_id", referencedColumnName = "niveau_id")
    private List<SchoolNiveau> schoolNiveaus;
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    private List<District> districts;

    public School(long schoolId, long niveauId, long districtId, String naam, String adres, String omschrijving, List<SchoolNiveau> schoolNiveaus, List<District> districts) {
        this.schoolId = schoolId;
        this.niveauId = niveauId;
        this.districtId = districtId;
        this.naam = naam;
        this.adres = adres;
        this.omschrijving = omschrijving;
        this.schoolNiveaus = schoolNiveaus;
        this.districts = districts;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public long getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(long niveauId) {
        this.niveauId = niveauId;
    }

    public long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(long districtId) {
        this.districtId = districtId;
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

    public List<SchoolNiveau> getSchoolNiveaus() {
        return schoolNiveaus;
    }

    public void setSchoolNiveaus(List<SchoolNiveau> schoolNiveaus) {
        this.schoolNiveaus = schoolNiveaus;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", niveauId=" + niveauId +
                ", districtId=" + districtId +
                ", naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", omschrijving='" + omschrijving + '\'' +
                ", schoolNiveaus=" + schoolNiveaus +
                ", districts=" + districts +
                '}';
    }
}
