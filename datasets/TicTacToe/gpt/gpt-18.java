import java.util.Scanner;

class TicTacToeGame {
    private final char[] board;
    private final boolean isComputerOpponent;
    private static final Scanner scanner = new Scanner(System.in);

    public TicTacToeGame(boolean isComputerOpponent) {
        this.board = new char[9];
        this.isComputerOpponent = isComputerOpponent;
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = '-';
        }
    }

    private boolean isFieldFree(int index) {
        return board[index] == '-';
    }

    private void placeMark(char mark, int index) {
        board[index] = mark;
    }

    private boolean checkWin(char mark) {
        // Horizontal, Vertical, Diagonal checks
        return (board[0] == mark && board[1] == mark && board[2] == mark) ||
               (board[3] == mark && board[4] == mark && board[5] == mark) ||
               (board[6] == mark && board[7] == mark && board[8] == mark) ||
               (board[0] == mark && board[3] == mark && board[6] == mark) ||
               (board[1] == mark && board[4] == mark && board[7] == mark) ||
               (board[2] == mark && board[5] == mark && board[8] == mark) ||
               (board[0] == mark && board[4] == mark && board[8] == mark) ||
               (board[2] == mark && board[4] == mark && board[6] == mark);
    }

    private boolean isBoardFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.println();
            }
        }
    }

    private int getComputerMove() {
        ComputerOpponent computerOpponent = new ComputerOpponent(board);
        return computerOpponent.decideMove();
    }

    public void startGame() {
        char currentPlayer = 'x';
        boolean gameEnded = false;
        int moveCount = 0;

        printBoard();
        while (!gameEnded) {
            boolean validMove = false;
            int playerMove = -1;
            while (!validMove) {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                if (currentPlayer == 'o' && isComputerOpponent) {
                    playerMove = getComputerMove();
                    System.out.println(playerMove); // Print computer's move
                    validMove = true;
                } else {
                    try {
                        playerMove = Integer.parseInt(scanner.nextLine());
                        validMove = isFieldFree(playerMove);
                    } catch (NumberFormatException e) {
                        validMove = false;
                    }
                }
                if (!validMove) {
                    System.out.println("Invalid move, try again.");
                }
            }
            placeMark(currentPlayer, playerMove);
            printBoard();
            if (checkWin(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("No Winner");
                gameEnded = true;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            moveCount++;
        }
    }

    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && "ki".equals(args[0]);
        TicTacToeGame game = new TicTacToeGame(playWithComputer);
        game.startGame();
        scanner.close();
    }
}

class ComputerOpponent {
    private char[] board;

    public ComputerOpponent(char[] board) {
        this.board = board.clone();
    }

    private boolean canWinNext(char mark) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                board[i] = mark;
                boolean win = checkWin(mark);
                board[i] = '-';
                if (win) {
                    return true;
                }
            }
        }
        return false;
    }

    private int findWinningMove(char mark) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                board[i] = mark;
                if (checkWin(mark)) {
                    board[i] = '-';
                    return i;
                }
                board[i] = '-';
            }
        }
        return -1;
    }

    private boolean checkWin(char mark) {
        return (board[0] == mark && board[1] == mark && board[2] == mark) ||
               (board[3] == mark && board[4] == mark && board[5] == mark) ||
               (board[6] == mark && board[7] == mark && board[8] == mark) ||
               (board[0] == mark && board[3] == mark && board[6] == mark) ||
               (board[1] == mark && board[4] == mark && board[7] == mark) ||
               (board[2] == mark && board[5] == mark && board[8] == mark) ||
               (board[0] == mark && board[4] == mark && board[8] == mark) ||
               (board[2] == mark && board[4] == mark && board[6] == mark);
    }

    private int preventOpponentWin() {
        char opponentMark = 'x'; // Assuming computer is 'o'
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                board[i] = opponentMark;
                if (checkWin(opponentMark)) {
                    board[i] = '-';
                    return i;
                }
                board[i] = '-';
            }
        }
        return -1;
    }

    public int decideMove() {
        // Rule 1: Win
        int winningMove = findWinningMove('o');
        if (winningMove != -1) return winningMove;

        // Rule 2: Prevent Win
        int preventWin = preventOpponentWin();
        if (preventWin != -1) return preventWin;

        // Rule 3: Take center
        if (board[4] == '-') return 4;

        // Rule 4: Take a corner
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board[corner] == '-') return corner;
        }

        // Rule 5: Take any free space
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') return i;
        }

        return -1; // Should never reach here
    }
}