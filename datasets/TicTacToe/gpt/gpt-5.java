import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithComputer);
        game.start();
    }
}

class Game {
    private Board board;
    private boolean playWithComputer;
    private final Scanner scanner;

    public Game(boolean playWithComputer) {
        this.playWithComputer = playWithComputer;
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int moveCount = 0;
        char currentPlayer = 'x';

        board.printBoard();

        while (true) {
            if (playWithComputer && currentPlayer == 'o') {
                ComputerPlayer computerPlayer = new ComputerPlayer();
                int move = computerPlayer.chooseMove(board);
                System.out.println((moveCount + 1) + ". Move: o");
                board.placeMove(move, currentPlayer);
            } else {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                while (true) {
                    int move = readPlayerMove();
                    if (board.isMoveValid(move)) {
                        board.placeMove(move, currentPlayer);
                        break;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                }
            }

            board.printBoard();

            if (board.checkWin()) {
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

    private int readPlayerMove() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the non-integer input
            System.out.println("Please enter a number between 0 and 8:");
        }
        return scanner.nextInt();
    }
}

class Board {
    private char[] cells = new char[9];
    private final char EMPTY = '-';

    public Board() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = EMPTY;
        }
    }

    public boolean isMoveValid(int move) {
        return move >= 0 && move < cells.length && cells[move] == EMPTY;
    }

    public void placeMove(int move, char player) {
        if(isMoveValid(move)) {
            cells[move] = player;
        }
    }

    public boolean checkWin() {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}             // diagonals
        };
        for (int[] condition : winConditions) {
            if (cells[condition[0]] != EMPTY &&
                cells[condition[0]] == cells[condition[1]] &&
                cells[condition[1]] == cells[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char cell : cells) {
            if (cell == EMPTY) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < cells.length; i++) {
            System.out.print(cells[i]);
            if ((i + 1) % 3 == 0) System.out.println();
        }
    }

    public boolean isFree(int index) {
        return cells[index] == EMPTY;
    }

    public int calculateWinningMove(char player) {
        for (int i = 0; i < cells.length; i++) {
            if (isFree(i)) {
                cells[i] = player;
                boolean win = checkWin();
                cells[i] = EMPTY;
                if (win) return i;
            }
        }
        return -1;
    }
}

class ComputerPlayer {
    
    public int chooseMove(Board board) {
        for (int i = 0; i < 9; i++) {
            // Rule 1: Win
            int winningMove = board.calculateWinningMove('o');
            if (winningMove != -1) return winningMove;
            
            // Rule 2: Block Win
            int blockMove = board.calculateWinningMove('x');
            if (blockMove != -1) return blockMove;
        }
        
        // Rule 3: Take Center
        if (board.isFree(4)) return 4;
        
        // Rule 4: Take a corner
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFree(corner)) return corner;
        }
        
        // Rule 5: Take any free space
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) return i;
        }
        
        return -1; // Should never happen
    }
}