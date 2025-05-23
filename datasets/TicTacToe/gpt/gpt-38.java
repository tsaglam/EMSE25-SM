import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game(args.length > 0 && args[0].equals("ki"));
        game.playGame();
    }
}

class Game {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);
    private final boolean againstAI;
    private final AIPlayer aiPlayer;

    public Game(boolean againstAI) {
        this.againstAI = againstAI;
        this.aiPlayer = new AIPlayer();
    }

    public void playGame() {
        char currentPlayer = 'x';
        boolean gameEnded = false;
        board.printBoard();

        for (int move = 1; !gameEnded && move <= 9; move++) {
            if (againstAI && currentPlayer == 'o') {
                int index = aiPlayer.decideMove(board);
                System.out.println(move + ". Move: o");
                board.placeMark(index, currentPlayer);
            } else {
                boolean validMove = false;
                do {
                    System.out.println(move + ". Move: " + currentPlayer);
                    String input = scanner.nextLine();
                    try {
                        int position = Integer.parseInt(input);
                        validMove = board.placeMark(position, currentPlayer);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 8.");
                    }
                } while (!validMove);
            }

            board.printBoard();

            if (board.checkWin()) {
                System.out.println("Winner: " + currentPlayer);
                gameEnded = true;
            } else if (move == 9) {
                System.out.println("No Winner");
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        scanner.close();
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
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean placeMark(int index, char player) {
        if (index >= 0 && index <= 8 && fields[index] == '-') {
            fields[index] = player;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int[] condition : winConditions) {
            if (fields[condition[0]] == fields[condition[1]] && fields[condition[1]] == fields[condition[2]] && fields[condition[0]] != '-') {
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < fields.length; i += 3) {
            System.out.println(fields[i] + "" + fields[i+1] + "" + fields[i+2]);
        }
    }

    public boolean isFieldAvailable(int index) {
        return fields[index] == '-';
    }

    public char[] getFields() {
        return fields;
    }
}

class AIPlayer {
    public int decideMove(Board board) {
        // AI logic to decide the next move, including checking for win, block, center, corner, and others.
        char[] fields = board.getFields();
        int move = -1;

        // Check if AI or opponent can win in the next move, AI prioritizes winning over blocking
        move = findWinningMove(fields, 'o');
        if(move != -1) return move;

        move = findWinningMove(fields, 'x');
        if(move != -1) return move;

        // Check for center
        if(board.isFieldAvailable(4)) return 4;

        // Check for an empty corner
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldAvailable(corner)) {
                return corner;
            }
        }

        // Pick any available move
        for (int i = 0; i < fields.length; i++) {
            if (board.isFieldAvailable(i)) {
                return i;
            }
        }

        // Fallback, should never get here.
        return -1;
    }

    private int findWinningMove(char[] fields, char player) {
        for (int i = 0; i < fields.length; i++) {
            char[] copyOfFields = fields.clone();
            if (copyOfFields[i] == '-') {
                copyOfFields[i] = player;
                Board tempBoard = new Board();
                for (int j = 0; j < copyOfFields.length; j++) {
                    tempBoard.placeMark(j, copyOfFields[j]);
                }
                if (tempBoard.checkWin()) {
                    return i;
                }
            }
        }
        return -1;
    }
}