public abstract class Herbivore extends Poisson {
    protected Herbivore(String nom, String sexe) {
        super(nom, sexe);
    }

    public void manger(Algue algue) {
        algue.seFaitMordre();
        addPV(3);
    }
}
