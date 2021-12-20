import java.util.*;

public abstract class Poisson {
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
        return nom + " : " + sexe;
    }
}
