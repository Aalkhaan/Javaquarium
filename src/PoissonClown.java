public class PoissonClown extends Carnivore implements HermaphroditeOpportuniste {
    public PoissonClown(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.POISSON_CLOWN, aquarium);
    }

    public PoissonClown(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.POISSON_CLOWN, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new PoissonClown(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return HermaphroditeOpportuniste.super.rencontre(this, poisson);
    }
}
