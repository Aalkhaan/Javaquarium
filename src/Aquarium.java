import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final List<Poisson> poissons;

    public Aquarium() {
        algues = new ArrayList<>();
        poissons = new ArrayList<>();
    }

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    public void nouveauTour() {

        for (Poisson poisson : poissons) {
            int randomIndice;
            if (poissons.size() > 1 && poisson instanceof Carnivore) {
                randomIndice = getRandomIndex(poissons);
                Poisson randomPoisson = poissons.get(randomIndice);
                while (randomPoisson == poisson) {
                    randomIndice = getRandomIndex(poissons);
                    randomPoisson = poissons.get(randomIndice);
                }
                ((Carnivore) poisson).manger(randomPoisson);
            } else if (algues.size() > 0) {
                randomIndice = getRandomIndex(algues);
                Algue randomAlgue = algues.get(randomIndice);
                ((Herbivore) poisson).manger(randomAlgue);
            }
        }
        System.out.println("Nombre d'algues : " + algues.size());
        System.out.println("Poissons : " + poissons);

    }

    private int getRandomIndex(Collection<?> collection) {
        return new Random().nextInt(collection.size() - 1);
    }
}
