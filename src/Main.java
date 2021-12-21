public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgue(4);
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Carpe("Caroline", "Femelle", aquarium));
        aquarium.addPoisson(new Carpe("Carolin", "Male", aquarium));
        aquarium.nouveauTourJusquePoissonsMorts(100);
    }
}
