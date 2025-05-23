import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithComputer);
        game.start();
    }
}

class Game {
    private final Board board = new Board();
    private final IO io = new IO();
    private final ComputerOpponent computerOpponent;
    private final boolean playWithComputer;

    public Game(boolean playWithComputer) {
        this.playWithComputer = playWithComputer;
        this.computerOpponent = new ComputerOpponent(this.board);
    }

    public void start() {
        char currentPlayer = 'x';
        while (true) {
            board.printBoard();
            int move;
            if (playWithComputer && currentPlayer == 'o') {
                move = computerOpponent.decideMove('o');
                io.displayComputerMove(move);
            } else {
                move = io.getNextMove(currentPlayer, board);
            }
            board.placeMark(move, currentPlayer);
            if (board.checkWin(currentPlayer)) {
                board.printBoard();
                io.displayWinner(currentPlayer);
                break;
            } else if (board.isFull()) {
                board.printBoard();
                io.displayNoWinner();
                break;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        io.scannerClose();
    }
}

class Board {
    private final char[] fields = new char[9];
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public Board() {
        for (int i = 0; i < fields.length; i++) fields[i] = '-';
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public boolean placeMark(int index, char mark) {
        if (isFieldFree(index)) {
            fields[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin(char mark) {
        for (int[] winCondition : winConditions) {
            if (fields[winCondition[0]] == mark && fields[winCondition[1]] == mark && fields[winCondition[2]] == mark) {
                return true;
            }
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

    public void printBoard() {
        System.out.println("" + fields[0] + fields[1] + fields[2]);
        System.out.println("" + fields[3] + fields[4] + fields[5]);
        System.out.println("" + fields[6] + fields[7] + fields[8]);
    }

    public int getWinningMove(char mark) {
        for (int[] winCondition : winConditions) {
            if (checkPotentialWin(winCondition, mark)) {
                for (int index : winCondition) {
                    if (fields[index] == '-') return index;
                }
            }
        }
        return -1;
    }

    private boolean checkPotentialWin(int[] winCondition, char mark) {
        int markCount = 0;
        int emptyCount = 0;
        for (int index : winCondition) {
            if (fields[index] == mark) markCount++;
            if (fields[index] == '-') emptyCount++;
        }
        return markCount == 2 && emptyCount == 1;
    }

    public int getFirstFreeField() {
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) return i;
        }
        return -1; // should never happen if checked for full board before
    }
}

class IO {
    private final Scanner scanner = new Scanner(System.in);

    public int getNextMove(char player, Board board) {
        int move;
        while (true) {
            System.out.println("Move for player " + player + ":");
            String input = scanner.nextLine();
            try {
                move = Integer.parseInt(input);
                if (move < 0 || move > 8 || !board.isFieldFree(move)) {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
            }
        }
        return move;
    }

    public void displayWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void displayNoWinner() {
        System.out.println("No Winner");
    }

    public void scannerClose() {
        scanner.close();
    }

    public void displayComputerMove(int move) {
        System.out.println("Computer's move: " + move);
    }
}

class ComputerOpponent {
    private final Board board;

    public ComputerOpponent(Board board) {
        this.board = board;
    }

    public int decideMove(char mark) {
        // Rule 1: Win if possible
        int winningMove = board.getWinningMove(mark);
        if (winningMove != -1) return winningMove;

        // Rule 2: Block opponent
        char opponentMark = (mark == 'x') ? 'o' : 'x';
        int blockMove = board.getWinningMove(opponentMark);
        if (blockMove != -1) return blockMove;

        // Rule 3: Take center if free
        if (board.isFieldFree(4)) return 4;

        // Rule 4: Take a corner if free
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) return corner;
        }

        // Rule 5: Take any free field
        return board.getFirstFreeField();
    }
}