import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Carnivore extends Poisson {
    protected Carnivore(String nom, String sexe, Aquarium aquarium) {
        super(nom, sexe, aquarium);
    }

    @Override
    public void manger() {
        Map<String, List<Poisson>> mapPoissons = getMapPoissons();
        String especeAManger = new RangeManager().getRandomKey(mapPoissons, getEspece());
        if (especeAManger != null) {
            int randomIndex = new Random().nextInt(mapPoissons.get(especeAManger).size());
            manger(mapPoissons.get(especeAManger).get(randomIndex));
        }
    }

    public void manger(Poisson poisson) {
        poisson.seFaitMordre();
        addPV(5);
    }
}
