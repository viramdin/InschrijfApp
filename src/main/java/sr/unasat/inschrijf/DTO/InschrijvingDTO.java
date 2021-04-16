package sr.unasat.inschrijf.DTO;

import sr.unasat.inschrijf.entities.NawGegevens;

import java.time.LocalDate;

public class InschrijvingDTO {
    private long schoolId;
    private NawGegevens gegevens;
    private LocalDate createdDate;
    private int kosten;
    private int betalingMethode;

    public InschrijvingDTO(long schoolId, NawGegevens gegevens, LocalDate createdDate, int kosten, int betalingMethode) {
        this.schoolId = schoolId;
        this.gegevens = gegevens;
        this.createdDate = createdDate;
        this.kosten = kosten;
        this.betalingMethode = betalingMethode;
    }

    public InschrijvingDTO() {
    }

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public NawGegevens getGegevens() {
        return gegevens;
    }

    public void setGegevens(NawGegevens gegevens) {
        this.gegevens = gegevens;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    public int getBetalingMethode() {
        return betalingMethode;
    }

    public void setBetalingMethode(int betalingMethode) {
        this.betalingMethode = betalingMethode;
    }
}
