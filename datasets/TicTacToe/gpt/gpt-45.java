import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        TicTacToeGame game = new TicTacToeGame(playWithComputer);
        game.playGame();
    }
}

class TicTacToeGame {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private boolean playWithComputer;

    public TicTacToeGame(boolean playWithComputer) {
        this.board = new Board();
        this.playerX = new HumanPlayer('x');
        this.playWithComputer = playWithComputer;
        if (playWithComputer) {
            this.playerO = new ComputerPlayer('o');
        } else {
            this.playerO = new HumanPlayer('o');
        }
    }

    public void playGame() {
        System.out.println("Starting a new game of Tic-Tac-Toe!");
        char currentPlayerMark = 'x'; // Player X always starts.
        int moveCount = 0;
        boolean gameWon = false;

        board.printBoard();

        while (moveCount < 9 && !gameWon) {
            if (currentPlayerMark == 'x') {
                gameWon = playerX.makeMove(board, moveCount + 1);
                currentPlayerMark = 'o';
            } else {
                gameWon = playerO.makeMove(board, moveCount + 1);
                currentPlayerMark = 'x';
            }
            moveCount++;

            if (gameWon) {
                System.out.println("Winner: " + (currentPlayerMark == 'o' ? 'x' : 'o'));
            } else if (moveCount == 9) {
                System.out.println("No Winner");
            }
        }
    }
}

abstract class Player {
    protected char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    abstract boolean makeMove(Board board, int moveNumber);
}

class HumanPlayer extends Player {
    private static final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char mark) {
        super(mark);
    }

    @Override
    boolean makeMove(Board board, int moveNumber) {
        boolean validMove = false;
        int position = -1;

        while (!validMove) {
            System.out.println(moveNumber + ". Move: " + mark);
            try {
                position = Integer.parseInt(scanner.nextLine());
                validMove = board.placeMark(position, mark);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
            }
            if (!validMove) System.out.println("Invalid move or position already occupied. Try again.");
        }
        board.printBoard();
        return board.checkWin();
    }
}

class ComputerPlayer extends Player {
    public ComputerPlayer(char mark) {
        super(mark);
    }

    @Override
    boolean makeMove(Board board, int moveNumber) {
        System.out.println(moveNumber + ". Move: " + mark);
        // Implementation of naive AI rules
        int position = board.findBestMove(mark);
        board.placeMark(position, mark);
        board.printBoard();
        return board.checkWin();
    }
}

class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        this.board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = '-';
            }
        }
    }

    public boolean checkWin() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
               board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0];
    }

    public boolean placeMark(int index, char mark) {
        int row = index / SIZE;
        int col = index % SIZE;
        if (index < 0 || index >= SIZE * SIZE || board[row][col] != '-') {
            return false;
        }
        board[row][col] = mark;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // Simplified version for demonstration. Implement logic for finding the best move here.
    public int findBestMove(char mark) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            int row = i / SIZE;
            int col = i % SIZE;
            if (board[row][col] == '-') {
                return i; // Naive approach: return the first empty position
            }
        }
        return 0; // Should never happen if method is called correctly
    }

}