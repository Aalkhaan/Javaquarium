import java.util.*;

public class Aquarium {
    private final Set<Algue> algues;
    private final Set<Poisson> poissonsSet;

    public Aquarium() {
        algues = new HashSet<>();
        poissonsSet = new HashSet<>();
    }

    public void addPoisson(Poisson poisson) {
        poissonsSet.add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    public void nouveauTour() {
        System.out.println("Nombre d'algues : " + algues.size());
        System.out.println("Poissons : " + poissonsSet);
    }

    public void removePoisson(Poisson poisson) {
        poissonsSet.remove(poisson);
    }

    public Set<Poisson> getPoissonsSet() {
        return poissonsSet;
    }
}
