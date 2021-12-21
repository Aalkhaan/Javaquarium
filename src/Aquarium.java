import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final Map<String, List<Poisson>> mapPoissons;
    private final Map<String, Integer> effectifs;

    public Aquarium() {
        algues = new ArrayList<>();
        mapPoissons = new HashMap<>();
        effectifs = new HashMap<>();
    }

    public void addPoisson(Poisson poisson) {
        String espece = poisson.getEspece();
        if (!mapPoissons.containsKey(espece)) {
            mapPoissons.put(espece, new ArrayList<>());
            effectifs.put(espece, 0);
        }
        mapPoissons.get(espece).add(poisson);
        effectifs.put(espece, effectifs.get(espece) + 1);
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

        Map<String, Integer> effectifs = new HashMap<>();
        for (String espece : mapPoissons.keySet())


        System.out.println("Nombre d'algues : " + algues.size());
        for (String species : mapPoissons.keySet()) {
            System.out.println(species + " :");
            for (Poisson poisson : mapPoissons.get(species)) {
                System.out.println(poisson);
            }
        }

    }

    private int getRandomIndex(Collection<?> collection) {
        return new Random().nextInt(collection.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("L'aquarium contient ").append(algues.size()).append(" algue")
                .append((algues.size() == 1) ? "" : "s").append("\n");
    }
}
