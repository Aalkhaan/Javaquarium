public class Merou extends Carnivore implements HermaphroditeAge {
    public Merou(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.MEROU, aquarium);
    }

    public Merou(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.MEROU, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new Merou(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return HermaphroditeAge.super.rencontre(this, poisson);
    }
}
