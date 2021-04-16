package sr.unasat.inschrijf.kosten;

abstract class KostenDecorator implements Kosten {
    protected Kosten tempKosten;

    public KostenDecorator(Kosten newKosten) {
        this.tempKosten = newKosten;
    }

    @Override
    public double getPrijs() {
        return tempKosten.getPrijs();
    }
}
