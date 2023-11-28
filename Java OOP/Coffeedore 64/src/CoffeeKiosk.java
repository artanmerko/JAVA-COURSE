import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    private Scanner scanner;

    public CoffeeKiosk() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(this.menu.size());
        this.menu.add(newItem);
    }

    public void displayMenu() {
        for (Item item : this.menu) {
            System.out.println(item.getIndex() + " " + item.name + " -- $" + String.format("%.2f", item.price));
        }
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order:");
        String name = scanner.nextLine();
        Order newOrder = new Order();
        newOrder.name = name;

        displayMenu();
        System.out.println("Please enter a menu item index or 'q' to quit:");
        String itemNumber = scanner.nextLine();

        while (!itemNumber.equals("q")) {
            try {
                int index = Integer.parseInt(itemNumber);
                if (index >= 0 && index < this.menu.size()) {
                    newOrder.items.add(this.menu.get(index));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index.");
            }

            System.out.println("Please enter another menu item index or 'q' to quit:");
            itemNumber = scanner.nextLine();
        }

        this.orders.add(newOrder);
        System.out.println("Order for " + newOrder.name + " added.");
    }

    public void addMenuItemByInput() {
        System.out.println("Enter item name:");
        String name = scanner.nextLine();
        System.out.println("Enter item price:");
        String priceStr = scanner.nextLine();
        double price = Double.parseDouble(priceStr);

        addMenuItem(name, price);
        System.out.println("New item added to the menu.");
    }

    // Optional: If you want to include a method to close the scanner
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }


}