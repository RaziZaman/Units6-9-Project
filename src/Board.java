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
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + alphabet[i] + "  ");
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j != board[0].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != board.length - 1) {
                for (int k = 0; k < board.length; k++) {
                    System.out.print("----");
                }
            }
            System.out.println();
        }
    }
}
