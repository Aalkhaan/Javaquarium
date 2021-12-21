import java.util.*;

public class RangeManager {
    public String getRandomKey(Map<String, List<Poisson>> map, String eatingSpecies) {
        List<Range> ranges = new LinkedList<>();
        int nombrePoissons = 0;
        for (String species : map.keySet()) {
            if (!Objects.equals(eatingSpecies, species)) {
                int nombre = map.get(species).size();
                ranges.add(new Range(species, nombrePoissons, nombrePoissons + nombre));
                nombrePoissons += nombre;
            }
        }
        if (nombrePoissons == 0) return null;
        int randomIndex = new Random().nextInt(nombrePoissons);
        for (Range range : ranges) {
            if (range.contains(randomIndex)) return range.getName();
        }
        return null;
    }
}
