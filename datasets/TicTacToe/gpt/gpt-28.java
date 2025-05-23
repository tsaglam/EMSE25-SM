import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game();
        game.start(args);
    }
}

class Game {
    private Board board = new Board();
    private IOManager ioManager = new IOManager();
    private ComputerOpponent computerOpponent = new ComputerOpponent(board);

    public void start(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equalsIgnoreCase("ki");
        char currentPlayer = 'x';
        int moveCount = 0;
        int maxMoves = 9;

        ioManager.displayBoard(board);

        while (moveCount < maxMoves) {
            int index = -1;
            if (playWithComputer && currentPlayer == 'o') {
                index = computerOpponent.decideMove(currentPlayer);
                ioManager.displayMove(moveCount + 1, currentPlayer);
            } else {
                index = ioManager.getNextMove(moveCount + 1, currentPlayer, board);
            }

            board.placeMark(index, currentPlayer);
            moveCount++;
            ioManager.displayBoard(board);

            if (board.hasWon(currentPlayer)) {
                ioManager.displayWinner(currentPlayer);
                return;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }

        ioManager.displayNoWinner();
    }
}

class Board {
    private char[] fields = new char[9];

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public void placeMark(int index, char mark) {
        if (isFieldFree(index)) {
            fields[index] = mark;
        }
    }

    public boolean hasWon(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((fields[i * 3] == player && fields[i * 3 + 1] == player && fields[i * 3 + 2] == player) || 
                (fields[i] == player && fields[i + 3] == player && fields[i + 6] == player)) {
                return true;
            }
        }

        if ((fields[0] == player && fields[4] == player && fields[8] == player) || 
            (fields[2] == player && fields[4] == player && fields[6] == player)) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == '-') {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(fields[i]);
            if (i % 3 == 2 && i != fields.length - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public int calculateWinningMove(char player) {
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) {
                fields[i] = player; // Temporarily place mark
                if (hasWon(player)) {
                    fields[i] = '-'; // Reset
                    return i;
                }
                fields[i] = '-'; // Reset
            }
        }
        return -1;
    }

    public char[] getFields() {
        return fields;
    }
}

class ComputerOpponent {
    private Board board;

    public ComputerOpponent(Board board) {
        this.board = board;
    }

    public int decideMove(char player) {
        int winMove = board.calculateWinningMove(player);
        if (winMove != -1) return winMove;

        char opponent = (player == 'x') ? 'o' : 'x';
        int blockMove = board.calculateWinningMove(opponent);
        if (blockMove != -1) return blockMove;

        // Center
        if (board.isFieldFree(4)) return 4;

        // Corners
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) return corner;
        }

        // Other fields
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) return i;
        }

        return -1; // Should never happen
    }
}

class IOManager {
    private Scanner scanner = new Scanner(System.in);

    public void displayBoard(Board board) {
        System.out.println(board);
    }

    public int getNextMove(int moveNumber, char player, Board board) {
        System.out.println(moveNumber + ". Move: " + player);
        while (true) {
            String input = scanner.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index >= 0 && index < 9 && board.isFieldFree(index)) {
                    return index;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
            }
        }
    }

    public void displayMove(int moveNumber, char player) {
        System.out.println(moveNumber + ". Move: " + player);
    }

    public void displayWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void displayNoWinner() {
        System.out.println("No Winner");
    }

    // Ensure scanner is closed upon termination of application.
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}