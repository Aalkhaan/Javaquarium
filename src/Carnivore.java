import java.util.Objects;

public abstract class Carnivore extends Poisson {
    protected Carnivore(String nom, String sexe) {
        super(nom, sexe);
    }

    @Override
    public void manger() {

    }

    public void manger(Poisson poisson) {
        poisson.seFaitMordre();
        addPV(5);
    }

    public boolean peutManger(Poisson poisson) {
        return !Objects.equals(getNom(), poisson.getNom()) || getClass() != poisson.getClass();
    }
}
