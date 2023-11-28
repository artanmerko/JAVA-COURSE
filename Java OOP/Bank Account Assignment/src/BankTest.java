public class BankTest {
    public static void main(String[] args) {
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        // Print Account Numbers (Ninja Bonuses 1, 2, and 3)
        System.out.println("Account 1 Number: " + account1.getAccountNumber());
        System.out.println("Account 2 Number: " + account2.getAccountNumber());
        System.out.println("Account 3 Number: " + account3.getAccountNumber());

        // Deposit Test
        account1.deposit(1000, "checking");
        System.out.println("Account 1 Checking Balance: $" + account1.getCheckingBalance());

        account2.deposit(2000, "savings");
        System.out.println("Account 2 Savings Balance: $" + account2.getSavingsBalance());

        // Withdrawal Test
        if(account1.withdraw(300, "checking")) {
            System.out.println("Withdrawal Successful. New Balance: $" + account1.getCheckingBalance());
        } else {
            System.out.println("Insufficient Funds in Checking.");
        }

        // Static Test
        System.out.println("Total Number of Accounts: " + BankAccount.getAccounts());
        System.out.println("Total Money in Bank: $" + BankAccount.getTotalMoney());
    }
}
