import java.util.Scanner;

public class Board {
    private String[][] board;
    public Board(int length) {
        board = new String[length][length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }
    public void printBoard() {
        String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        System.out.print("   ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + alphabet[i] + "  ");
        }
        System.out.println();
        for (int i = 0, num = 1; i < board.length; i++, num++) {
            System.out.print(num + "  ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j != board[0].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != board.length - 1) {
                System.out.print("   ");
                for (int k = 0; k < board.length; k++) {
                    System.out.print("----");
                }
            }
            System.out.println();
        }
    }
    public void player1Choice() {
        int placement = -1;
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        while (placement == -1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Player 1: ");
            String choice = scan.nextLine();
            for (int i = 0; i < board.length; i++) {
                if (alphabet[i].equalsIgnoreCase(choice)) {
                    placement = i;
                }
            }
            if (placement == -1) {
                System.out.println("Invalid Spot, Try Again");
            }
        }
        for (int i = board[0].length - 1; i >= 0; i--) {
            if (board[i][placement].equals(" ")) {
                board[i][placement] = "X";
                i = -1;
            }
        }
    }
    public void player2Choice() {
        int placement = -1;
        String alphabet[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        while (placement == -1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Player 2: ");
            String choice = scan.nextLine();
            for (int i = 0; i < board.length; i++) {
                if (alphabet[i].equalsIgnoreCase(choice)) {
                    placement = i;
                }
            }
            if (placement == -1) {
                System.out.println("Invalid Spot, Try Again");
            }
        }
        for (int i = board[0].length - 1; i >= 0; i--) {
            if (board[i][placement].equals(" ")) {
                board[i][placement] = "O";
                i = -1;
            }
        }
    }
}

