public class Main {
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addAlgue();
        aquarium.addPoisson(new Poisson("Amélie", "Femelle"));
        aquarium.nouveauTour();
    }
}
