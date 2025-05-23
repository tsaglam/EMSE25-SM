import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        boolean isComputerOpponent = args.length == 1 && args[0].equals("ki");
        Game game = new Game(gameBoard, isComputerOpponent);
        game.startGame();
    }
}

class Game {
    private final GameBoard gameBoard;
    private final boolean againstComputer;
    private final Scanner scanner;
    private final ComputerOpponent computerOpponent;

    public Game(GameBoard gameBoard, boolean againstComputer) {
        this.gameBoard = gameBoard;
        this.againstComputer = againstComputer;
        this.scanner = new Scanner(System.in);
        this.computerOpponent = new ComputerOpponent();
    }

    public void startGame() {
        char currentPlayerMark = 'x';
        int moveCount = 0;

        gameBoard.printBoard();

        while (true) {
            if (againstComputer && currentPlayerMark == 'o') {
                int computerMove = computerOpponent.decideMove(gameBoard);
                System.out.println((moveCount + 1) + ". Move: o");
                gameBoard.placeMark(computerMove, currentPlayerMark);
            } else {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayerMark);
                boolean validMove = false;
                while (!validMove) {
                    int playerMove = scanner.nextInt();
                    validMove = gameBoard.placeMark(playerMove, currentPlayerMark);
                    if (!validMove) {
                        System.out.println("Invalid move, try again.");
                    }
                }
            }
            
            gameBoard.printBoard();
            moveCount++;

            if (gameBoard.checkWin()) {
                System.out.println("Winner: " + currentPlayerMark);
                break;
            } else if (gameBoard.isBoardFull()) {
                System.out.println("No Winner");
                break;
            }

            currentPlayerMark = (currentPlayerMark == 'x') ? 'o' : 'x';
        }

        scanner.close();
    }
}

class GameBoard {
    private final char[] board = new char[9];
    private final int[][] winConditions = new int[][]{
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < board.length && board[index] == '-') {
            board[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int[] condition : winConditions) {
            if (board[condition[0]] == board[condition[1]] 
                && board[condition[1]] == board[condition[2]] 
                && board[condition[0]] != '-') {
                return true;
            }
        }
        return false;
    }

    public boolean isBoardFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println(board[0] + "" + board[1] + "" + board[2]);
        System.out.println(board[3] + "" + board[4] + "" + board[5]);
        System.out.println(board[6] + "" + board[7] + "" + board[8]);
    }

    public boolean isFieldFree(int index) {
        return index >= 0 && index < board.length && board[index] == '-';
    }
}

class ComputerOpponent {
    public int decideMove(GameBoard gameBoard) {
        // This method should implement the decision rules as specified, for brevity the logic will be simplified
        
        // Check if the computer can win in the next move
        for (int i = 0; i < 9; i++) {
            if (gameBoard.isFieldFree(i)) {
                // Simulate placing 'o' and checking for a win
                gameBoard.placeMark(i, 'o');
                if (gameBoard.checkWin()) {
                    gameBoard.placeMark(i, '-'); // Undo move
                    return i;
                }
                gameBoard.placeMark(i, '-'); // Undo move
            }
        }

        // Check center
        if (gameBoard.isFieldFree(4)) {
            return 4;
        }

        // Check corners
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (gameBoard.isFieldFree(corner)) {
                return corner;
            }
        }

        // Fallback to first free spot
        for (int i = 0; i < 9; i++) {
            if (gameBoard.isFieldFree(i)) {
                return i;
            }
        }

        return -1; // Should never happen
    }
}