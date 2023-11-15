class Conditionals {
    public static void main (String[] args) {
        int temp = 85;
        boolean isCloudy = true;

        if (temp < 40 && isCloudy) {
            System.out.println("It might snow.");
        } else if (isCloudy) {
            System.out.println("It might rain");
        } else {
            System.out.println("We should have nice weather today.");
        }
    }
}