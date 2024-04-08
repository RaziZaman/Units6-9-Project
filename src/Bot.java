import java.util.Scanner;

public class Bot extends Board {
    public Bot(String[][] board) {
        super(board);
    }
    @Override // Bot Player 2
    public void player2Choice() {
        int placement = -1;
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        while (placement == -1) {
            String choice = randomAlphabet();
            for (int i = 0; i < getBoard().length; i++) {
                if (alphabet[i].equalsIgnoreCase(choice)) {
                    placement = i;
                }
            }
        }
        for (int i = getBoard()[0].length - 1; i >= 0; i--) {
            if (getBoard()[i][placement].equals(" ")) {
                getBoard()[i][placement] = "O";
                i = -1;
            }
        }
    }
    private static String randomAlphabet() {
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int randomNum = (int)(Math.random() * 26);
        return alphabet[randomNum];
    }
}
