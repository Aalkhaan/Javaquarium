public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgue(4);
        aquarium.addPoisson(new Merou("Amélie", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Merou("Amélie", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Merou("Amélie", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Merou("Amélie", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Merou("Amélie", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Carpe("Caroline", Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Carpe("Carolin", Sexe.MALE, aquarium));
        aquarium.nouveauTourJusquePoissonsMorts(100);
    }
}
