import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        boolean playAgainstAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playAgainstAI);
        game.start();
    }

}

class Game {
    private final Board board;
    private final Scanner scanner;
    private final boolean playAgainstAI;

    public Game(boolean playAgainstAI) {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.playAgainstAI = playAgainstAI;
    }

    public void start() {
        int moveCount = 0;
        char currentPlayer = 'x';

        while (true) {
            if (playAgainstAI && currentPlayer == 'o') {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                int aiMove = AI.findBestMove(board, currentPlayer);
                board.placeMark(aiMove, currentPlayer);
            } else {
                boolean moveValid = false;
                do {
                    System.out.println(board);
                    System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                    String input = scanner.nextLine();
                    try {
                        int position = Integer.parseInt(input);
                        moveValid = board.placeMark(position, currentPlayer);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                } while (!moveValid);
            }

            System.out.println(board);

            if (board.hasWon(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            moveCount++;
        }

        scanner.close();
    }
}

class Board {
    private final char[] fields = new char[9];

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean placeMark(int position, char mark) {
        if (position < 0 || position >= fields.length || fields[position] != '-') {
            return false;
        }
        fields[position] = mark;
        return true;
    }

    public boolean isFree(int position) {
        return fields[position] == '-';
    }

    public boolean hasWon(char mark) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((fields[i * 3] == mark && fields[i * 3 + 1] == mark && fields[i * 3 + 2] == mark) ||
                (fields[i] == mark && fields[i + 3] == mark && fields[i + 6] == mark)) {
                return true;
            }
        }
        return (fields[0] == mark && fields[4] == mark && fields[8] == mark) ||
               (fields[2] == mark && fields[4] == mark && fields[6] == mark);
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
            if (i % 3 == 2 && i < fields.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class AI {
    static int findBestMove(Board board, char player) {
        // Example AI logic placeholder - you can expand with real AI logic
        // For simplicity, this AI picks the first free spot
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i;
            }
        }
        return -1; // Should never reach here if called correctly
    }
}