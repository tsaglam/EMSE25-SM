import java.util.Scanner;

class TicTacToeGame {

    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithComputer);
        game.start();
    }
}

class Game {
    private final Board board;
    private final boolean playWithComputer;
    private final Scanner scanner;
    private int moveCount;
    private char currentPlayer;

    public Game(boolean playWithComputer) {
        this.board = new Board();
        this.playWithComputer = playWithComputer;
        this.scanner = new Scanner(System.in);
        this.moveCount = 0;
        this.currentPlayer = 'x';
    }

    public void start() {
        while (true) {
            board.printBoard();
            boolean moveMade = makeMove();
            if (moveMade) {
                if (board.checkWin()) {
                    board.printBoard();
                    System.out.println("Winner: " + currentPlayer);
                    break;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("No Winner");
                    break;
                }
                switchPlayer();
            }
        }
        scanner.close();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
    }

    private boolean makeMove() {
        int position;
        if (!(playWithComputer && currentPlayer == 'o')) {
            System.out.println(++moveCount + ". Move: " + currentPlayer);
            while (true) {
                String input = scanner.nextLine();
                try {
                    position = Integer.parseInt(input);
                    if (position >= 0 && position <= 8 && board.isFree(position)) {
                        break;
                    } else {
                        System.out.println("Invalid move. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 0 and 8.");
                }
            }
        } else {
            position = ComputerOpponent.decideMove(board, currentPlayer);
            System.out.println(++moveCount + ". Move: " + currentPlayer);
        }
        board.placeMark(position, currentPlayer);
        return true;
    }
}

class Board {
    private final char[] cells;
    
    public Board() {
        this.cells = new char[9];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '-';
        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(cells[i] + "" + cells[i+1] + "" + cells[i+2]);
        }
    }

    public boolean isFree(int position) {
        return cells[position] == '-';
    }

    public void placeMark(int position, char player) {
        cells[position] = player;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (cells[i] == cells[i + 3] && cells[i] == cells[i + 6] && cells[i] != '-')
                return true;
            if (cells[3 * i] == cells[3 * i + 1] && cells[3 * i] == cells[3 * i + 2] && cells[3 * i] != '-')
                return true;
        }
        if (cells[0] == cells[4] && cells[0] == cells[8] && cells[0] != '-')
            return true;
        if (cells[2] == cells[4] && cells[2] == cells[6] && cells[2] != '-')
            return true;

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
}

class ComputerOpponent {
    
    public static int decideMove(Board board, char player) {
        char opponent = (player == 'x') ? 'o' : 'x';
        // Check if computer can win
        int winMove = findWinningMove(board, player);
        if (winMove != -1) return winMove;
        // Block opponent's win
        int blockMove = findWinningMove(board, opponent);
        if (blockMove != -1) return blockMove;
        // Take center if free
        if (board.isFree(4)) return 4;
        // Take a corner if free
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFree(corner)) return corner;
        }
        // Take any free space
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) return i;
        }
        return -1; // Should never get here
    }
    
    private static int findWinningMove(Board board, char player) {
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                board.placeMark(i, player);
                if (board.checkWin()) {
                    board.placeMark(i, '-');
                    return i;
                }
                board.placeMark(i, '-');
            }
        }
        return -1;
    }
}