import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame(args.length == 1 && args[0].equals("ki"));
    }
}

class Game {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);
    private final ComputerOpponent computerOpponent = new ComputerOpponent();

    public void startGame(boolean againstComputer) {
        String currentPlayer = "x";
        boolean isGameOver = false;
        printBoard();

        while (!isGameOver) {
            isGameOver = makeMove(currentPlayer, againstComputer && currentPlayer.equals("o"));
            currentPlayer = currentPlayer.equals("x") ? "o" : "x";
        }

        scanner.close();
    }

    private boolean makeMove(String player, boolean isComputer) {
        boolean isValidMove;
        int position;

        do {
            if (!isComputer) {
                System.out.println("Move for: " + player);
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number between 0 and 8.");
                    scanner.next(); // consume the invalid input
                }
                position = scanner.nextInt();
            } else {
                position = computerOpponent.decideMove(board, player);
                System.out.println("Computer (" + player + ") chooses: " + position);
            }

            isValidMove = board.placeMark(position, player);
            if (!isValidMove) {
                System.out.println("This position is already occupied or out of range, please choose another one.");
            }
        } while (!isValidMove);

        printBoard();

        if (board.checkWin(player)) {
            System.out.println("Winner: " + player);
            return true;
        } else if (board.isFull()) {
            System.out.println("No Winner");
            return true;
        }
        return false;
    }

    private void printBoard() {
        System.out.println(board);
    }
}

class Board {
    private final String[] grid = new String[9];
    private final int[][] winningCombinations = new int[][]{
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    Board() {
        for (int i = 0; i < 9; i++) grid[i] = "-";
    }

    public boolean placeMark(int index, String player) {
        if (index < 0 || index >= 9 || !grid[index].equals("-")) {
            return false;
        }
        grid[index] = player;
        return true;
    }

    public boolean checkWin(String player) {
        for (int[] combination : winningCombinations) {
            if (player.equals(grid[combination[0]]) &&
                player.equals(grid[combination[1]]) &&
                player.equals(grid[combination[2]])) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (String s : grid) {
            if (s.equals("-")) {
                return false;
            }
        }
        return true;
    }

    public boolean isFree(int index) {
        return grid[index].equals("-");
    }

    @Override
    public String toString() {
        return String.join("", grid[0], grid[1], grid[2]) + "\n" +
               String.join("", grid[3], grid[4], grid[5]) + "\n" +
               String.join("", grid[6], grid[7], grid[8]);
    }
}

class ComputerOpponent {
    int decideMove(Board board, String player) {
        String opponent = player.equals("x") ? "o" : "x";
        // Try to win
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                board.placeMark(i, player);
                if (board.checkWin(player)) {
                    board.placeMark(i, "-"); // Undo
                    return i;
                }
                board.placeMark(i, "-"); // Undo
            }
        }
        // Block opponent's win
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                board.placeMark(i, opponent);
                if (board.checkWin(opponent)) {
                    board.placeMark(i, "-"); // Undo
                    return i;
                }
                board.placeMark(i, "-"); // Undo
            }
        }
        // Take center if free
        if (board.isFree(4)) {
            return 4;
        }
        // Take a corner if free
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFree(corner)) {
                return corner;
            }
        }
        // Take any free space
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i;
            }
        }
        return -1; // Should never get here if game logic is correct
    }
}