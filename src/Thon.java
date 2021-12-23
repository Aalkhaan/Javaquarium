public class Thon extends Carnivore implements MonoSexuel {
    public Thon(String nom, Sexe sexe, Aquarium aquarium) {
        super(nom, sexe, Espece.THON, aquarium);
    }

    public Thon(String nom, Sexe sexe, Aquarium aquarium, int age) {
        super(nom, sexe, Espece.THON, aquarium, age);
    }

    @Override
    public void seReproduire(Poisson poisson) {
        if (rencontre(poisson)) {
            Sexe sexe = NewBornManager.getRandomSexe();
            getAquarium().addPoisson(new Thon(NewBornManager.getRandomName(sexe), sexe, getAquarium()));
        }
    }

    @Override
    public boolean rencontre(Poisson poisson) {
        return MonoSexuel.super.rencontre(this, poisson);
    }
}
