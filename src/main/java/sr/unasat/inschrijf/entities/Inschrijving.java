package sr.unasat.inschrijf.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "inschrijving")
public class Inschrijving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inschrijving_id")
    private long inschrijvingId;
    @Column(name = "gegevens_id")
    private long gegevensId;
    @Column(name = "school_id")
    private long schoolId;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @OneToOne
    @JoinColumn(name = "gegevens_id", referencedColumnName = "gegevens_id")
    private NawGegevens nawGegevens;
    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    private List<School> schools;

    public Inschrijving(long inschrijvingId, long gegevensId, long schoolId, LocalDate createdDate, NawGegevens nawGegevens, List<School> schools) {
        this.inschrijvingId = inschrijvingId;
        this.gegevensId = gegevensId;
        this.schoolId = schoolId;
        this.createdDate = createdDate;
        this.nawGegevens = nawGegevens;
        this.schools = schools;
    }

    public long getInschrijvingId() {
        return inschrijvingId;
    }

    public void setInschrijvingId(long inschrijvingId) {
        this.inschrijvingId = inschrijvingId;
    }

    public long getGegevensId() {
        return gegevensId;
    }

    public void setGegevensId(long gegevensId) {
        this.gegevensId = gegevensId;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public NawGegevens getNawGegevens() {
        return nawGegevens;
    }

    public void setNawGegevens(NawGegevens nawGegevens) {
        this.nawGegevens = nawGegevens;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "Inschrijving{" +
                "inschrijvingId=" + inschrijvingId +
                ", gegevensId=" + gegevensId +
                ", schoolId=" + schoolId +
                ", createdDate=" + createdDate +
                ", nawGegevens=" + nawGegevens +
                ", schools=" + schools +
                '}';
    }
}
