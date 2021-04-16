package sr.unasat.inschrijf.kosten;

public class BusKosten extends KostenDecorator {
    final double prijs = 500;

    public BusKosten(Kosten newKosten) {
        super(newKosten);
    }

    @Override
    public double getPrijs() {
        return prijs;
    }
}
