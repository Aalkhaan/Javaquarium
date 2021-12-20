import java.util.*;

public class Aquarium {
    private final List<Algue> algues;
    private final List<Poisson> poissons;
    private final Map<String, List<Poisson>> mapPoissons;

    public Aquarium() {
        algues = new ArrayList<>();
        poissons = new ArrayList<>();
        mapPoissons = new HashMap<>();
    }

    public void addPoisson(Poisson poisson) {
        poissons.add(poisson);
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
        Collections.shuffle(poissons);
        for (List<Poisson> list : mapPoissons.values()) {
            Collections.shuffle(list);
        }

        // Les algues grandissent.
        for (Algue algue : algues) {
            algue.addPV(1);
        }

        // Les poissons ont faim et perdent 1 PV. Ceux qui ont moins de 5 PV sont ajoutés
        // à la liste des poissons qui veulent manger.
        LinkedList<Poisson> poissonsFaim = new LinkedList<>();
        for (int i = 0; i < poissons.size();) {
            if (poissons.get(i).removePV(1)) {
                poissons.remove(i);
            } else {
                if (poissons.get(i).getpV() <= 5) {
                    poissonsFaim.add(poissons.get(i));
                }
                i++;
            }
        }

        for (Poisson poisson : poissonsFaim) {
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
