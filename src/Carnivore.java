import java.util.Random;

public abstract class Carnivore extends Poisson {
    protected Carnivore(String nom, Sexe sexe, Espece espece, Aquarium aquarium) {
        super(nom, sexe, espece, aquarium);
    }

    protected Carnivore(String nom, Sexe sexe, Espece espece, Aquarium aquarium, int age) {
        super(nom, sexe, espece, aquarium, age);
    }

    @Override
    public void manger() {
        PoissonMap mapPoissons = getMapPoissons();
        Espece especeAManger = EspeceManager.getRandomEspece(mapPoissons, getEspece());
        if (especeAManger != null) {
            int randomIndex = new Random().nextInt(mapPoissons.get(especeAManger).size());
            if (manger(mapPoissons.get(especeAManger).get(randomIndex))) {
                mapPoissons.get(especeAManger).remove(randomIndex);
            }
        }
    }

    public boolean manger(Poisson poisson) {
        addPV(5);
        return poisson.seFaitMordre();
    }
}
