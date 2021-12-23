public class Algue extends Vivant {
    private final Aquarium aquarium;

    public Algue(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public Algue(Aquarium aquarium, int PVs) {
        this.aquarium = aquarium;
        setPV(PVs);
    }

    public Algue seReproduire() {
        if (getPV() >= 10) {
            int halfPVs = getPV() >> 1;
            setPV(getPV() - halfPVs);
            return new Algue(aquarium, halfPVs);
        }
        return null;
    }

    @Override
    public boolean seFaitMordre() {
        return removePV(10);
    }

    @Override
    public String toString() {
        return "Algue" + super.toString();
    }
}
