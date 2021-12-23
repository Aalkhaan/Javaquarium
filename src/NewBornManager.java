import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class NewBornManager {
    private static final HashMap<Sexe, ArrayList<String>> nameMap = new HashMap<>();
    private static final ArrayList<String> allNames = new ArrayList<>();

    public static void initialiser() {
        nameMap.put(Sexe.MALE, new ArrayList<>());
        nameMap.put(Sexe.FEMELLE, new ArrayList<>());
        for (int i = 0; i < 10000; i++) {
            addName(String.valueOf(i));
        }
    }

    public static Sexe getRandomSexe() {
        int coinFlip = new Random().nextInt(2);
        if (coinFlip == 0) return Sexe.MALE;
        return Sexe.FEMELLE;
    }

    public static void addName(String... names) {
        for (String name : names) {
            nameMap.get(Sexe.MALE).add(name);
            nameMap.get(Sexe.FEMELLE).add(name);
            allNames.add(name);
        }
    }

    public static void addName(Sexe sexe, String... names) {
        for (String name : names) {
            nameMap.get(sexe).add(name);
            allNames.add(name);
        }
    }

    public static String getRandomName(Sexe sexe) {
        return nameMap.get(sexe).remove(new Random().nextInt(nameMap.get(sexe).size()));
    }

    public static String getRandomName() {
        return allNames.get(new Random().nextInt(allNames.size()));
    }
}
