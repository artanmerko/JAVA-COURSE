public class Phone extends Device {

    public void makeCall() {
        if (battery >= 5) {
            battery -= 5;
            System.out.println("You make a call.");
            displayBatteryStatus();
        } else {
            System.out.println("Battery too low to make a call.");
        }
    }

    public void playGame() {
        if (battery < 25) {
            System.out.println("Battery too low to play a game.");
            return;
        }
        battery -= 20;
        System.out.println("You play a game.");
        displayBatteryStatus();
        if (battery < 10) {
            System.out.println("Battery critical!");
        }
    }

    public void charge() {
        battery += 50;
        if (battery > 100) {
            battery = 100;
        }
        System.out.println("You charge the phone.");
        displayBatteryStatus();
    }
}
