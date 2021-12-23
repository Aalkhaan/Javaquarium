public interface HermaphroditeOpportuniste {
    default boolean rencontre(Poisson p1, Poisson p2) {
        if (p1.getAquarium() == p2.getAquarium() && p1.getEspece() == p2.getEspece()) {
            if (p1.getSexe() == p2.getSexe()) {
                p1.switchSexe();
            }
            return true;
        }
        return false;
    }
}
