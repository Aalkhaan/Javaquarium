public class PoissonClown extends Carnivore {
    public PoissonClown(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.POISSON_CLOWN, aquarium);
    }

    public PoissonClown(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.POISSON_CLOWN, aquarium, age);
    }
}
