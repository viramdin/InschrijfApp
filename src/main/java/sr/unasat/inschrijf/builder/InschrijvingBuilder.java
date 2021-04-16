package sr.unasat.inschrijf.builder;

import sr.unasat.inschrijf.entities.Kosten;
import sr.unasat.inschrijf.entities.Inschrijving;
import sr.unasat.inschrijf.entities.NawGegevens;
import sr.unasat.inschrijf.entities.School;

import java.time.LocalDate;
import java.util.List;

public class InschrijvingBuilder {
    public NawGegevens gegevens;
    public School school;
    public LocalDate createdDate;

    public List<Kosten> kostenList;

    public InschrijvingBuilder(NawGegevens gegevens, School school, LocalDate createdDate) {
        this.gegevens = gegevens;
        this.school = school;
        this.createdDate = createdDate;
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

    public List<Kosten> getAdditionalList() {
        return kostenList;
    }

    public void setAdditionalList(List<Kosten> kostenList) {
        this.kostenList = kostenList;
    }

    public Inschrijving build() {
        return new Inschrijving(this);
    }
}
