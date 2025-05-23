import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playWithAI = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithAI);
        game.start();
    }
}

class Game {
    private final Board board = new Board();
    private final IO io = new IO();
    private final boolean playWithAI;
    private final AIPlayer aiPlayer;

    public Game(boolean playWithAI) {
        this.playWithAI = playWithAI;
        this.aiPlayer = new AIPlayer();
    }

    public void start() {
        char currentPlayer = 'x';
        while (true) {
            io.printBoard(board);
            int move;

            if (playWithAI && currentPlayer == 'o') {
                move = aiPlayer.decideMove(board);
                io.printAIMove(move);
            } else {
                move = io.getNextMove(board, currentPlayer);
            }

            board.placeMark(move, currentPlayer);
            if (board.isWinner(currentPlayer)) {
                io.printBoard(board);
                io.declareWinner(currentPlayer);
                break;
            }
            if (board.isFull()) {
                io.printBoard(board);
                io.declareDraw();
                break;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
    }
}

class Board {
    private final char[] fields = new char[9];
    private static final int[][] WIN_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
    };

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public void placeMark(int index, char mark) {
        fields[index] = mark;
    }

    public boolean isWinner(char player) {
        for (int[] winCondition : WIN_CONDITIONS) {
            if (fields[winCondition[0]] == player &&
                    fields[winCondition[1]] == player &&
                    fields[winCondition[2]] == player) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i % 3 == 2 && i != 8) sb.append("\n");
        }
        return sb.toString();
    }

    public int findWinningMove(char player) {
        for (int[] condition : WIN_CONDITIONS) {
            int[] marks = {0, 0, -1}; // Count of player's marks and index of empty field
            for (int index : condition) {
                if (fields[index] == player) marks[0]++;
                else if (fields[index] == '-') marks[1] = index;
            }
            if (marks[0] == 2 && marks[1] != -1) return marks[1];
        }
        return -1; // No winning move found
    }

    public int findBlockingMove(char opponent) {
        return findWinningMove(opponent); // Same logic can be used for blocking
    }

    public int getAutoMove() {
        // Center
        if (isFieldFree(4)) return 4;
        // Corners
        for (int i : new int[]{0, 2, 6, 8}) {
            if (isFieldFree(i)) return i;
        }
        // Other free fields
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) return i;
        }
        return -1; // Should never happen
    }
}

class IO {
    private final Scanner scanner = new Scanner(System.in);

    public int getNextMove(Board board, char player) {
        int move;
        do {
            System.out.println(player + "'s turn. Enter a field (0-8):");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid input. Enter a number between 0 and 8.");
                scanner.next(); // Discard non-integer input
            }
            move = scanner.nextInt();
        } while (move < 0 || move > 8 || !board.isFieldFree(move));
        return move;
    }

    public void printBoard(Board board) {
        System.out.println(board);
    }

    public void declareWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void declareDraw() {
        System.out.println("No Winner");
    }

    public void printAIMove(int move) {
        System.out.println("AI (o) selects: " + move);
    }
}

class AIPlayer {
    public int decideMove(Board board) {
        char ai = 'o';
        char human = 'x';
        // Win
        int move = board.findWinningMove(ai);
        if (move != -1) return move;
        // Block
        move = board.findBlockingMove(human);
        if (move != -1) return move;
        // Center
        if (board.isFieldFree(4)) return 4;
        // Corners
        for (int i : new int[]{0, 2, 6, 8}) {
            if (board.isFieldFree(i)) return i;
        }
        // Other
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) return i;
        }
        return -1; // Should never be reached
    }
}