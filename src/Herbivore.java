import java.util.List;
import java.util.Random;

public abstract class Herbivore extends Poisson {
    protected Herbivore(String nom, String sexe, Aquarium aquarium) {
        super(nom, sexe, aquarium);
    }

    @Override
    public void manger() {
        List<Algue> algues = getAlgues();
        if (!algues.isEmpty()) {
            int randomIndex = new Random().nextInt(algues.size());
            manger(algues.get(randomIndex));
        }
    }

    public void manger(Algue algue) {
        algue.seFaitMordre();
        addPV(3);
    }
}
