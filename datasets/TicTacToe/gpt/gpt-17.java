import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame(args.length == 1 && args[0].equals("ki"));
    }
}

class Game {
    private final Board board = new Board();
    private final IOHandler ioHandler = new IOHandler();
    private boolean vsComputer;

    public void startGame(boolean vsComputer) {
        this.vsComputer = vsComputer;
        int turn = 0;
        ioHandler.printBoard(board);
        while (true) {
            boolean isPlayerX = turn % 2 == 0;
            if (vsComputer && !isPlayerX) {
                ComputerOpponent.move(board, 'o');
            } else {
                ioHandler.playerMove(board, isPlayerX ? 'x' : 'o', turn + 1);
            }
            ioHandler.printBoard(board);
            if (board.hasWinner()) {
                ioHandler.printWinner(isPlayerX ? 'x' : 'o');
                break;
            }
            if (board.isFull()) {
                ioHandler.printDraw();
                break;
            }
            turn++;
        }
    }
}

class Board {
    private final char[] fields = new char[9];
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFieldOccupied(int index) {
        return fields[index] != '-';
    }

    public void placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length) {
            fields[index] = mark;
        }
    }

    public boolean hasWinner() {
        for (int[] winCondition : winConditions) {
            if (fields[winCondition[0]] == fields[winCondition[1]]
                    && fields[winCondition[1]] == fields[winCondition[2]]
                    && fields[winCondition[0]] != '-') {
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

    public String getBoardString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            stringBuilder.append(fields[i]);
            if (i % 3 == 2 && i != fields.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public int findWinningMove(char mark) {
        for (int[] winCondition : winConditions) {
            int countMark = 0;
            int emptyIndex = -1;
            for (int j : winCondition) {
                if (fields[j] == mark) countMark++;
                else if (fields[j] == '-') emptyIndex = j;
            }
            if (countMark == 2 && emptyIndex != -1) return emptyIndex;
        }
        return -1;
    }

    public boolean canBlockOpponent(char opponentMark, char myMark) {
        return findWinningMove(opponentMark) != -1;
    }

    public char[] getFields() {
        return fields;
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void playerMove(Board board, char mark, int moveNumber) {
        System.out.println(moveNumber + ". Move: " + mark);
        while (true) {
            try {
                int move = Integer.parseInt(scanner.nextLine());
                if (move >= 0 && move < 9 && !board.isFieldOccupied(move)) {
                    board.placeMark(move, mark);
                    break;
                } else {
                    System.out.println("Invalid move, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number between 0 and 8.");
            }
        }
    }

    public void printBoard(Board board) {
        System.out.println(board.getBoardString());
    }

    public void printWinner(char mark) {
        System.out.println("Winner: " + mark);
    }

    public void printDraw() {
        System.out.println("No Winner");
    }
}

class ComputerOpponent {
    public static void move(Board board, char mark) {
        // Check for winning move
        int move = board.findWinningMove(mark);
        if (move == -1) {
            // Check for block
            move = board.findWinningMove(mark == 'x' ? 'o' : 'x');
        }
        if (move == -1 && !board.isFieldOccupied(4)) {
            move = 4; // Take center
        } else {
            // Select a corner or any free space
            int[] preferences = {0, 2, 6, 8, 1, 3, 5, 7}; // Corners first
            for (int pref : preferences) {
                if (!board.isFieldOccupied(pref)) {
                    move = pref;
                    break;
                }
            }
        }
        board.placeMark(move, mark);
    }
}