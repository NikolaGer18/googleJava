package payments;

public class Account {

    private double currentBalance;

    public Account(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public boolean hasSufficientFunds(double amount) {
        return currentBalance >= amount;
    }

    public void withdraw(double amount) {
        this.currentBalance -= amount;
    }

    public void deposit(double amount) {
        this.currentBalance += amount;
    }
}
