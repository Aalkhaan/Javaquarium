public class Range {
    private final int inf;
    private final int sup;
    private final String name;

    public Range(String name, int inf, int sup) {
        this.name = name;
        this.inf = inf;
        this.sup = sup;
    }

    public boolean contains(int n) {
        return n >= inf && n < sup;
    }

    public String getName() {
        return name;
    }
}
