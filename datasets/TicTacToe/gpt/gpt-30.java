import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board();
        Player playerX = new HumanPlayer('x');
        Player playerO = (args.length == 1 && args[0].equalsIgnoreCase("ki")) ? new ComputerPlayer('o') : new HumanPlayer('o');

        System.out.println(board);
        boolean turnX = true;
        int moveCount = 0;
        while (!board.isFull() && !board.hasWinner()) {
            if (turnX) {
                playerX.makeMove(board);
            } else {
                playerO.makeMove(board);
            }
            System.out.println(board);
            if (board.hasWinner()) {
                System.out.println("Winner: " + (turnX ? 'x' : 'o'));
                return;
            }
            turnX = !turnX;
            moveCount++;
        }
        if (board.isFull() && !board.hasWinner()) {
            System.out.println("No Winner");
        }
    }
}

class Board {
    private final char[][] fields = new char[3][3];
    private static final char EMPTY = '-';

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = EMPTY;
            }
        }
    }

    public boolean isFree(int index) {
        return fields[index / 3][index % 3] == EMPTY;
    }

    public boolean placeMark(int index, char mark) {
        if (isFree(index)) {
            fields[index / 3][index % 3] = mark;
            return true;
        }
        return false;
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] != EMPTY && fields[i][0] == fields[i][1] && fields[i][1] == fields[i][2]) return true;
            if (fields[0][i] != EMPTY && fields[0][i] == fields[1][i] && fields[1][i] == fields[2][i]) return true;
        }
        if (fields[0][0] != EMPTY && fields[0][0] == fields[1][1] && fields[1][1] == fields[2][2]) return true;
        if (fields[0][2] != EMPTY && fields[0][2] == fields[1][1] && fields[1][1] == fields[2][0]) return true;
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : fields) {
            for (char cell : row) {
                sb.append(cell);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

interface Player {
    void makeMove(Board board);
}

class HumanPlayer implements Player {
    private final char mark;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char mark) {
        this.mark = mark;
    }

    public void makeMove(Board board) {
        int move;
        do {
            System.out.println("Player " + mark + ", enter your move (0-8): ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter a number between 0 and 8: ");
                scanner.next();
            }
            move = scanner.nextInt();
        } while (move < 0 || move > 8 || !board.isFree(move));
        board.placeMark(move, mark);
    }
}

class ComputerPlayer implements Player {
    private final char mark;

    public ComputerPlayer(char mark) {
        this.mark = mark;
    }

    @Override
    public void makeMove(Board board) {
        // Implementation for AI (Naive Strategy) goes here
        // For simplicity, this example will randomly pick an empty spot
        // A more sophisticated approach would implement the mentioned strategies
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                board.placeMark(i, mark);
                break;
            }
        }
    }
}