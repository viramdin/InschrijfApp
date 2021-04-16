package sr.unasat.inschrijf.kosten;

public class StandaardKosten implements Kosten {
    final double prijs = 0;

    @Override
    public double getPrijs() {
        return prijs;
    }
}
