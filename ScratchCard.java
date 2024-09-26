package payments;

import java.util.Random;

public class ScratchCard {

    private final boolean isWinning;

    public ScratchCard(boolean isWinning) {
        this.isWinning = isWinning;
    }

    public ScratchCard(double winPercentage) {
        Random random = new Random();

        if(random.nextDouble() * 100.00 < winPercentage) {
            isWinning = true;
        } else {
            isWinning = false;
        }
    }

    public boolean isWinning() {
        return isWinning;
    }
}
