public class Bar extends Herbivore implements HermaphroditeAge {
    public Bar(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.BAR, aquarium);
    }

    public Bar(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.BAR, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new Bar(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return HermaphroditeAge.super.rencontre(this, poisson);
    }
}
