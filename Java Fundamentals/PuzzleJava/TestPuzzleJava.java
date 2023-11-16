import java.util.ArrayList;

public class TestPuzzleJava {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("Random Rolls: " + randomRolls);

        System.out.println("Random Letter: " + generator.getRandomLetter());

        System.out.println("Random Password: " + generator.generatePassword());

        ArrayList<String> passwordSet = generator.getNewPasswordSet(10);
        System.out.println("Password Set: " + passwordSet);

        ArrayList<Integer> numbersToShuffle = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            numbersToShuffle.add(i);
        }
        System.out.println("Original Array: " + numbersToShuffle);
        generator.shuffleArray(numbersToShuffle);
        System.out.println("Shuffled Array: " + numbersToShuffle);
    }
}
