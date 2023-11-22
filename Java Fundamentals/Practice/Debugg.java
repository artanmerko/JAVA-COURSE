import java.util.ArrayList;

public class Debugg {

    public static void main(String[] args) {
        ArrayList<String> snacks = new ArrayList<String> ();
        snacks.add("Apples");
        snacks.add("Almonds");
        snacks.add("Pretzels");
        snacks.add("Yogurt");
        System.out.println(snacks);
        for(int i=0; i<snacks.size(); i++) {
            if(snacks.get(i).charAt(0) == 'A') {
                snacks.remove(i);
            }
        }
        System.out.println(snacks);
    }
}