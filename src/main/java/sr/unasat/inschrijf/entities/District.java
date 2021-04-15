package sr.unasat.inschrijf.entities;

import javax.persistence.*;

@Entity(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private long districtId;
    @Column(updatable = false)
    private String naam;

    public District(long districtId, String naam) {
        this.districtId = districtId;
        this.naam = naam;
    }

    public District() {
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
}
