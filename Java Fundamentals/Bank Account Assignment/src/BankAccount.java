import java.util.Random;

public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber; // Ninja Bonus 1
    private static int accounts;
    private static double totalMoney;

    // CONSTRUCTOR
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = generateAccountNumber(); // Ninja Bonus 3
        accounts++;
    }

    // PRIVATE METHOD FOR NINJA BONUS 2
    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // GETTERS
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // METHODS
    public void deposit(double amount, String accountType) {
        if(accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if(accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        }
        totalMoney += amount;
    }

    public boolean withdraw(double amount, String accountType) {
        if(accountType.equalsIgnoreCase("checking") && checkingBalance >= amount) {
            checkingBalance -= amount;
            totalMoney -= amount;
            return true;
        } else if(accountType.equalsIgnoreCase("savings") && savingsBalance >= amount) {
            savingsBalance -= amount;
            totalMoney -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return checkingBalance + savingsBalance;
    }
}
