import java.util.ArrayList;
import java.util.Random;

public class Nourriture {
    private final ArrayList<Vivant> proies;

    public Nourriture() {
        proies = new ArrayList<>();
    }

    public boolean manger() {
        if (!proies.isEmpty()) {
            int randomIndice = new Random().nextInt(proies.size() - 1);
            proies.get(randomIndice).seFaitMordre();
            return true;
        }
        return false;
    }
}
