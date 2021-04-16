package sr.unasat.inschrijf.entities;

public class Kosten {
    private String naam;
    private Double prijs;

    public Kosten(String naam, Double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public Kosten() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }
}
