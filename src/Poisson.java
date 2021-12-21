import java.util.*;

public abstract class Poisson extends Vivant implements Comparable<Poisson> {
    private final String nom;
    private final String sexe;
    private final Aquarium aquarium;

    protected Poisson(String nom, String sexe, Aquarium aquarium) {
        this.nom = nom;
        this.sexe = sexe;
        this.aquarium = aquarium;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Poisson)) return false;
        return Objects.equals(nom, ((Poisson) o).getNom());
    }

    @Override
    public String toString() {
        return nom + ", " + sexe;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public boolean seFaitMordre() {
        return removePV(4);
    }

    @Override
    public int compareTo(Poisson poisson) {
        int especeComparator = getEspece().compareTo(poisson.getEspece());
        if (especeComparator != 0) return especeComparator;
        return nom.compareTo(getNom());
    }

    public abstract String getEspece();

    public abstract void manger();

    public Map<String, List<Poisson>> getMapPoissons() {
        return aquarium.getMapPoissons();
    }

    public List<Algue> getAlgues() {
        return aquarium.getAlgues();
    }
}
