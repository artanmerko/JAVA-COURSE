public class FixedArrays {
    public static void main(String[] args) {

        // int[] myArray = new int[5];
        // myArray[0] = 4;
        // myArray[1] = 5;
        // myArray[2] = 6;
        // myArray[3] = 7;
        // myArray[4] = 8;
        int[] myArray = {4, 8, 8, 5, 9};
        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }

        String[] fruits = {"banana", "pear", "papaya","kiwi"};
        String temp = fruits[0];
        fruits[0] = fruits[fruits.length - 1];
        fruits[fruits.length - 1] = temp;

        for ( int i = 0; i< fruits.length; i++) {
            System.err.println(fruits[i]);
        }
    }
}