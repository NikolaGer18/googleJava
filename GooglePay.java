package payments;

import java.util.ArrayList;
import java.util.List;

public class GooglePay implements Payments, OffersScratchCard {

    private Account account;
    private final List<Double> paymentsHistory = new ArrayList<>();

    public GooglePay(Account account) {
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
    public ScratchCard getScracthCard() {
        double lastPaymentAmount = paymentsHistory.get(paymentsHistory.size() - 1);

        return determineScratchCard(lastPaymentAmount);
    }

    private ScratchCard determineScratchCard(double lastPaymentAmount) {
        if(lastPaymentAmount <= 100) {
            return new ScratchCard(0);
        }
        if(lastPaymentAmount > 100 && lastPaymentAmount <= 1000) {
            return new ScratchCard(10);
        }
        if(lastPaymentAmount > 1000 && lastPaymentAmount <= 3000) {
            return new ScratchCard(20);
        }
        if(lastPaymentAmount > 3000 && lastPaymentAmount <= 5000) {
            return new ScratchCard(30);
        }
        if(lastPaymentAmount > 5000 && lastPaymentAmount <= 10_000) {
            return new ScratchCard(50);
        }
        return new ScratchCard(100);
    }

    @Override
    public double getCashBackAsCreditBalance() {
        double lastPaymentAmount = paymentsHistory.get(paymentsHistory.size() - 1);

        if(lastPaymentAmount > 5000) {
            double cashBackAmount = lastPaymentAmount * 0.10;
            account.deposit(cashBackAmount);

            return cashBackAmount;
        }

        return 0;
    }
}
