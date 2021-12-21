public class Bar extends Herbivore {
    public Bar(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.BAR, aquarium);
    }

    public Bar(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.BAR, aquarium, age);
    }
}
