package sr.unasat.inschrijf.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "inschrijving")
public class Inschrijving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inschrijving_id")
    private long inschrijvingId;
    @OneToOne()
    @JoinColumn(name = "gegevens_id")
    private NawGegevens gegevens;
    @ManyToOne()
    @JoinColumn(name = "school_id")
    private School school;
    @Column(name = "created_date")
    private LocalDate createdDate;

    public Inschrijving(long inschrijvingId, NawGegevens gegevens, School school, LocalDate createdDate) {
        this.inschrijvingId = inschrijvingId;
        this.gegevens = gegevens;
        this.school = school;
        this.createdDate = createdDate;
    }

    public Inschrijving() {
    }

    public long getInschrijvingId() {
        return inschrijvingId;
    }

    public void setInschrijvingId(long inschrijvingId) {
        this.inschrijvingId = inschrijvingId;
    }

    public NawGegevens getGegevens() {
        return gegevens;
    }

    public void setGegevens(NawGegevens gegevens) {
        this.gegevens = gegevens;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
