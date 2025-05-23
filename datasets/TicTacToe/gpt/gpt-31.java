import java.util.Scanner;

class TicTacToeGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean vsComputer = false;

    public static void main(String[] args) {
        vsComputer = args.length == 1 && args[0].equals("ki");
        Board board = new Board();
        int currentPlayer = 0; // 0 for 'x', 1 for 'o'
        boolean isWinner = false;
        int moveCount = 0;

        System.out.println(board);

        while (moveCount < 9 && !isWinner) {
            int move;
            if (vsComputer && currentPlayer == 1) { // Computer's turn
                move = ComputerPlayer.decideMove(board, 'o');
                System.out.println("Computer (o) selects: " + move);
            } else {
                System.out.println((moveCount + 1) + ". Move: " + (currentPlayer == 0 ? "x" : "o"));
                while (true) {
                    String input = scanner.nextLine();
                    try {
                        move = Integer.parseInt(input);
                        if (move < 0 || move >= 9 || !board.isFieldFree(move)) {
                            System.out.println("Invalid input. Try again.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number between 0 and 8.");
                    }
                }
            }

            board.placeMark(move, currentPlayer == 0 ? 'x' : 'o');
            System.out.println(board);
            isWinner = board.checkForWin(currentPlayer == 0 ? 'x' : 'o');
            if (isWinner) {
                System.out.println("Winner: " + (currentPlayer == 0 ? 'x' : 'o'));
                break;
            }

            if (moveCount == 8) {
                System.out.println("No Winner");
            }

            currentPlayer = 1 - currentPlayer; // Switch player
            moveCount++;
        }

        scanner.close();
    }
}

class Board {
    private final char[][] fields = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j] = '-';
            }
        }
    } 

    public boolean isFieldFree(int index) {
        return fields[index / 3][index % 3] == '-';
    }

    public void placeMark(int index, char mark) {
        fields[index / 3][index % 3] = mark;
    }

    public boolean checkForWin(char mark) {
        for (int i = 0; i < 3; i++) {
            if ((fields[i][0] == mark && fields[i][1] == mark && fields[i][2] == mark) || // Rows
                (fields[0][i] == mark && fields[1][i] == mark && fields[2][i] == mark)) { // Columns
                return true;
            }
        }
        return (fields[0][0] == mark && fields[1][1] == mark && fields[2][2] == mark) || // Diagonal
               (fields[0][2] == mark && fields[1][1] == mark && fields[2][0] == mark); // Anti-diagonal
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(fields[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (fields[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canWinNextMove(char mark, int index) {
        if (isFieldFree(index)) {
            placeMark(index, mark); // Temporarily place the mark
            boolean canWin = checkForWin(mark);
            placeMark(index, '-'); // Remove the mark
            return canWin;
        }
        return false;
    }
}

class ComputerPlayer {
    public static int decideMove(Board board, char mark) {
        for (int i = 0; i < 9; i++) {
            if (board.canWinNextMove(mark, i)) {
                return i;
            }
        }
        char opponentMark = (mark == 'x') ? 'o' : 'x';
        for (int i = 0; i < 9; i++) {
            if (board.canWinNextMove(opponentMark, i)) {
                return i;
            }
        }
        if (board.isFieldFree(4)) {
            return 4; // Center
        }
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) {
                return corner;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) {
                return i;
            }
        }
        throw new IllegalStateException("No valid moves left");
    }
}