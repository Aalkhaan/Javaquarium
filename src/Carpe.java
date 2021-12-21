public class Carpe extends Herbivore {
    public Carpe(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.CARPE, aquarium);
    }

    public Carpe(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.CARPE, aquarium, age);
    }
}
