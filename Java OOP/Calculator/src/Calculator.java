public class Calculator {
    private double operandOne;
    private double operandTwo;
    private String operation;
    private double result;

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void performOperation() {
        if (operation.equals("+")) {
            result = operandOne + operandTwo;
        } else if (operation.equals("-")) {
            result = operandOne - operandTwo;
        }
    }

    public double getResults() {
        return result;
    }
}
