public class Merou extends Carnivore {
    public Merou(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.MEROU, aquarium);
    }

    public Merou(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.MEROU, aquarium, age);
    }
}
