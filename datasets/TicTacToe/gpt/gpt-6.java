import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean playAgainstComputer = args.length == 1 && args[0].equalsIgnoreCase("ki");
        IOHandler ioHandler = new IOHandler();
        GameBoard gameBoard = new GameBoard();
        ComputerOpponent computerOpponent = new ComputerOpponent();

        char currentPlayer = 'x';
        boolean gameEnded = false;
        int moveCount = 0;

        ioHandler.printBoard(gameBoard.getBoardAsString());

        while (!gameEnded) {
            int move = -1;
            boolean validMove = false;
            while (!validMove) {
                if (playAgainstComputer && currentPlayer == 'o') {
                    move = computerOpponent.decideMove(gameBoard, 'o');
                    ioHandler.printMove(moveCount + 1, currentPlayer);
                    validMove = true; // Computer move is always valid
                } else {
                    ioHandler.printMove(moveCount + 1, currentPlayer);
                    move = ioHandler.getPlayerMove();
                    validMove = gameBoard.isFieldFree(move);
                }
                if (!validMove) {
                    ioHandler.printInvalidMoveMessage();
                }
            }

            gameBoard.placeMark(move, currentPlayer);
            ioHandler.printBoard(gameBoard.getBoardAsString());

            if (gameBoard.checkWin(currentPlayer)) {
                ioHandler.printWinner(currentPlayer);
                gameEnded = true;
            } else if (gameBoard.isFull()) {
                ioHandler.printDraw();
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
                moveCount++;
            }
        }
    }
}

class GameBoard {
    private final char[] board = new char[9];
    private final int[][] winConditions = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
        {0, 4, 8}, {2, 4, 6}             // Diagonals
    };

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return index >= 0 && index < board.length && board[index] == '-';
    }

    public void placeMark(int index, char mark) {
        if (index >= 0 && index < board.length) {
            board[index] = mark;
        }
    }

    public boolean checkWin(char mark) {
        for (int[] condition : winConditions) {
            if (board[condition[0]] == mark &&
                board[condition[1]] == mark &&
                board[condition[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    public String getBoardAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.append(board[i]);
            if ((i + 1) % 3 == 0 && i != board.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public char[] getBoard() {
        return board;
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void printBoard(String board) {
        System.out.println(board);
    }

    public int getPlayerMove() {
        return scanner.nextInt();
    }

    public void printInvalidMoveMessage() {
        System.out.println("Invalid move, please try again.");
    }

    public void printMove(int moveNumber, char player) {
        System.out.println(moveNumber + ". Move: " + player);
    }

    public void printWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void printDraw() {
        System.out.println("No Winner");
    }
}

class ComputerOpponent {
    public int decideMove(GameBoard gameBoard, char player) {
        char opponent = (player == 'x') ? 'o' : 'x';
        int move = findWinningMove(gameBoard, player);
        if (move != -1) return move;

        move = findWinningMove(gameBoard, opponent);
        if (move != -1) return move;

        if (gameBoard.isFieldFree(4)) return 4;

        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (gameBoard.isFieldFree(corner)) return corner;
        }

        for (int i = 0; i < 9; i++) {
            if (gameBoard.isFieldFree(i)) return i;
        }

        return -1; // Should never get here
    }

    private int findWinningMove(GameBoard gameBoard, char player) {
        char[] board = gameBoard.getBoard();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                board[i] = player; // Temporarily place mark
                if (gameBoard.checkWin(player)) {
                    board[i] = '-'; // Reset
                    return i;
                }
                board[i] = '-'; // Reset
            }
        }
        return -1;
    }
}