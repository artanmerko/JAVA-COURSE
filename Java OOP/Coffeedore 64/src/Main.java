public class Main {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Add some items to the menu
        kiosk.addMenuItem("Coffee", 1.50);
        kiosk.addMenuItem("Latte", 3.50);
        kiosk.addMenuItem("Cappuccino", 4.00);
        kiosk.addMenuItem("Muffin", 2.50);

        // Ninja Bonus: Add menu item by input
        kiosk.addMenuItemByInput();

        // Take new orders
        kiosk.newOrder();
        // ... Repeat as desired

        // Display the menu
        kiosk.displayMenu();
    }
}
