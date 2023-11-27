public class DeviceTest {
    public static void main(String[] args) {
        Phone myPhone = new Phone();

        // Making three phone calls
        myPhone.makeCall();
        myPhone.makeCall();
        myPhone.makeCall();

        // Playing a game twice
        myPhone.playGame();
        myPhone.playGame();

        // Charging the phone
        myPhone.charge();
    }
}
