import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playWithAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playWithAI);
        game.start();
    }
}

class Game {
    private final GameBoard board = new GameBoard();
    private final IOHandler ioHandler = new IOHandler();
    private final ComputerOpponent computerOpponent = new ComputerOpponent();
    private final boolean playWithAI;

    public Game(boolean playWithAI) {
        this.playWithAI = playWithAI;
    }

    public void start() {
        int moveCount = 0;
        char currentPlayer = 'x';
        while (true) {
            ioHandler.printBoard(board.getBoard());
            boolean validMove = false;
            int move = -1;
            while (!validMove) {
                if (playWithAI && currentPlayer == 'o') {
                    move = computerOpponent.calculateMove(board, currentPlayer);
                    ioHandler.printComputerMove(move);
                    validMove = true;
                } else {
                    ioHandler.printPlayerPrompt(moveCount + 1, currentPlayer);
                    move = ioHandler.getPlayerMove();
                    validMove = board.isPositionValid(move);
                }
            }
            board.placeMark(move, currentPlayer);
            moveCount++;
            if (board.checkWin()) {
                ioHandler.printWinner(currentPlayer);
                break;
            } else if (moveCount == 9) {
                ioHandler.printDraw();
                break;
            }
            currentPlayer = (currentPlayer == 'x' ? 'o' : 'x');
        }
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void printBoard(char[] board) {
        for (int i = 0; i < board.length; i += 3) {
            System.out.println("" + board[i] + board[i + 1] + board[i + 2]);
        }
    }

    public void printPlayerPrompt(int moveNumber, char mark) {
        System.out.println(moveNumber + ". Move: " + mark);
    }

    public void printComputerMove(int move) {
        System.out.println("Computer choses position: " + move);
    }

    public int getPlayerMove() {
        int move;
        while (true) {
            try {
                move = Integer.parseInt(scanner.nextLine());
                return move;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
            }
        }
    }

    public void printWinner(char winnerMark) {
        System.out.println("Winner: " + winnerMark);
    }

    public void printDraw() {
        System.out.println("No Winner");
    }
}

class GameBoard {
    private final char[] board;
    
    public GameBoard() {
        this.board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = '-';
        }
    }

    public boolean isPositionValid(int position) {
        return position >= 0 && position < board.length && board[position] == '-';
    }

    public void placeMark(int position, char mark) {
        if (isPositionValid(position)) {
            board[position] = mark;
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 8; i += 3) // Check rows.
            if (board[i] != '-' && board[i] == board[i + 1] && board[i] == board[i + 2])
                return true;
        for (int i = 0; i < 3; i++) // Check columns.
            if (board[i] != '-' && board[i] == board[i + 3] && board[i] == board[i + 6])
                return true;
        // Check diagonals.
        if (board[0] != '-' && board[0] == board[4] && board[0] == board[8])
            return true;
        if (board[2] != '-' && board[2] == board[4] && board[2] == board[6])
            return true;
        return false;
    }

    public char[] getBoard() {
        return board.clone();
    }
}

class ComputerOpponent {
    public int calculateMove(GameBoard board, char player) {
        // This method should ideally implement the AI move logic,
        // but for simplicity, it will choose the first available spot.
        // The actual implementation would use GameBoard's functionalities.
        for (int i = 0; i < 9; i++) {
            if (board.isPositionValid(i)) {
                return i;
            }
        }
        return -1; // Should never reach here if the game logic is correct.
    }
}