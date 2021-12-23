public abstract class Vivant {
    private int pV;

    private int age;

    protected Vivant() {
        pV = 10;
        age = 0;
    }

    protected Vivant(int age) {
        if (age < 0) throw new IllegalArgumentException("L'age doit être positif");
        this.age = age;
    }

    public int getPV() {
        return pV;
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

    void setPV(int pV) {
        this.pV = pV;
    }

    public boolean vieillir() {
        age++;
        return age > 10;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return ", " + getPV() + " PVs, " + getAge() + " ans";
    }
}
