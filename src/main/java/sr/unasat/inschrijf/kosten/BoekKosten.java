package sr.unasat.inschrijf.kosten;

public class BoekKosten extends KostenDecorator {
    final double prijs = 1000;

    public BoekKosten(Kosten newKosten) {
        super(newKosten);
    }

    @Override
    public double getPrijs() {
        return prijs;
    }
}
