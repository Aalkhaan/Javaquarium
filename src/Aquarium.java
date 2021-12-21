import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final Map<Espece, List<Poisson>> mapPoissons;

    public Aquarium() {
        algues = new ArrayList<>();
        mapPoissons = new HashMap<>();
    }

    public void addPoisson(Poisson poisson) {
        Espece espece = poisson.getEspece();
        if (!mapPoissons.containsKey(espece)) {
            mapPoissons.put(espece, new ArrayList<>());
        }
        mapPoissons.get(espece).add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    private void alguesGrandissent() {
        for (Algue algue : algues) {
            algue.addPV(1);
        }
    }

    private void melangeEntites() {
        Collections.shuffle(algues);
        for (List<Poisson> list : mapPoissons.values()) {
            Collections.shuffle(list);
        }
    }

    public void nouveauTour() {
        melangeEntites();
        alguesGrandissent();

        // Les poissons ont faim et perdent 1 PV. Ceux qui ont moins de 5 PV sont ajoutés
        // à la liste des poissons qui veulent manger.
        LinkedList<Poisson> affames = new LinkedList<>();
        for (List<Poisson> poissons : mapPoissons.values()) {
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

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("__________________________________________________________________________________________\n");
        if (algues.isEmpty() && mapPoissons.isEmpty()) {
            return "Cet aquarium est vide.";
        }
        if (!algues.isEmpty()) {
            toReturn.append("Cet aquarium contient ").append(algues.size()).append(" algue")
                    .append((algues.size() == 1) ? "" : "s");
        }
        if (!mapPoissons.isEmpty()) {
            toReturn.append("\nEt les espèces suivantes de poissons :");
            for (Espece species : mapPoissons.keySet()) {
                toReturn.append("\n\n").append(species).append(" :");
                for (Poisson poisson : mapPoissons.get(species)) toReturn.append("\n").append(poisson);
            }
        }
        return String.valueOf(toReturn);
    }

    public Map<Espece, List<Poisson>> getMapPoissons() {
        return mapPoissons;
    }

    public List<Algue> getAlgues() {
        return algues;
    }
}
