public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Merou("Amélie", "Femelle", aquarium));
        aquarium.addPoisson(new Carpe("Caroline", "Femelle", aquarium));
        aquarium.addPoisson(new Carpe("Carolin", "Male", aquarium));
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
        aquarium.nouveauTour();
    }
}
