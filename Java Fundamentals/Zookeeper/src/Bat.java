public class Bat extends Mammal {

    public Bat() {
        energy = 300;
    }

    public void fly() {
        energy -= 50;
        System.out.println("The bat is airborne!");
    }

    public void eatHumans() {
        energy += 25;
        System.out.println("The bat is satisfied after eating humans!");
    }

    public void attackTown() {
        energy -= 100;
        System.out.println("The bat has attacked a town!");
    }
}
