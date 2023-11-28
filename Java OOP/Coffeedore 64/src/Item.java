public class Item {
    public String name;
    public double price;
    private int index;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
