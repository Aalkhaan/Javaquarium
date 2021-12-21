public class Thon extends Carnivore {
    public Thon(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.THON, aquarium);
    }

    public Thon(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.THON, aquarium, age);
    }
}
