public class Sole extends Herbivore {
    public Sole(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.SOLE, aquarium);
    }

    public Sole(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.SOLE, aquarium, age);
    }
}
