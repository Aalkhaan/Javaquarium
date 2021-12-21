import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PoissonMap<E extends Espece, L extends List<Poisson>> extends HashMap<Espece, List<Poisson>> {
    public PoissonMap() {
        for (Espece espece : Espece.values()) {
            put(espece, new ArrayList<>());
        }
    }

    @Override
    public boolean isEmpty() {
        for (Espece espece : Espece.values()) {
            if (get(espece).isEmpty()) return true;
        }
        return false;
    }
}
