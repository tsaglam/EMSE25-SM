import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        boolean playWithAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playWithAI);
        game.startGame();
    }
}

class Game {
    private final Board board;
    private final boolean playWithAI;
    private final Scanner scanner;
    private final AIPlayer aiPlayer;

    public Game(boolean playWithAI) {
        this.board = new Board();
        this.playWithAI = playWithAI;
        this.scanner = new Scanner(System.in);
        this.aiPlayer = new AIPlayer();
    }

    public void startGame() {
        char currentPlayer = 'x';
        int moveCount = 0;

        while (true) {
            System.out.println(board);
            if (playWithAI && currentPlayer == 'o') {
                int move = aiPlayer.decideMove(board, currentPlayer);
                System.out.println(moveCount + 1 + ". Move: " + currentPlayer);
                board.placeMark(move, currentPlayer);
            } else {
                boolean validMove = false;
                while (!validMove) {
                    System.out.println(moveCount + 1 + ". Move: " + currentPlayer);
                    String input = scanner.nextLine();
                    try {
                        int move = Integer.parseInt(input);
                        validMove = board.placeMark(move, currentPlayer);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 8.");
                    }
                }
            }
            moveCount++;
            if (board.checkWin()) {
                System.out.println(board);
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (moveCount == 9) {
                System.out.println(board);
                System.out.println("No Winner");
                break;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        scanner.close();
    }
}

class Board {
    private final char[] fields;
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public Board() {
        this.fields = new char[9];
        java.util.Arrays.fill(fields, '-');
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length && fields[index] == '-') {
            fields[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int[] condition : winConditions) {
            if (fields[condition[0]] == fields[condition[1]] &&
                fields[condition[1]] == fields[condition[2]] &&
                fields[condition[0]] != '-') {
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
            if (i % 3 == 2 && i != 8) sb.append("\n");
        }
        return sb.toString();
    }
}

class AIPlayer {
    public int decideMove(Board board, char player) {
        // Placeholder for AI decision logic
        // This should be implemented to follow the provided specifications
        // For simplicity, this method returns 0. Implement the AI logic as per the task's demand.
        return 0;
    }
}