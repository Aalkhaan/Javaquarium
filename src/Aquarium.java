import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final MapPoisson mapPoisson;

    public Aquarium() {
        algues = new ArrayList<>();
        mapPoisson = new MapPoisson();
    }

    public void addPoisson(Poisson poisson) {
        Espece espece = poisson.getEspece();
        mapPoisson.get(espece).add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue(this));
    }

    public void addAlgue(Algue algue) {
        algues.add(algue);
    }

    public void addAlgue(int n) {
        if (n < 0) throw new IllegalArgumentException("Le nombre de tours doit être positif");
        for (int i = 0; i < n; i++) {
            addAlgue();
        }
    }

    /**
     * Chaque algue gagne 1 PV, vieillit et se reproduit si elle a plus de 10 PVs.
     */
    private void alguesGrandissent() {
        List<Algue> newAlgues = new ArrayList<>();
        for (int i = 0; i < algues.size();) {
            if (algues.get(i).vieillir()) {
                algues.remove(i);
            } else {
                algues.get(i).addPV(1);
                Algue newAlgue = algues.get(i).seReproduire();
                if (newAlgue != null) newAlgues.add(newAlgue);
                i++;
            }
        }
        algues.addAll(newAlgues);
    }

    /**
     * Chaque poisson perd 1 PV de faim et vieillit.
     */
    private List<Poisson> poissonsGrandissent() {
        List<Poisson> allPoissons = new LinkedList<>();
        for (List<Poisson> poissons : mapPoisson.values()) {
            for (int i = 0; i < poissons.size();) {
                Poisson poisson = poissons.get(i);
                if (poisson.vieillir() || poisson.aFaim()) {
                    poissons.remove(i);
                } else {
                    allPoissons.add(poisson);
                    i++;
                }
            }
        }
        return allPoissons;
    }

    private void melangeEntites() {
        Collections.shuffle(algues);
        for (List<Poisson> list : mapPoisson.values()) {
            Collections.shuffle(list);
        }
    }

    public void nouveauTour() {
        System.out.println(this);

        melangeEntites();
        alguesGrandissent();
        List<Poisson> poissons = poissonsGrandissent();
        for (Poisson poisson : poissons) {
            if (poisson.getPV() > 0) {
                poisson.action();
            }
        }
    }

    public void nouveauTour(int n) {
        if (n < 0) throw new IllegalArgumentException("Le nombre de tours doit être positif");
        for (int i = 0; i < n; i++) {
            nouveauTour();
        }
    }

    public void nouveauTourJusquePoissonsMorts(int limite) {
        int i = 0;
        while (!mapPoisson.isEmpty() && i < limite) {
            nouveauTour();
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("__________________________________________________________________________________________\n");
        if (algues.isEmpty() && mapPoisson.isEmpty()) {
            return "Cet aquarium est vide.";
        }
        if (!algues.isEmpty()) {
            toReturn.append("Cet aquarium contient ").append(algues.size()).append(" algue")
                    .append((algues.size() == 1) ? "" : "s");
            toReturn.append(" que voici :");
            for (Algue algue : algues) {
                toReturn.append("\n").append(algue);
            }
        }
        if (!mapPoisson.isEmpty()) {
            toReturn.append("\nEt les espèces suivantes de poissons :");
            for (Espece espece : mapPoisson.keySet()) {
                if (!mapPoisson.get(espece).isEmpty()) {
                    toReturn.append("\n\n").append(espece).append(" :");
                    for (Poisson poisson : mapPoisson.get(espece)) toReturn.append("\n").append(poisson);
                }
            }
        }
        return String.valueOf(toReturn);
    }

    public MapPoisson getMapPoisson() {
        return mapPoisson;
    }

    public List<Algue> getAlgues() {
        return algues;
    }
}
