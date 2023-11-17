import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArraysAndLists
 */
public class ArraysAndLists {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList);

        myList.add(10);
        myList.add(11);
        System.out.println(myList);

        // getter and setter
        Integer num = myList.get(0);
        System.out.println("num1: " + num);
        myList.set(0, 9);
        System.out.println(myList);

        ArrayList<Object> things = new ArrayList<Object>();
        ArrayList<Integer> noArray = new ArrayList<Integer>();
        noArray.add(1);
        noArray.add(2);
        noArray.add(3);
        things.add(11111);
        things.add("Test");
        things.add("a");
        things.add( noArray);
        things.add(12.5);
        System.out.println(things);

        ArrayList<Integer> myNums = new ArrayList<Integer>();
        myNums.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        System.out.println(myNums);

        for (int i = 0; i < 5; i+=2){
        System.out.println(i);
        }

        String[] fruits = {"one","two","three","four"};
        for (String string : fruits) {
            System.out.println(string);
        }
    }
}