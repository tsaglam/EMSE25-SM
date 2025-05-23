import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        IOManager ioManager = new IOManager();
        boolean isComputerOpponent = args.length == 1 && args[0].equalsIgnoreCase("ki");

        Player currentPlayer = Player.X;
        int moveCount = 0;
        boolean gameEnded = false;

        while (!gameEnded) {
            ioManager.printBoard(board);
            boolean moveMade = false;
            while (!moveMade) {
                if (isComputerOpponent && currentPlayer == Player.O) {
                    int computerMove = ComputerOpponent.decideMove(board);
                    board.placeMark(computerMove, currentPlayer);
                    ioManager.printMove(moveCount + 1, currentPlayer, computerMove);
                    moveMade = true;
                } else {
                    int playerMove = ioManager.askForMove(moveCount + 1, currentPlayer);
                    if (board.isFieldFree(playerMove)) {
                        board.placeMark(playerMove, currentPlayer);
                        moveMade = true;
                    }
                }
            }

            gameEnded = board.checkForWin(currentPlayer) || board.isFull();
            if (!gameEnded) {
                currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
            }
            moveCount++;
        }

        ioManager.printBoard(board);
        if (board.checkForWin(Player.X)) {
            ioManager.printWinner(Player.X);
        } else if (board.checkForWin(Player.O)) {
            ioManager.printWinner(Player.O);
        } else {
            ioManager.printNoWinner();
        }
    }
}

class GameBoard {
    private Player[][] fields = new Player[3][3];

    public boolean isFieldFree(int index) {
        return fields[index / 3][index % 3] == null;
    }

    public void placeMark(int index, Player player) {
        fields[index / 3][index % 3] = player;
    }

    public boolean checkForWin(Player player) {
        for (int i = 0; i < 3; i++) {
            if ((player == fields[i][0] && player == fields[i][1] && player == fields[i][2]) ||
                (player == fields[0][i] && player == fields[1][i] && player == fields[2][i])) {
                return true;
            }
        }
        // Check diagonals
        if ((player == fields[0][0] && player == fields[1][1] && player == fields[2][2]) ||
            (player == fields[0][2] && player == fields[1][1] && player == fields[2][0])) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(fields[i][j] != null ? fields[i][j] : "-");
            }
            if (i < 2) sb.append("\n");
        }
        return sb.toString();
    }

    // Additional method needed for the computer opponent strategy
    public int findWinningMoveOrBlock(Player player) {
        for (int i = 0; i < 9; i++) {
            if (isFieldFree(i)) {
                placeMark(i, player); // Temporarily place mark
                if (checkForWin(player)) {
                    removeMark(i); // Remove temporary mark
                    return i;
                }
                removeMark(i); // Remove temporary mark
            }
        }
        return -1;
    }
    
    public int findCenterOrCorner() {
        if (isFieldFree(4)) return 4; // Center
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (isFieldFree(corner)) return corner;
        }
        return findFirstFreeField(); // Fallback
    }
    
    private void removeMark(int index) {
        fields[index / 3][index % 3] = null;
    }
    
    private int findFirstFreeField() {
        for (int i = 0; i < 9; i++) {
            if (isFieldFree(i)) return i;
        }
        return -1; // Should never happen if used correctly
    }
}

class IOManager {
    private Scanner scanner = new Scanner(System.in);

    public void printBoard(GameBoard board) {
        System.out.println(board);
    }

    public int askForMove(int moveNumber, Player player) {
        System.out.println(moveNumber + ". Move: " + player);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the invalid input
            System.out.println("Invalid input. Please enter a number between 0 and 8.");
        }
        return scanner.nextInt();
    }

    public void printMove(int moveNumber, Player player, int move) {
        System.out.println(moveNumber + ". Move: " + player + " > " + move);
    }

    public void printWinner(Player player) {
        System.out.println("Winner: " + player);
    }

    public void printNoWinner() {
        System.out.println("No Winner");
    }

    public void closeScanner() {
        scanner.close();
    }
}

class ComputerOpponent {
    public static int decideMove(GameBoard board) {
        // Win
        int move = board.findWinningMoveOrBlock(Player.O);
        if (move != -1) return move;
        // Block
        move = board.findWinningMoveOrBlock(Player.X);
        if (move != -1) return move;
        // Center or corner
        return board.findCenterOrCorner();
    }
}

enum Player {
    X, O
}