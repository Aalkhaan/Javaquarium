import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final PoissonMap poissonMap;

    public Aquarium() {
        algues = new ArrayList<>();
        poissonMap = new PoissonMap();
    }

    public void addPoisson(Poisson poisson) {
        Espece espece = poisson.getEspece();
        poissonMap.get(espece).add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    public void addAlgue(int n) {
        if (n < 0) throw new IllegalArgumentException("Le nombre de tours doit être positif");
        for (int i = 0; i < n; i++) {
            addAlgue();
        }
    }

    private void alguesGrandissent() {
        for (Algue algue : algues) {
            algue.addPV(1);
        }
    }

    private void melangeEntites() {
        Collections.shuffle(algues);
        for (List<Poisson> list : poissonMap.values()) {
            Collections.shuffle(list);
        }
    }

    public void nouveauTour() {
        melangeEntites();
        alguesGrandissent();

        // Les poissons ont faim et perdent 1 PV. Ceux qui ont moins de 5 PV sont ajoutés
        // à la liste des poissons qui veulent manger.
        LinkedList<Poisson> affames = new LinkedList<>();
        for (List<Poisson> poissons : poissonMap.values()) {
            for (int i = 0; i < poissons.size();) {
                Poisson poisson = poissons.get(i);
                if (poisson.removePV(1)) {
                    poissons.remove(i);
                } else {
                    if (poisson.getpV() <= 5) {
                        affames.add(poisson);
                    }
                    i++;
                }
            }
        }

        for (Poisson poisson : affames) {
            poisson.manger();
        }

        System.out.println(this);
    }

    public void nouveauTour(int n) {
        if (n < 0) throw new IllegalArgumentException("Le nombre de tours doit être positif");
        for (int i = 0; i < n; i++) {
            nouveauTour();
        }
    }

    public void nouveauTourJusquePoissonsMorts(int limite) {
        int i = 0;
        while (!poissonMap.isEmpty() && i < limite) {
            nouveauTour();
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("__________________________________________________________________________________________\n");
        if (algues.isEmpty() && poissonMap.isEmpty()) {
            return "Cet aquarium est vide.";
        }
        if (!algues.isEmpty()) {
            toReturn.append("Cet aquarium contient ").append(algues.size()).append(" algue")
                    .append((algues.size() == 1) ? "" : "s");
        }
        if (!poissonMap.isEmpty()) {
            toReturn.append("\nEt les espèces suivantes de poissons :");
            for (Espece species : poissonMap.keySet()) {
                toReturn.append("\n\n").append(species).append(" :");
                for (Poisson poisson : poissonMap.get(species)) toReturn.append("\n").append(poisson);
            }
        }
        return String.valueOf(toReturn);
    }

    public PoissonMap getPoissonMap() {
        return poissonMap;
    }

    public List<Algue> getAlgues() {
        return algues;
    }
}
