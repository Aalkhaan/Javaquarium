public class Algue extends Vivant {
    @Override
    public boolean seFaitMordre() {
        return removePV(2);
    }

    @Override
    public String toString() {
        return "Algue, " + getPV() + " PVs";
    }
}
