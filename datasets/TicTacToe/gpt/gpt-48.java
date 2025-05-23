import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        boolean playAgainstKI = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playAgainstKI);
        game.start();
    }
}

class Board {
    private final char[] fields = new char[9];
    private static final char FREE = '-';
    
    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = FREE;
        }
    }
    
    public boolean isFieldFree(int index) {
        return fields[index] == FREE;
    }
    
    public boolean placeMark(int index, char mark) {
        if (isFieldFree(index)) {
            fields[index] = mark;
            return true;
        }
        return false;
    }
    
    public boolean isWinning(char mark) {
        // Checking Rows and Columns and Diagonals for a win
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
            if (field == FREE) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if ((i + 1) % 3 == 0 && i < fields.length - 1) {
                sb.append("\n");
            } 
        }
        return sb.toString();
    }

    public int findWinningField(char mark, char opponentMark) {
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) {
                fields[i] = mark;
                if (isWinning(mark)) {
                    fields[i] = FREE; // Reset
                    return i;
                }
                fields[i] = FREE; // Reset
            }
        }
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) {
                fields[i] = opponentMark;
                if (isWinning(opponentMark)) {
                    fields[i] = FREE; // Reset
                    return i;
                }
                fields[i] = FREE; // Reset
            }
        }
        return -1;
    }
    
    public int getFirstFreeField() {
        for (int i = 0; i < fields.length; i++) {
            if (isFieldFree(i)) {
                return i;
            }
        }
        return -1;
    }
}

class KI {
    public static int getNextMove(Board board, char myMark) {
        char opponentMark = (myMark == 'x') ? 'o' : 'x';
        int winningField = board.findWinningField(myMark, opponentMark);
        if (winningField != -1) return winningField;
        if (board.isFieldFree(4)) return 4; // Center
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) return corner;
        }
        return board.getFirstFreeField(); // Any free field
    }
}

class Game {
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);
    private final boolean playAgainstKI;
    
    public Game(boolean playAgainstKI) {
        this.playAgainstKI = playAgainstKI;
    }
    
    public void start() {
        char currentPlayer = 'x';
        for (int move = 1; !board.isFull(); move++) {
            System.out.println(board);
            System.out.println(move + ". Move: " + currentPlayer);
            boolean validMove = false;
            while (!validMove) {
                int index = -1;
                if (playAgainstKI && currentPlayer == 'o') {
                    index = KI.getNextMove(board, currentPlayer);
                    System.out.println("> " + index); // Simulate Computer Input
                } else {
                    try {
                        index = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number between 0 and 8.");
                        continue;
                    }
                }
                validMove = board.placeMark(index, currentPlayer);
                if (!validMove) {
                    System.out.println("Field is occupied or index is invalid. Please choose another field.");
                }
            }
            if (board.isWinning(currentPlayer)) {
                System.out.println(board);
                System.out.println("Winner: " + currentPlayer);
                return;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        System.out.println("No Winner");
    }
}