import java.util.*;

public abstract class Poisson extends Vivant {
    private final String nom;
    private final String sexe;

    protected Poisson(String nom, String sexe) {
        this.nom = nom;
        this.sexe = sexe;
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
        return nom + " : " + sexe;
    }

    public boolean seFaitMordre() {
        return removePV(4);
    }
}
