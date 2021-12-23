import java.util.*;

public abstract class Poisson extends Vivant {
    private final String nom;
    private Sexe sexe;
    private final Espece espece;
    private final Aquarium aquarium;

    protected Poisson(String nom, Sexe sexe, Espece espece, Aquarium aquarium) {
        this.nom = nom;
        this.sexe = sexe;
        this.espece = espece;
        this.aquarium = aquarium;
    }

    public Poisson(String nom, Sexe sexe, Espece espece, Aquarium aquarium, int age) {
        super(age);
        this.nom = nom;
        this.sexe = sexe;
        this.espece = espece;
        this.aquarium = aquarium;
    }

    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Poisson)) return false;
        return Objects.equals(nom, ((Poisson) o).getNom());
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return nom + ", " + sexe + super.toString();
    }

    @Override
    public boolean seFaitMordre() {
        return removePV(10);
    }

    public Espece getEspece() {
        return espece;
    }

    public abstract void manger();

    public Aquarium getAquarium() {
        return aquarium;
    }

    public MapPoisson getMapPoissons() {
        return aquarium.getMapPoisson();
    }

    public List<Algue> getAlgues() {
        return aquarium.getAlgues();
    }

    public boolean aFaim() {
        return removePV(2);
    }

    public void action() {
        if (getPV() <= 5) {
            manger();
        } else seReproduire();
    }

    public void seReproduire() {
        MapPoisson mapPoisson = getMapPoissons();
        Espece espece = EspeceManager.getRandomEspece(mapPoisson);
        int randomIndex = new Random().nextInt(mapPoisson.get(espece).size());
        if (mapPoisson.get(espece).get(randomIndex) != this) {
            seReproduire(mapPoisson.get(espece).get(randomIndex));
        }
    }

    public abstract void seReproduire(Poisson poisson);

    public void switchSexe() {
        if (sexe == Sexe.MALE) sexe = Sexe.FEMELLE;
        else sexe = Sexe.MALE;
    }

    /**
     * Renvoie si les deux poissons sont capables de se reproduire entre eux et opère les changements
     * appropriés en fonction de leur sexualité.
     */
    public abstract boolean rencontre(Poisson poisson);
}
