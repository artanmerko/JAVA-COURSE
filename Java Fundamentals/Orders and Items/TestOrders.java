
public class TestOrders {

    public static void main(String[] args) {

        // APP VARIABLES

        // Menu items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 3.25;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4.5;

        Item item3 = new Item();
        item2.name = "drip coffee";
        item2.price = 2.15;

        Item item4 = new Item();
        item2.name = "capuccino";
        item2.price = 3.5;

        // Order variables
        Order order1 = new Order();
        System.out.println(order1.total);
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // Application Simulations

        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.ready = true;

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Jimmy’s order is now ready. Update his status.
        order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);

    }

}