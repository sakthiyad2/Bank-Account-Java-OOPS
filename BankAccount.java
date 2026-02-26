import java.util.Scanner;
abstract class BankAccount {
    protected String accountHolder;
    protected int accountNumber;
    protected double balance;
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    void displayAccount() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("Enter Account Holder Name:");
        String name = S.nextLine();
        System.out.println("Enter Account Number:");
        int accNo = S.nextInt();        System.out.println("Enter Initial Balance:");
        double bal = S.nextDouble();
        BankAccount account = new SavingsAccount(name, accNo, bal);
        System.out.println("Enter amount to deposit:");
        double dep = S.nextDouble();
        account.deposit(dep);
        System.out.println("Enter amount to withdraw:");
        double wit = S.nextDouble();
        account.withdraw(wit);
        System.out.println();
        account.displayAccount();
        S.close();
    }
}
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}