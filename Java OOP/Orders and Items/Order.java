import java.util.ArrayList;
// Here we're creating a new data type
// called Order

public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items = new ArrayList<Item>();
}