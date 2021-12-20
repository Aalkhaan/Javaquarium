public class Bar extends Herbivore {
    public Bar(String nom, String sexe) {
        super(nom, sexe);
    }

    @Override
    public String getEspece() {
        return "Bar";
    }
}
