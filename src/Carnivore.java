public abstract class Carnivore extends Poisson {
    protected Carnivore(String nom, String sexe) {
        super(nom, sexe);
    }

    public void manger(Poisson poisson) {
        poisson.seFaitMordre();
        addPV(5);
    }
}
