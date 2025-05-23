import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playWithComputer);
        game.start();
    }
}

class Game {
    private final Board board;
    private final boolean playWithComputer;
    private final Scanner scanner;
    private int moveCount;
    private char currentPlayerMark;

    public Game(boolean playWithComputer) {
        this.board = new Board();
        this.playWithComputer = playWithComputer;
        this.scanner = new Scanner(System.in);
        this.moveCount = 0;
        this.currentPlayerMark = 'x'; // Player 'x' starts
    }

    public void start() {
        do {
            System.out.println(board);
            printMovePrompt();
            int position = readPosition();
            board.placeMark(position, currentPlayerMark);
            if (board.hasWinner(currentPlayerMark)) {
                System.out.println(board);
                System.out.println("Winner: " + currentPlayerMark);
                return;
            }
            switchPlayer();
        } while (!board.isFull());

        System.out.println(board);
        System.out.println("No Winner");
    }

    private void printMovePrompt() {
        System.out.println((moveCount + 1) + ". Move: " + currentPlayerMark);
        if (playWithComputer && currentPlayerMark == 'o') {
            ComputerOpponent computer = new ComputerOpponent(board);
            System.out.println("> " + computer.decideMove('o'));
        }
    }

    private int readPosition() {
        int position = -1;
        boolean validInput = false;
        while (!validInput) {
            if (!playWithComputer || currentPlayerMark == 'x') {
                try {
                    position = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 0 and 8:");
                    continue;
                }
            } else if (playWithComputer && currentPlayerMark == 'o') {
                ComputerOpponent computer = new ComputerOpponent(board);
                position = computer.decideMove('o');
            }

            validInput = board.isValidMove(position);
            if (!validInput) {
                System.out.println("Move not valid, try again:");
            }
        }
        moveCount++;
        return position;
    }

    private void switchPlayer() {
        currentPlayerMark = (currentPlayerMark == 'x') ? 'o' : 'x';
    }
}

class Board {
    private final char[] fields;
    private static final char FREE_FIELD = '-';

    public Board() {
        this.fields = new char[9];
        java.util.Arrays.fill(fields, FREE_FIELD);
    }

    public boolean isValidMove(int position) {
        return position >= 0 && position < fields.length && fields[position] == FREE_FIELD;
    }

    public void placeMark(int position, char mark) {
        fields[position] = mark;
    }

    public boolean hasWinner(char mark) {
        int[][] winConditions = new int[][]{
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}             // diagonals
        };
        for (int[] condition : winConditions) {
            if (mark == fields[condition[0]] && mark == fields[condition[1]] && mark == fields[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == FREE_FIELD) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if ((i + 1) % 3 == 0 && i < fields.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class ComputerOpponent {
    private final Board board;

    public ComputerOpponent(Board board) {
        this.board = board;
    }

    public int decideMove(char computerMark) {
        // Simplified logic for computer move decisions omitted for brevity. Needs implementation.
        return -1; // Placeholder, implement decision logic based on assignment specs.
    }
}