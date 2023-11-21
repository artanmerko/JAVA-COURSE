import java.util.ArrayList;

public class ArrayListJava {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello word");
        myList.add(48);
        myList.add("Goodbye world");

        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Converted to Integer: " + castedValue);
            } catch (Exception e) {
                System.out.println("Error at index " + i + ": " + e.getMessage());
                System.out.println("Object causing error: " + myList.get(i));
            }
        }
    }
}