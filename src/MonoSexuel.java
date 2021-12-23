public interface MonoSexuel {
    default boolean rencontre(Poisson p1, Poisson p2) {
        return p1.getAquarium() == p2.getAquarium() &&
                p1.getEspece() == p2.getEspece() &&
                p1.getSexe() != p2.getSexe();
    }
}
