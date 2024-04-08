import java.util.Scanner;

public class Board {
    public static String[][] board;
    public Board(String[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }
    public int getLength() {
        return board.length;
    }
    public String[][] getBoard() {
        return board;
    }
    public void printBoard(int player) {
        String color = "";
        if (player == 0) {
            color = Colors.Green;
        } else if (player == 1) {
            color = Colors.Red;
        } else {
            color = Colors.Blue;
        }
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        System.out.print(color + "   ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(color + " " + alphabet[i] + "  ");
        }
        System.out.println();
        for (int i = 0, num = 1; i < board.length; i++, num++) {
            System.out.print(color + num + "  ");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(color + " " + board[i][j] + " ");
                if (j != board[0].length - 1) {
                    System.out.print(color + "|");
                }
            }
            System.out.print(color + "  " + num);
            if (i != board.length - 1) {
                System.out.println();
                System.out.print(color + "   ");
                for (int k = 0; k < board.length; k++) {
                    System.out.print(color + "----");
                }
            }
            System.out.println();
        }
        System.out.print(color + "   ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(color + " " + alphabet[i] + "  ");
        }
        System.out.println();
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
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
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
    public boolean xCheck() {
        for (int i = 3; i < getLength(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getBoard()[i][j].equals("X") && getBoard()[i - 1][j].equals("X") && getBoard()[i - 2][j].equals("X") && getBoard()[i - 3][j].equals("X")) {
                    return true;
                }
            }
        }
        for (int i = 0; i < getLength(); i++) {
            for (int j = 3; j < getLength(); j++) {
                if (getBoard()[i][j].equals("X") && getBoard()[i][j - 1].equals("X") && getBoard()[i][j - 2].equals("X") && getBoard()[i][j - 3].equals("X")) {
                    return true;
                }
            }
        }
        for (int i = 3; i < getLength(); i++) {
            for (int j = 0; j < getLength() - 3; j++) {
                if (getBoard()[i][j].equals("X") && getBoard()[i - 1][j + 1].equals("X") && getBoard()[i - 2][j + 2].equals("X") && getBoard()[i - 3][j + 3].equals("X")) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean oCheck() {
        for (int i = 3; i < getLength(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getBoard()[i][j].equals("O") && getBoard()[i - 1][j].equals("O") && getBoard()[i - 2][j].equals("O") && getBoard()[i - 3][j].equals("O")) {
                    return true;
                }
            }
        }
        for (int i = 0; i < getLength(); i++) {
            for (int j = 3; j < getLength(); j++) {
                if (getBoard()[i][j].equals("O") && getBoard()[i][j - 1].equals("O") && getBoard()[i][j - 2].equals("O") && getBoard()[i][j - 3].equals("O")) {
                    return true;
                }
            }
        }
        for (int i = 3; i < getLength(); i++) {
            for (int j = 0; j < getLength() - 3; j++) {
                if (getBoard()[i][j].equals("O") && getBoard()[i - 1][j + 1].equals("O") && getBoard()[i - 2][j + 2].equals("O") && getBoard()[i - 3][j + 3].equals("O")) {
                    return true;
                }
            }
        }

        return false;

    }
    public boolean tieCheck() {
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < getLength(); j++) {
                if (getBoard()[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}

