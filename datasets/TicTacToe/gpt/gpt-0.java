import java.util.Arrays;
import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        boolean playWithAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playWithAI);
        game.start();
    }
}

class Game {
    private final Board board;
    private final boolean playWithAI;
    private final Scanner scanner;
    private final AIPlayer aiPlayer;

    Game(boolean playWithAI) {
        this.playWithAI = playWithAI;
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.aiPlayer = new AIPlayer();
    }

    void start() {
        char currentPlayer = 'x';
        int moveCount = 0;

        while (true) {
            System.out.println(board);
            if (moveCount >= 9) {
                System.out.println("No Winner");
                break;
            }

            if (playWithAI && currentPlayer == 'o') {
                int aiMove = aiPlayer.computeMove(board, currentPlayer);
                board.placeMark(aiMove, currentPlayer);
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
            } else {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                while (true) {
                    int move = readPlayerMove();
                    if (board.isFree(move)) {
                        board.placeMark(move, currentPlayer);
                        break;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                }
            }

            if (board.checkForWin(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            moveCount++;
        }

        scanner.close();
    }

    private int readPlayerMove() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number between 0 and 8.");
            scanner.next(); // discard non-integer input
        }
        return scanner.nextInt();
    }
}

class Board {
    private final char[] fields;
    private static final int[][] WIN_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}              // diagonals
    };

    Board() {
        fields = new char[9];
        Arrays.fill(fields, '-');
    }

    boolean isFree(int index) {
        return fields[index] == '-';
    }

    void placeMark(int index, char mark) {
        fields[index] = mark;
    }

    boolean checkForWin(char mark) {
        for (int[] condition : WIN_CONDITIONS) {
            if (fields[condition[0]] == mark && fields[condition[1]] == mark && fields[condition[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if ((i + 1) % 3 == 0) sb.append("\n");
        }
        return sb.toString();
    }
}

class AIPlayer {
    // AI logic to compute the next move based on the current board
    int computeMove(Board board, char player) {
        // For simplicity, this AI only randomly selects a free spot
        // Extension with strategy goes here
        // Placeholder code to follow the skeleton. Implement winning strategy, blocking, center, corner, or random moves.
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i; // Return the first free spot found. Extend with strategic moves.
            }
        }
        return -1; // No move found, shouldn't reach here in a normal game.
    }
}