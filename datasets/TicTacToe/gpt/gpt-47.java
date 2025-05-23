import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game(args.length == 1 && args[0].equals("ki"));
        game.play();
    }
}

class Game {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);
    private final boolean againstComputer;
    private char currentPlayer = 'x';

    public Game(boolean againstComputer) {
        this.againstComputer = againstComputer;
    }

    public void play() {
        int moveCount = 0;
        System.out.println(board);
        while (true) {
            System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
            boolean moveMade = makeMove();
            if (!moveMade) {
                continue;
            }
            System.out.println(board);
            if (board.hasWinner()) {
                System.out.println("Winner: " + currentPlayer);
                break;
            }
            if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }
            moveCount++;
            switchPlayer();
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
    }

    private boolean makeMove() {
        int move;
        if (currentPlayer == 'o' && againstComputer) {
            move = board.calculateBestMove(currentPlayer);
            System.out.println("> " + move);
        } else {
            while (!scanner.hasNextInt()) {
                scanner.next(); // consume the invalid input
                System.out.println("Please enter a number between 0 and 8:");
            }
            move = scanner.nextInt();
        }
        return board.makeMove(move, currentPlayer);
    }
}

class Board {
    private final char[] fields = new char[9];
    private static final int[][] WIN_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean makeMove(int index, char player) {
        if (index >= 0 && index < fields.length && fields[index] == '-') {
            fields[index] = player;
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

    public boolean hasWinner() {
        for (int[] winCondition : WIN_CONDITIONS) {
            if (fields[winCondition[0]] != '-' &&
                fields[winCondition[0]] == fields[winCondition[1]] &&
                fields[winCondition[1]] == fields[winCondition[2]]) {
                return true;
            }
        }
        return false;
    }

    public int calculateBestMove(char player) {
       // Framework for decision process: win, block, center, corners, empty
       for (int i = 0; i < WIN_CONDITIONS.length; i++) {
           int[] condition = WIN_CONDITIONS[i];
           int score = 0;
           int emptyIndex = -1;
           for (int j : condition) {
               if (fields[j] == player) score++;
               else if (fields[j] == '-') emptyIndex = j;
           }
           if (score == 2 && emptyIndex != -1) return emptyIndex; // Win or block
       }

       // Prevent opponent's victory or achieve own victory
       char opponent = (player == 'x') ? 'o' : 'x';
       for (int i = 0; i < WIN_CONDITIONS.length; i++) {
           int[] condition = WIN_CONDITIONS[i];
           int playerCount = 0;
           int opponentCount = 0;
           int emptyIndex = -1;
           for (int j : condition) {
               if (fields[j] == player) playerCount++;
               else if (fields[j] == opponent) opponentCount++;
               else emptyIndex = j;
           }
           if (opponentCount == 2 && emptyIndex != -1) return emptyIndex;
       }

       // Center
       if (fields[4] == '-') return 4;

       // Corners
       int[] corners = {0, 2, 6, 8};
       for (int corner : corners) {
           if (fields[corner] == '-') return corner;
       }

       // Any empty field
       for (int i = 0; i < fields.length; i++) {
           if (fields[i] == '-') return i;
       }

       return -1; // should never reach here
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i % 3 == 2 && i < fields.length - 1) sb.append("\n");
        }
        return sb.toString();
    }
}