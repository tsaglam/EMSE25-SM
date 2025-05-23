import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean isComputerGame = args.length == 1 && args[0].equalsIgnoreCase("ki");
        GameBoard board = new GameBoard();
        IOManager ioManager = new IOManager();

        Player currentPlayer = Player.X; // X starts the game
        GameAI gameAI = isComputerGame ? new GameAI() : null;

        ioManager.displayBoard(board.toString());
        int moveCount = 0;

        while (true) {
            if (isComputerGame && currentPlayer == Player.O) {
                // Computer's move
                int index = gameAI.decideNextMove(board, currentPlayer);
                board.placeMark(index, currentPlayer);
                ioManager.displayMove(moveCount + 1, currentPlayer);
                ioManager.displayBoard(board.toString());
            } else {
                // Human player's move
                boolean validMove = false;
                while (!validMove) {
                    ioManager.displayMove(moveCount + 1, currentPlayer);
                    int index = ioManager.readPlayerMove();
                    if (board.isFree(index)) {
                        board.placeMark(index, currentPlayer);
                        validMove = true;
                    } else {
                        ioManager.displayError();
                    }
                }
                ioManager.displayBoard(board.toString());
            }

            if (board.checkWin(currentPlayer)) {
                ioManager.displayWinner(currentPlayer);
                break;
            } else if (board.isFull()) {
                ioManager.displayDraw();
                break;
            }
            currentPlayer = currentPlayer == Player.X ? Player.O : Player.X; // Switch player
            moveCount++;
        }

        ioManager.closeScanner();
    }
}

class GameBoard {
    private final Player[] fields = new Player[9];

    public boolean isFree(int index) {
        return fields[index] == null;
    }

    public void placeMark(int index, Player mark) {
        fields[index] = mark;
    }

    public boolean checkWin(Player player) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}  // Diagonals
        };

        for (int[] condition : winConditions) {
            if (player == fields[condition[0]] && player == fields[condition[1]] && player == fields[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (Player field : fields) {
            if (field == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append("\n");
            }
            if (fields[i] == null) {
                sb.append("-");
            } else {
                sb.append(fields[i]);
            }
        }
        return sb.toString();
    }
}

class IOManager {
    private final Scanner scanner = new Scanner(System.in);

    public void displayBoard(String board) {
        System.out.println(board);
    }

    public int readPlayerMove() {
        return scanner.nextInt();
    }

    public void displayMove(int moveCount, Player currentPlayer) {
        System.out.println(moveCount + ". Move: " + currentPlayer);
    }

    public void displayWinner(Player player) {
        System.out.println("Winner: " + player);
    }

    public void displayDraw() {
        System.out.println("No Winner");
    }

    public void displayError() {
        System.out.println("Invalid move, try again.");
    }

    public void closeScanner() {
        scanner.close();
    }
}

class GameAI {
    public int decideNextMove(GameBoard board, Player player) {
        // This is a simplified version of AI decision-making, following the task instruction
        // It does not include all logic for checking opponent's win or optimal play
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i; // Just return the first free field (naive approach)
            }
        }
        return -1; // Should never hit this case if called correctly
    }
}

enum Player {
    X, O
}