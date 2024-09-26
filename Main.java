import payments.Account;
import payments.GooglePay;
import payments.ScratchCard;

public class Main {

    public static void main(String[] args) {
        Account account = new Account(1000);
        account.deposit(100_000);
        GooglePay googlePay = new GooglePay(account);

        try {
            googlePay.payMoney(5000);
            ScratchCard sc = googlePay.getScracthCard();

            System.out.println(sc.isWinning());
        } catch (Exception e) {

        }
    }
}
