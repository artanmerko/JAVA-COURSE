public class Device {
    protected int battery;

    public Device() {
        this.battery = 100;
    }

    public void displayBatteryStatus() {
        System.out.println("Battery remaining: " + battery + "%");
    }
}
