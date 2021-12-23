public class Sole extends Herbivore implements HermaphroditeOpportuniste {
    public Sole(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.SOLE, aquarium);
    }

    public Sole(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.SOLE, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new Sole(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return HermaphroditeOpportuniste.super.rencontre(this, poisson);
    }
}
