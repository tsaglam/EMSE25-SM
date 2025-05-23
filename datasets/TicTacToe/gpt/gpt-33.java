import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        GameController controller = new GameController(board);
        String gameMode = args.length > 0 ? args[0] : "";
        controller.startGame(gameMode.equals("ki"));
    }
}

class TicTacToeBoard {
    private char[] board;
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public TicTacToeBoard() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return board[index] == '-';
    }

    public boolean placeMark(int index, char mark) {
        if (isFieldFree(index)) {
            board[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin(char mark) {
        for (int[] winCondition : winConditions) {
            if (board[winCondition[0]] == mark && board[winCondition[1]] == mark && board[winCondition[2]] == mark) {
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

    public String boardToString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i += 3) {
            builder.append(board[i]).append(board[i + 1]).append(board[i + 2]).append("\n");
        }
        return builder.toString();
    }

    public int findWinningMove(char mark) {
        for (int i = 0; i < 9; i++) {
            if (isFieldFree(i)) {
                board[i] = mark;
                boolean win = checkWin(mark);
                board[i] = '-';
                if (win) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findBlockingMove(char opponentMark) {
        return findWinningMove(opponentMark);
    }
}

class GameController {
    private TicTacToeBoard board;
    private Scanner inputScanner;
    private boolean againstComputer;

    public GameController(TicTacToeBoard board) {
        this.board = board;
        this.inputScanner = new Scanner(System.in);
    }

    public void startGame(boolean againstComputer) {
        char currentPlayer = 'x';
        this.againstComputer = againstComputer;
        int moveCount = 0;

        while (true) {
            System.out.println(board.boardToString());
            boolean moveMade = makeMove(currentPlayer, moveCount + 1);
            if (!moveMade) {
                continue;
            }
            moveCount++;
            if (board.checkWin(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isBoardFull()) {
                System.out.println("No Winner");
                break;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            if (againstComputer && currentPlayer == 'o') {
                ComputerOpponent opponent = new ComputerOpponent(board);
                opponent.makeMove();
                currentPlayer = 'x';
                moveCount++;
                if (board.checkWin('o')) {
                    System.out.println(board.boardToString());
                    System.out.println("Winner: o");
                    break;
                } else if (board.isBoardFull()) {
                    System.out.println(board.boardToString());
                    System.out.println("No Winner");
                    break;
                }
            }
        }

        inputScanner.close();
    }

    private boolean makeMove(char player, int moveNumber) {
        if (againstComputer && player == 'o') {
            return true; // Skip input for computer moves
        }

        System.out.println(moveNumber + ". Move: " + player);
        while (!inputScanner.hasNextInt()) {
            inputScanner.next(); // Consume the invalid input
            System.out.println("Invalid input. Please enter a number between 0-8:");
        }
        int index = inputScanner.nextInt();
        if (index < 0 || index > 8 || !board.isFieldFree(index)) {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        board.placeMark(index, player);
        return true;
    }
}

class ComputerOpponent {
    private TicTacToeBoard board;

    public ComputerOpponent(TicTacToeBoard board) {
        this.board = board;
    }

    public void makeMove() {
        int moveIndex = calculateMove();
        board.placeMark(moveIndex, 'o');
        System.out.println("Computer placed o at " + moveIndex);
    }

    private int calculateMove() {
        int move = board.findWinningMove('o');
        if (move != -1) return move;
        
        move = board.findBlockingMove('x');
        if (move != -1) return move;

        if (board.isFieldFree(4)) return 4;

        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFieldFree(corner)) return corner;
        }

        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) return i;
        }

        return -1; // Should never happen
    }
}