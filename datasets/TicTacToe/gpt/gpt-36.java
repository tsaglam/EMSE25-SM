import java.util.Scanner;

// Main class to start the game
class TicTacToe {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Player playerX = new HumanPlayer('x');
        Player playerO = (args.length == 1 && args[0].equals("ki")) ? new ComputerPlayer('o') : new HumanPlayer('o');
        Game game = new Game(board, playerX, playerO);
        game.start();
    }
}

// Game control logic
class Game {
    private final GameBoard board;
    private final Player playerX;
    private final Player playerO;
    private final Scanner scanner;

    public Game(GameBoard board, Player playerX, Player playerO) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        Player currentPlayer = playerX;
        boolean gameEnded = false;

        // Initial empty board display
        System.out.println(board);

        while (!gameEnded) {
            int index = currentPlayer.makeMove(board);
            board.placeMark(index, currentPlayer.getMark());
            System.out.println(board);

            if (board.hasWon(currentPlayer.getMark())) {
                System.out.println("Winner: " + currentPlayer.getMark());
                gameEnded = true;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                gameEnded = true;
            }

            // Swap players
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
        scanner.close();
    }
}

// Game board representation and logic
class GameBoard {
    private final char[] grid;
    private static final int SIZE = 9;

    public GameBoard() {
        this.grid = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            grid[i] = '-';
        }
    }

    public boolean isFree(int index) {
        return grid[index] == '-';
    }

    public void placeMark(int index, char mark) {
        if (index >= 0 && index < SIZE && isFree(index)) {
            grid[index] = mark;
        }
    }

    public boolean hasWon(char mark) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((grid[i * 3] == mark && grid[i * 3 + 1] == mark && grid[i * 3 + 2] == mark) || // rows
                (grid[i] == mark && grid[i + 3] == mark && grid[i + 6] == mark)) { // columns
                return true;
            }
        }
        return (grid[0] == mark && grid[4] == mark && grid[8] == mark) || // diagonal 1
               (grid[2] == mark && grid[4] == mark && grid[6] == mark); // diagonal 2
    }

    public boolean isFull() {
        for (char mark : grid) {
            if (mark == '-') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i += 3) {
            sb.append(grid[i]).append(grid[i + 1]).append(grid[i + 2]).append("\n");
        }
        return sb.toString();
    }
}

// Player interface
interface Player {
    int makeMove(GameBoard board);
    char getMark();
}

// Human player
class HumanPlayer implements Player {
    private final char mark;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public int makeMove(GameBoard board) {
        int move;
        do {
            System.out.println("Enter the position for " + mark + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid input. Please enter a number between 0 and 8.");
                scanner.next(); // Clear the invalid input
            }
            move = scanner.nextInt();
        } while (move < 0 || move > 8 || !board.isFree(move));
        return move;
    }

    @Override
    public char getMark() {
        return mark;
    }
}

// Computer player
class ComputerPlayer implements Player {
    private final char mark;

    public ComputerPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public int makeMove(GameBoard board) {
        // Naive implementation: choose the first available spot
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i;
            }
        }
        return -1; // Should never happen
    }

    @Override
    public char getMark() {
        return mark;
    }
}