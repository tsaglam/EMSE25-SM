import java.util.Scanner;

class TicTacToeGame {

    public static void main(String[] args) {
        boolean vsComputer = args.length == 1 && args[0].equals("ki");
        Game game = new Game(vsComputer);
        game.startGame();
    }
}

class Game {
    private final Board board;
    private final boolean vsComputer;
    private final Scanner scanner;
    private final ComputerOpponent computerOpponent;

    public Game(boolean vsComputer) {
        this.board = new Board();
        this.vsComputer = vsComputer;
        this.scanner = new Scanner(System.in);
        this.computerOpponent = new ComputerOpponent();
    }

    public void startGame() {
        board.printBoard();

        int moveCount = 0;
        char player = 'x';
        while (true) {
            if (vsComputer && player == 'o') {
                int move = computerOpponent.decideMove(board, 'o');
                System.out.println((moveCount + 1) + ". Move: " + player);
                board.placeMark(move, player);
            } else {
                boolean validMove = false;
                while (!validMove) {
                    System.out.println((moveCount + 1) + ". Move: " + player);
                    String input = scanner.nextLine();
                    try {
                        int move = Integer.parseInt(input);
                        validMove = board.placeMark(move, player);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 8.");
                    }
                }
            }

            board.printBoard();
            moveCount++;

            if (board.checkForWin(player)) {
                System.out.println("Winner: " + player);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }

            player = (player == 'x') ? 'o' : 'x';
        }

        scanner.close();
    }
}

class Board {
    private final char[] fields;
    private static final int SIZE = 9;

    public Board() {
        this.fields = new char[SIZE];
        for (int i = 0; i < SIZE; i++) {
            fields[i] = '-';
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index < 0 || index >= SIZE || fields[index] != '-') {
            return false;
        }
        fields[index] = mark;
        return true;
    }

    public boolean checkForWin(char mark) {
        return (checkRows(mark) || checkColumns(mark) || checkDiagonals(mark));
    }

    private boolean checkRows(char mark) {
        for (int i = 0; i < SIZE; i += 3) {
            if (mark == fields[i] && mark == fields[i + 1] && mark == fields[i + 2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char mark) {
        for (int i = 0; i < 3; i++) {
            if (mark == fields[i] && mark == fields[i + 3] && mark == fields[i + 6]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char mark) {
        return (mark == fields[0] && mark == fields[4] && mark == fields[8]) ||
               (mark == fields[2] && mark == fields[4] && mark == fields[6]);
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            if (fields[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(fields[i]);
            if (i % 3 == 2) {
                System.out.println();
            }
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public char[] getFields() {
        return fields;
    }
}

class ComputerOpponent {
    public int decideMove(Board board, char player) {
        char[] fields = board.getFields();
        char opponent = player == 'x' ? 'o' : 'x';

        // Rule 1: Win
        for (int i = 0; i < fields.length; i++) {
            if (board.isFieldFree(i)) {
                fields[i] = player;
                if (board.checkForWin(player)) {
                    fields[i] = '-';
                    return i;
                }
                fields[i] = '-';
            }
        }

        // Rule 2: Block
        for (int i = 0; i < fields.length; i++) {
            if (board.isFieldFree(i)) {
                fields[i] = opponent;
                if (board.checkForWin(opponent)) {
                    fields[i] = '-';
                    return i;
                }
                fields[i] = '-';
            }
        }

        // Rule 3: Center
        if (board.isFieldFree(4)) {
            return 4;
        }

        // Rule 4: Corner
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) {
                return corner;
            }
        }

        // Rule 5: Any free
        for (int i = 0; i < fields.length; i++) {
            if (board.isFieldFree(i)) {
                return i;
            }
        }

        return -1; // Should never hit this because it would mean no moves available
    }
}