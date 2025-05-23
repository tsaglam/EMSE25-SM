import java.util.Scanner;
import java.util.Arrays;

class TicTacToe {
    public static void main(String[] args) {
        IO io = new IO();
        Board board = new Board();
        ComputerPlayer computerPlayer = null;

        boolean isVsComputer = args.length == 1 && args[0].equals("ki");
        if (isVsComputer) {
            computerPlayer = new ComputerPlayer();
        }

        char currentPlayer = 'x';
        int moveCount = 0;
        while (true) {
            io.printBoard(board);
            int index;
            if (isVsComputer && currentPlayer == 'o') {
                index = computerPlayer.decideMove(board, 'o');
                io.printMove(moveCount + 1, currentPlayer, index);
            } else {
                index = io.getPlayerMove(board, moveCount + 1, currentPlayer);
            }
            board.placeMark(index, currentPlayer);
            moveCount++;

            if (board.checkWin()) {
                io.printBoard(board);
                io.printWinner(currentPlayer);
                break;
            } else if (board.isFull()) {
                io.printBoard(board);
                io.printNoWinner();
                break;
            }
            currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
        }
        io.closeScanner();
    }
}

class Board {
    private final char[] cells = new char[9];
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
    };

    public Board() {
        Arrays.fill(cells, '-');
    }

    public boolean isOccupied(int index) {
        return cells[index] != '-';
    }

    public void placeMark(int index, char mark) {
        if (!isOccupied(index)) {
            cells[index] = mark;
        }
    }

    public boolean checkWin() {
        for (int[] condition : winConditions) {
            if (cells[condition[0]] != '-' &&
                    cells[condition[0]] == cells[condition[1]] &&
                    cells[condition[1]] == cells[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char cell : cells) {
            if (cell == '-') {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            builder.append(cells[i]);
            if ((i + 1) % 3 == 0 && i != 8) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public boolean isFreeIndex(int index) {
        return !isOccupied(index);
    }

    public int getFreeFieldForWin(char mark) {
        for (int[] condition : winConditions) {
            char first = cells[condition[0]];
            char second = cells[condition[1]];
            char third = cells[condition[2]];

            if (first == mark && second == mark && third == '-') return condition[2];
            if (first == mark && second == '-' && third == mark) return condition[1];
            if (first == '-' && second == mark && third == mark) return condition[0];
        }
        return -1;
    }
}

class IO {
    private final Scanner scanner = new Scanner(System.in);

    public int getPlayerMove(Board board, int moveNumber, char player) {
        int index;
        do {
            System.out.println(moveNumber + ". Move: " + player);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
                scanner.next(); // to skip the wrong input
            }
            index = scanner.nextInt();
        } while (index < 0 || index > 8 || board.isOccupied(index));
        return index;
    }

    public void printBoard(Board board) {
        System.out.println(board.toString());
    }

    public void printWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void printNoWinner() {
        System.out.println("No Winner");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void printMove(int moveNumber, char player, int index) {
        // Convenient for computer moves
        System.out.println(moveNumber + ". Move: " + player + " at " + index);
    }
}

class ComputerPlayer {
    public int decideMove(Board board, char player) {
        // Win
        int winMove = board.getFreeFieldForWin(player);
        if (winMove != -1) return winMove;

        // Block
        char opponent = player == 'x' ? 'o' : 'x';
        int blockMove = board.getFreeFieldForWin(opponent);
        if (blockMove != -1) return blockMove;

        // Center
        if (board.isFreeIndex(4)) return 4;

        // Corners
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFreeIndex(corner)) return corner;
        }

        // Any free
        for (int i = 0; i < 9; i++) {
            if (board.isFreeIndex(i)) return i;
        }

        return -1; // Should never reach here if called correctly
    }
}