import java.util.*;

public class RangeManager {
    public Espece getRandomKey(Map<Espece, List<Poisson>> map, Espece eatingSpecies) {
        List<Range> ranges = new LinkedList<>();
        int nombrePoissons = 0;
        for (Espece species : map.keySet()) {
            if (!Objects.equals(eatingSpecies, species)) {
                int nombre = map.get(species).size();
                ranges.add(new Range(species, nombrePoissons, nombrePoissons + nombre));
                nombrePoissons += nombre;
            }
        }
        if (nombrePoissons == 0) return null;
        int randomIndex = new Random().nextInt(nombrePoissons);
        for (Range range : ranges) {
            if (range.contains(randomIndex)) return range.getEspece();
        }
        return null;
    }
}
