public class Carpe extends Herbivore implements MonoSexuel {
    public Carpe(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.CARPE, aquarium);
    }

    public Carpe(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.CARPE, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new Carpe(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return MonoSexuel.super.rencontre(this, poisson);
    }
}
