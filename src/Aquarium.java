import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Aquarium {
    private final List<Algue> algues;
    private final Map<String, List<Poisson>> mapPoissons;

    public Aquarium() {
        algues = new ArrayList<>();
        mapPoissons = new HashMap<>();
    }

    public void addPoisson(Poisson poisson) {
        String espece = poisson.getEspece();
        if (!mapPoissons.containsKey(espece)) {
            mapPoissons.put(espece, new ArrayList<>());
        }
        mapPoissons.get(espece).add(poisson);
    }

    public void addAlgue() {
        algues.add(new Algue());
    }

    public void nouveauTour() {
        // Mélange les entités vivantes.
        Collections.shuffle(algues);
        for (List<Poisson> list : mapPoissons.values()) {
            Collections.shuffle(list);
        }

        // Les algues grandissent.
        for (Algue algue : algues) {
            algue.addPV(1);
        }

        // Les poissons ont faim et perdent 1 PV. Ceux qui ont moins de 5 PV sont ajoutés
        // à la liste des poissons qui veulent manger.
        LinkedList<Poisson> affames = new LinkedList<>();
        for (List<Poisson> poissons : mapPoissons.values()) {
            for (int i = 0; i < poissons.size();) {
                if (poissons.get(i).removePV(1)) {
                    poissons.remove(i);
                } else {
                    if (poissons.get(i).getpV() <= 5) {
                        affames.add(poissons.get(i));
                    }
                    i++;
                }
            }
        }

        for (Poisson poisson : affames) {
            poisson.manger();
        }
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("L'aquarium contient ").append(algues.size()).append(" algue")
                .append((algues.size() == 1) ? "" : "s");
        if (!mapPoissons.isEmpty()) {
            toReturn.append("\nEt les espèces suivantes de poissons :");
            for (String species : mapPoissons.keySet()) {
                toReturn.append(species).append(" :");
                for (Poisson poisson : mapPoissons.get(species)) toReturn.append("\n").append(poisson);
            }
        }
        return String.valueOf(toReturn);
    }

    public Map<String, List<Poisson>> getMapPoissons() {
        return mapPoissons;
    }

    public List<Algue> getAlgues() {
        return algues;
    }
}
