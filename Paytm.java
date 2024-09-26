package payments;

import java.util.ArrayList;
import java.util.List;

public class Paytm implements Payments {

    private Account account;
    private final List<Double> paymentsHistory = new ArrayList<>();

    public Paytm(Account account) {
        this.account = account;
    }

    @Override
    public boolean payMoney(double amount) throws PaymentException {
        if(!account.hasSufficientFunds(amount)) {
            throw new PaymentException("Insufficient funds!");
        }

        account.withdraw(amount);
        paymentsHistory.add(amount);
        return true;
    }

    @Override
    public double getCashBackAsCreditBalance() {
        double lastPaymentAmount = paymentsHistory.get(paymentsHistory.size() - 1);

        if(lastPaymentAmount > 10_000) {
            double cashBackAmount = lastPaymentAmount * 0.05;
            account.deposit(cashBackAmount);

            return cashBackAmount;
        }

        return 0;
    }
}
