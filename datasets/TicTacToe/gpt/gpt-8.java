import java.util.Scanner;

class TicTacToeGame {

    public static void main(String[] args) {
        boolean playAgainstAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        GameBoard board = new GameBoard();
        IOHandler ioHandler = new IOHandler();
        ComputerOpponent ai = new ComputerOpponent();

        boolean currentPlayerX = true; // 'X' starts the game
        int moveIndex;
        boolean gameEnded = false;

        while (!gameEnded) {
            board.printBoard();

            // Decide the move based on current player or AI
            if (playAgainstAI && !currentPlayerX) {
                moveIndex = ai.decideMove(board, 'o');
                ioHandler.displayMove('o', moveIndex);
            } else {
                char mark = currentPlayerX ? 'x' : 'o';
                moveIndex = ioHandler.getNextMove(board, mark);
            }

            board.placeMark(moveIndex, currentPlayerX ? 'x' : 'o');

            // Check for a winner or if the board is full
            if (board.checkWin()) {
                board.printBoard();
                ioHandler.displayWinner(currentPlayerX ? 'x' : 'o');
                gameEnded = true;
            } else if (board.isFull()) {
                board.printBoard();
                ioHandler.displayNoWinner();
                gameEnded = true;
            }
            currentPlayerX = !currentPlayerX; // Switch player
        }

        ioHandler.closeScanner();
    }
}

class GameBoard {
    private final char[] fields = new char[9];
    private final int[][] winningCombinations = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public GameBoard() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public boolean checkWin() {
        for (int[] combo : winningCombinations) {
            if (fields[combo[0]] != '-' && fields[combo[0]] == fields[combo[1]] && fields[combo[1]] == fields[combo[2]]) {
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

    public void placeMark(int index, char mark) {
        if (isFieldFree(index)) {
            fields[index] = mark;
        }
    }

    public void printBoard() {
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i]);
            if ((i + 1) % 3 == 0) System.out.println();
        }
    }

    public int decideNextMove(char mark) {
        // Method to use existing functionality for AI decisions
        return -1; // Stub, actual logic in ComputerOpponent
    }

    public char[] getFields() {
        return fields;
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getNextMove(GameBoard board, char mark) {
        int move;
        do {
            System.out.println("Enter the index for " + mark + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid input. Please enter an integer between 0 and 8.");
                scanner.next(); // to ignore incorrect input
            }
            move = scanner.nextInt();
        } while (move < 0 || move > 8 || !board.isFieldFree(move));
        return move;
    }

    public void displayWinner(char winner) {
        System.out.println("Winner: " + winner);
    }

    public void displayNoWinner() {
        System.out.println("No Winner");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayMove(char player, int move) {
        System.out.println(player + " chooses " + move);
    }
}

class ComputerOpponent {

    public int decideMove(GameBoard board, char playerMark) {
        char[] fields = board.getFields();
        // First check for a win
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == '-') {
                fields[i] = playerMark;
                if (board.checkWin()) {
                    fields[i] = '-';
                    return i;
                }
                fields[i] = '-';
            }
        }

        // Then block opponent's win
        char opponentMark = (playerMark == 'x') ? 'o' : 'x';
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == '-') {
                fields[i] = opponentMark;
                if (board.checkWin()) {
                    fields[i] = '-';
                    return i;
                }
                fields[i] = '-';
            }
        }

        // Follow the priority: center, corners, then sides
        int[] priorities = {4, 0, 2, 6, 8, 1, 3, 5, 7}; // center, corners, then sides
        for (int priority : priorities) {
            if (fields[priority] == '-') {
                return priority;
            }
        }

        // If for some reason no decision was made, return -1 (should never happen)
        return -1;
    }
}