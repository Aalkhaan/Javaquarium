@SuppressWarnings("ClassCanBeRecord")
public class Range {
    private final int inf;
    private final int sup;
    private final Espece espece;

    public Range(Espece espece, int inf, int sup) {
        this.espece = espece;
        this.inf = inf;
        this.sup = sup;
    }

    public boolean contains(int n) {
        return n >= inf && n < sup;
    }

    public Espece getEspece() {
        return espece;
    }
}
