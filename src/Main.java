public class Main {
    public static void main(String[] args) {
        NewBornManager.initialiser();

        Aquarium aquarium = new Aquarium();
        aquarium.addAlgue(2);
        aquarium.addPoisson(new Carpe(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new Carpe(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Thon(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new Thon(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Bar(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new Bar(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Merou(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new Merou(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new Sole(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new Sole(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));
        aquarium.addPoisson(new PoissonClown(NewBornManager.getRandomName(), Sexe.MALE, aquarium));
        aquarium.addPoisson(new PoissonClown(NewBornManager.getRandomName(), Sexe.FEMELLE, aquarium));

        aquarium.nouveauTour(20);
    }
}
