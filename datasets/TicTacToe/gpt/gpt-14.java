import java.util.Scanner;

class TicTacToeGame {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        IOHandler ioHandler = new IOHandler();
        boolean againstComputer = args.length == 1 && args[0].equals("ki");
        ComputerOpponent computerOpponent = new ComputerOpponent();

        char currentPlayer = 'x';
        boolean gameRunning = true;
        while (gameRunning) {
            ioHandler.printGameBoard(gameBoard);
            boolean validMove = false;

            while (!validMove) {
                int move;
                if (againstComputer && currentPlayer == 'o') {
                    move = computerOpponent.decideMove(gameBoard, 'o');
                } else {
                    move = ioHandler.getPlayerMove(currentPlayer);
                }

                validMove = gameBoard.placeMark(move, currentPlayer);

                if (!validMove) {
                    ioHandler.printInvalidMoveMessage();
                }
            }

            if (gameBoard.checkWin(currentPlayer)) {
                ioHandler.printWinner(currentPlayer);
                gameRunning = false;
            } else if (gameBoard.isFull()) {
                ioHandler.printDraw();
                gameRunning = false;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int getPlayerMove(char player) {
        System.out.println(player + "'s turn. Enter the index of your move:");
        while (!scanner.hasNextInt()) {
            scanner.next(); // consume the non-integer input
            System.out.println("Invalid. Please enter a number between 0 and 8:");
        }
        return scanner.nextInt();
    }

    public void printGameBoard(GameBoard board) {
        System.out.println(board);
    }

    public void printInvalidMoveMessage() {
        System.out.println("Invalid move, try again.");
    }

    public void printWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void printDraw() {
        System.out.println("No Winner");
    }
}

class GameBoard {
    private final char[] fields = new char[9];
    private int moveCount = 0;

    public GameBoard() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFull() {
        return moveCount == 9;
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < 9 && fields[index] == '-') {
            fields[index] = mark;
            moveCount++;
            return true;
        }
        return false;
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((fields[i * 3] == player && fields[i * 3 + 1] == player && fields[i * 3 + 2] == player) || // rows
                (fields[i] == player && fields[i + 3] == player && fields[i + 6] == player)) { // columns
                return true;
            }
        }
        return (fields[0] == player && fields[4] == player && fields[8] == player) || // diagonal
               (fields[2] == player && fields[4] == player && fields[6] == player); // anti-diagonal
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i % 3 == 2 && i != 8) sb.append("\n");
        }
        return sb.toString();
    }
}

class ComputerOpponent {
    public int decideMove(GameBoard board, char player) {
        // Insert the logic for the computer opponent based on the provided rules.
        // This can use the methods in GameBoard to check for winning opportunities etc.
        // Placeholder implementation for compilation purposes
        return 0; // Need to implement the logic as per the assignment instructions.
    }
}