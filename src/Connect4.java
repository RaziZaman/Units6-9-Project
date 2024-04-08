import java.util.Scanner;
public class Connect4 {
    private String gamemode = "";
    private boolean multiPlayer = false;
    public void start() {
        Scanner scan = new Scanner(System.in);
        while (!gamemode.equals("multiplayer") && !gamemode.equals("singleplayer")) {
            System.out.print("Gamemode (Multiplayer/Singleplayer): ");
            gamemode = scan.nextLine().toLowerCase();
        }
        if (gamemode.equals("multiplayer")) {
            multiPlayer = true;
        }
        System.out.print("Board Size: ");
        int boardLength = scan.nextInt();
        while (boardLength > 26 || boardLength < 9) {
            System.out.print("Board Size cannot be greater than 26 or less than 9, please try again: ");
            boardLength = scan.nextInt();
        }
        String[][] board1 = new String[boardLength][boardLength];
        Board board = new Board(board1);
        Bot board2 = new Bot(board1);
        if (multiPlayer) {
            while (!board.xCheck() && !board.oCheck() && !board.tieCheck()) {
                board.printBoard(1);
                board.player1Choice();
                if (!board.xCheck() && !board.oCheck() && !board.tieCheck()) {
                    board.printBoard(2);
                    if (board.xCheck() || board.oCheck() || board.tieCheck()) {
                        board.printBoard(0);
                    } else {
                        board.player2Choice();
                    }
                }
            }
        }
        if (!multiPlayer) {
            while (!board.xCheck() && !board.oCheck() && !board.tieCheck()) {
                board.printBoard(1);
                board.player1Choice();
                if (!board.xCheck() && !board.oCheck() && !board.tieCheck()) {
                    board2.player2Choice();
                }
                if (board.xCheck() || board.oCheck() || board.tieCheck()) {
                    board.printBoard(0);
                }
            }
        }
        if (board.xCheck()) {
            System.out.println("Game over, Player 1 Wins.");
        } else if (board.oCheck()) {
            System.out.println("Game over, Player 2 Wins.");
        } else if (board.tieCheck()) {
            System.out.println("Game Over, ended in a tie. ");
        }
    }
}
