import java.util.Scanner;

class TicTacToe {
    private final Scanner scanner = new Scanner(System.in);
    private final GameBoard gameBoard = new GameBoard();
    private final ComputerPlayer computerPlayer = new ComputerPlayer();

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean playWithKI = args.length == 1 && "ki".equals(args[0]);

        game.startGame(playWithKI);
    }

    private void startGame(boolean playWithKI) {
        char currentPlayer = 'x';
        int moveCount = 0;

        while (true) {
            gameBoard.printBoard();
            boolean isValidMove;

            do {
                if (!(playWithKI && currentPlayer == 'o')) {
                    System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                    System.out.print("> ");
                    String input = scanner.nextLine();

                    try{
                        int move = Integer.parseInt(input);
                        isValidMove = gameBoard.placeMark(move, currentPlayer);
                    } catch (NumberFormatException e) {
                        isValidMove = false;
                    }
                } else {
                    int move = computerPlayer.decideMove(gameBoard, currentPlayer);
                    System.out.println(move);
                    isValidMove = gameBoard.placeMark(move, currentPlayer);
                }

                if (!isValidMove) {
                    System.out.println("Invalid move, try again.");
                }
            } while (!isValidMove);

            moveCount++;
            if (gameBoard.checkWin()) {
                gameBoard.printBoard();
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (moveCount == 9) {
                gameBoard.printBoard();
                System.out.println("No Winner");
                break;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }

        scanner.close();
    }
}

class GameBoard {
    private final char[] board = new char[9];
    private final char emptySlot = '-';

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = emptySlot;
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index < 0 || index >= board.length || board[index] != emptySlot) {
            return false;
        }

        board[index] = mark;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == emptySlot) continue;
            if (board[i] == board[i + 1] && board[i] == board[i + 2]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[i] == emptySlot) continue;
            if (board[i] == board[i + 3] && board[i] == board[i + 6]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return board[0] != emptySlot && board[0] == board[4] && board[0] == board[8] ||
               board[2] != emptySlot && board[2] == board[4] && board[2] == board[6];
    }
}

class ComputerPlayer {
    public int decideMove(GameBoard board, char currentPlayer) {
        // This is a simplified version needing GameBoard methods for full functionality
        // Assuming GameBoard has necessary methods implemented
        return 0; // Placeholder for compilation
    }
}