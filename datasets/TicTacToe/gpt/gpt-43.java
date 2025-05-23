import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        boolean playWithKI = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithKI);
        game.start();
    }
}

class Game {
    private final Board board;
    private final Scanner scanner;
    private final boolean playWithKI;

    public Game(boolean playWithKI) {
        board = new Board();
        scanner = new Scanner(System.in);
        this.playWithKI = playWithKI;
    }

    public void start() {
        int moveCount = 0;
        char currentPlayer = 'x';
        System.out.println(board);

        while (true) {
            if (playWithKI && currentPlayer == 'o') {
                ComputerOpponent ki = new ComputerOpponent();
                int move = ki.decideMove(board, currentPlayer);
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                board.makeMove(move, currentPlayer);
            } else {
                boolean moveMade = false;
                while (!moveMade) {
                    System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                    int move = readPlayerMove();
                    moveMade = board.makeMove(move, currentPlayer);
                }
            }

            System.out.println(board);
            if (board.hasWinner()) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }

            currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
            moveCount++;
        }

        scanner.close();
    }

    private int readPlayerMove() {
        while (true) {
            try {
                int move = Integer.parseInt(scanner.nextLine());
                if (move >= 0 && move < 9) {
                    return move;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

class Board {
    private final char[] fields = new char[9];

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean makeMove(int index, char player) {
        if (isFieldFree(index)) {
            fields[index] = player;
            return true;
        }
        return false;
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == '-') {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinner() {
        for (int i = 0; i < 8; i += 3) { // Rows
            if (fields[i] != '-' && fields[i] == fields[i + 1] && fields[i] == fields[i + 2]) return true;
        }
        for (int i = 0; i < 3; i++) { // Columns
            if (fields[i] != '-' && fields[i] == fields[i + 3] && fields[i] == fields[i + 6]) return true;
        }
        // Diagonals
        if (fields[0] != '-' && fields[0] == fields[4] && fields[0] == fields[8]) return true;
        if (fields[2] != '-' && fields[2] == fields[4] && fields[2] == fields[6]) return true;

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if ((i + 1) % 3 == 0 && i != 8) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class ComputerOpponent {
    public int decideMove(Board board, char player) {
        // Placeholder for extending the method to use actual strategy rules as defined in the task. 
        // Simple implementation to make a valid move.
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) {
                return i; // Simply returns the first free field.
            }
        }
        return -1; // Should never reach here if called correctly.
    }
}