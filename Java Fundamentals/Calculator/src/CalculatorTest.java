public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Example operation
        calc.setOperandOne(10.5);
        calc.setOperation("+");
        calc.setOperandTwo(5.2);
        calc.performOperation();

        System.out.println("The result is: " + calc.getResults());
    }
}
