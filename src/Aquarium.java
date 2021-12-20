import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Aquarium {
    private final List<Algue> algues;
    private final Set<Poisson> poissons;

    public Aquarium() {
        algues = new LinkedList<>();
        poissons = new HashSet<Poisson>();
    }

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    public void nouveauTour() {
        System.out.println("Nombre d'algues : " + algues.size());
        System.out.println("Poissons : " + poissons);
    }
}
