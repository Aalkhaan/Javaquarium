import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final Map<String, List<Poisson>> mapPoissons;
    private final Map<String, List<Poisson>> mapAffames;

    public Aquarium() {
        algues = new ArrayList<>();
        mapPoissons = new HashMap<>();
        mapAffames = new HashMap<>();
    }

    public void addPoisson(Poisson poisson) {
        if (!mapPoissons.containsKey(poisson.getEspece())) {
            mapPoissons.put(poisson.getEspece(), new ArrayList<>());
        }
        mapPoissons.get(poisson.getEspece()).add(poisson);
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



        for (Poisson poisson : affames) {
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
