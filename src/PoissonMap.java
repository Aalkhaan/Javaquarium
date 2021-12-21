import java.util.*;

public class PoissonMap {
    private final Map<Espece, List<Poisson>> map;

    public PoissonMap() {
        map = new HashMap<>();
        for (Espece espece : Espece.values()) {
            map.put(espece, new ArrayList<>());
        }
    }

    public boolean isEmpty() {
        for (Espece espece : Espece.values()) {
            if (!map.get(espece).isEmpty()) return false;
        }
        return true;
    }

    public List<Poisson> get(Espece espece) {
        return map.get(espece);
    }

    public Collection<List<Poisson>> values() {
        return map.values();
    }

    public Set<Espece> keySet() {
        return map.keySet();
    }
}
