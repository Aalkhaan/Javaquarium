public class Sole extends Herbivore {
    public Sole(String nom, String sexe) {
        super(nom, sexe);
    }

    @Override
    public String getEspece() {
        return "Sole";
    }
}
