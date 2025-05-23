import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBoard board = new GameBoard();
        boolean isComputerEnabled = args.length == 1 && args[0].equals("ki");
        AIPlayer aiPlayer = new AIPlayer();

        String currentPlayer = "x";
        boolean gameEnded = false;

        board.printBoard();

        while (!gameEnded) {
            if (isComputerEnabled && currentPlayer.equals("o")) {
                int aiMove = aiPlayer.decideMove(board);
                board.placeMark(aiMove, currentPlayer);
                System.out.println(board.moveNumber + ". Move: " + currentPlayer);
                board.printBoard();
                if (board.checkWin()) {
                    System.out.println("Winner: " + currentPlayer);
                    gameEnded = true;
                } else if (board.isFull()) {
                    System.out.println("No Winner");
                    gameEnded = true;
                }
                currentPlayer = "x";
            } else {
                System.out.println(board.moveNumber + ". Move: " + currentPlayer);
                while (true) {
                    String userInput = scanner.nextLine();
                    try {
                        int position = Integer.parseInt(userInput);
                        if (board.placeMark(position, currentPlayer)) {
                            board.printBoard();
                            if (board.checkWin()) {
                                System.out.println("Winner: " + currentPlayer);
                                gameEnded = true;
                            } else if (board.isFull()) {
                                System.out.println("No Winner");
                                gameEnded = true;
                            }
                            currentPlayer = (currentPlayer.equals("x")) ? "o" : "x";
                            break;
                        } else {
                            System.out.println("Invalid move, try again.");
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid input, please enter an integer.");
                    }
                }
            }
        }
        scanner.close();
    }
}

class GameBoard {
    String[] board = new String[9];
    int moveNumber = 1;

    public GameBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = "-";
        }
    }

    public boolean placeMark(int index, String mark) {
        if (index >= 0 && index < board.length && board[index].equals("-")) {
            board[index] = mark;
            moveNumber++;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 0; i < 8; i += 3) {
            if (!board[i].equals("-") && board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!board[i].equals("-") && board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])) {
                return true;
            }
        }
        if (!board[0].equals("-") && board[0].equals(board[4]) && board[0].equals(board[8])) {
            return true;
        }
        if (!board[2].equals("-") && board[2].equals(board[4]) && board[2].equals(board[6])) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (String s : board) {
            if (s.equals("-")) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i += 3) {
            System.out.println(board[i] + board[i + 1] + board[i + 2]);
        }
    }
}

class AIPlayer {
    public int decideMove(GameBoard board) {
        // This is a simplified version. You should implement checking for win conditions,
        // blocking the opponent from winning, and prioritizing center and corners.
        for (int i = 0; i < board.board.length; i++) {
            if (board.board[i].equals("-")) {
                return i; // Naively return the first free position. 
            }
        }
        return -1; // Should never happen if used correctly.
    }
}