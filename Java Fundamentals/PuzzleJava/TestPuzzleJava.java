import java.util.ArrayList;
// import java.util.Random;
public class TestPuzzleJava {

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("Random Array: " + randomRolls);

        String randomLetterWithArr = generator.getRandomLetterWithArray();
        System.out.println("Random Letter with Array: " + randomLetterWithArr );

        String randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        String randomPass = generator.generatePassword();
        System.out.println("Random Password: " + randomPass);

        ArrayList<String> randomNewPass = generator.getNewPasswordSet(10);
        System.out.println("Random New Password: " + randomNewPass);

        ArrayList<Integer> numbersToShuffle = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            numbersToShuffle.add(i);
        }
        System.out.println("Original Array: " + numbersToShuffle);
        generator.shuffleArray(numbersToShuffle);
        System.out.println("Shuffled Array: " + numbersToShuffle);
    }
}
