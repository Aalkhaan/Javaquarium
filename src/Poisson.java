import java.util.*;

public abstract class Poisson extends Vivant implements Comparable<Poisson> {
    private final String nom;
    private final Sexe sexe;
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
    public String toString() {
        return nom + ", " + sexe + ", " + getPV() + " PVs";
    }

    @Override
    public boolean seFaitMordre() {
        return removePV(4);
    }

    @Override
    public int compareTo(Poisson poisson) {
        int especeComparator = getEspece().compareTo(poisson.getEspece());
        if (especeComparator != 0) return especeComparator;
        return nom.compareTo(getNom());
    }

    public Espece getEspece() {
        return espece;
    }

    public abstract void manger();

    public PoissonMap getMapPoissons() {
        return aquarium.getPoissonMap();
    }

    public List<Algue> getAlgues() {
        return aquarium.getAlgues();
    }

    public void action() {

    }
}
