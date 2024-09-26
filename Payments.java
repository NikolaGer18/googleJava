package payments;

public interface Payments {
    public boolean payMoney(double amount) throws PaymentException;
    public double getCashBackAsCreditBalance();
}

