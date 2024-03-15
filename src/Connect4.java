import java.util.Scanner;
public class Connect4 {
    private String gamemode;
    private boolean multiPlayer = false;
    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Gamemode (Multiplayer/Singleplayer): ");
        gamemode = scan.nextLine().toLowerCase();
        if (gamemode.equals("multiplayer")) {
            multiPlayer = true;
        }
        System.out.print("Board Size: ");
        int boardLength = scan.nextInt();
        while (boardLength > 26) {
            System.out.print("Board Size cannot be greater than 26, please try again: ");
            boardLength = scan.nextInt();
        }
        Board board = new Board(boardLength);
        board.printBoard();
    }
}
