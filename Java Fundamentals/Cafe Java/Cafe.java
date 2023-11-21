public class Cafe {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double drinkPrice = 7.5;
        double coffeePrice = 3.5;
        double lattePrice = 2.5;
        double cappuccinoPrice = 3;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Artan";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
        String customer5 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = true;
        boolean isReadyOrder5 = false;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)

        //Cindhuri
        System.out.println(generalGreeting + customer1);
        if (!isReadyOrder1) {
            System.out.println(customer1 + pendingMessage);
        } else {
            System.out.println(customer1 + readyMessage);
        }
        System.out.println(displayTotalMessage + mochaPrice);

        //Artan
        System.out.println(generalGreeting + customer2);
        if (!isReadyOrder2) {
            System.out.println(customer2 + pendingMessage);
        } else {
            System.out.println(customer2 + readyMessage);
        }
        System.out.println(displayTotalMessage + drinkPrice);
        

        //Sam
        System.out.println(generalGreeting + customer3);
        if (!isReadyOrder3) {
            System.out.println(customer3 + pendingMessage);
        } else {
            System.out.println(customer3 + readyMessage);
        }
        System.out.println(displayTotalMessage + 2 * lattePrice);

        //Jimmy
        double correctedTotal = coffeePrice - lattePrice;
        System.out.println(generalGreeting + customer4);
        if (!isReadyOrder4) {
            System.out.println(customer4 + pendingMessage);
        } else {
            System.out.println(customer4 + readyMessage);
        }
        System.out.println(displayTotalMessage + correctedTotal);

        //Noah
        System.out.println(generalGreeting + customer5);
        if (!isReadyOrder5) {
            System.out.println(customer5 + pendingMessage);
        } else {
            System.out.println(customer5 + readyMessage);
        }
        System.out.println(displayTotalMessage + cappuccinoPrice);
    }
}
