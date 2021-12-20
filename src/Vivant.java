public abstract class Vivant {
    private int pV;

    protected Vivant() {
        pV = 10;
    }

    /**
     * Retire 4 PVs et renvoie un booléen qui indique si l'être vivant est mort ou pas.
     */
    public abstract boolean seFaitMordre();

    public void addPV(int pVs) {
        pV += pVs;
    }

    /**
     * Retire le nombre de PVs donné et renvoie un booléen qui indique si l'être vivant est mort ou pas.
     */
    public boolean removePV(int pVs) {
        pV -= pVs;
        return pV <= 0;
    }
}
