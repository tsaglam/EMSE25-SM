import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean playWithAI = args.length == 1 && args[0].equals("ki");
        Board board = new Board();
        IOHandler ioHandler = new IOHandler();
        board.printBoard();

        int player = 0; // 0 for x, 1 for o
        ComputerPlayer ai = new ComputerPlayer();

        while (true) {
            if (playWithAI && player == 1) {
                int move = ai.decideMove(board);
                board.placeMark(move, player);
                ioHandler.printMove(player, move);
            } else {
                ioHandler.handlePlayerMove(player, board);
            }

            board.printBoard();
            if (board.checkWin()) {
                ioHandler.printWinner(player);
                break;
            } else if (board.isFull()) {
                ioHandler.printDraw();
                break;
            }
            player = 1 - player; // Switch player
        }
    }
}

class Board {
    char[][] fields = new char[3][3];
    
    public Board() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                fields[i][j] = '-';
    }
    
    boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] == fields[i][1] && fields[i][1] == fields[i][2] && fields[i][0] != '-')
                return true;
            if (fields[0][i] == fields[1][i] && fields[1][i] == fields[2][i] && fields[0][i] != '-')
                return true;
        }
        if (fields[0][0] == fields[1][1] && fields[1][1] == fields[2][2] && fields[0][0] != '-')
            return true;
        if (fields[0][2] == fields[1][1] && fields[1][1] == fields[2][0] && fields[0][2] != '-')
            return true;
        return false;
    }

    void placeMark(int index, int player) {
        fields[index / 3][index % 3] = (player == 0) ? 'x' : 'o';
    }
    
    boolean isFieldOccupied(int index) {
        return fields[index / 3][index % 3] != '-';
    }

    boolean isFull() {
        for (char[] row : fields)
            for (char cell : row)
                if (cell == '-') return false;
        return true;
    }

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(fields[i][j]);
            System.out.println();
        }
    }
    
    // Additional method needed for AI and game logic (e.g., checking if a move wins the game)
    // Implement as needed for computer logic...
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    void handlePlayerMove(int player, Board board) {
        int move;
        while (true) {
            System.out.println((player + 1) + ". Move: " + ((player == 0) ? "x" : "o"));
            try {
                move = Integer.parseInt(scanner.nextLine());
                if (move >= 0 && move < 9 && !board.isFieldOccupied(move)) {
                    board.placeMark(move, player);
                    break;
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    void printMove(int player, int move) {
        System.out.println("Computer chose: " + move);
    }

    void printWinner(int player) {
        System.out.println("Winner: " + ((player == 0) ? "x" : "o"));
    }

    void printDraw() {
        System.out.println("No Winner");
    }
}

class ComputerPlayer {
    // Decision logic for the computer opponent
    
    int decideMove(Board board) {
        // Implement AI logic here based on the assignment description
        // Placeholder logic: choose first available cell
        for (int i = 0; i < 9; i++) {
            if (!board.isFieldOccupied(i)) {
                return i;
            }
        }
        return -1; // Should never hit this because the game ends before full board without a winner
    }
    
    // AI logic to find winnable moves or blocks as described in the assignment
}