import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        GameBoard gameBoard = new GameBoard();
        ComputerOpponent computerOpponent = new ComputerOpponent();

        char currentPlayer = 'x';
        int moveCount = 0;
        gameBoard.printBoard();

        while (true) {
            if (playWithComputer && currentPlayer == 'o') {
                // Computer's move
                int computerMove = computerOpponent.decideMove(gameBoard, 'o');
                System.out.println((moveCount + 1) + ". Move: o");
                gameBoard.placeMark(computerMove, currentPlayer);
            } else {
                // Player's move
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                while (true) {
                    int playerMove = Integer.parseInt(scanner.nextLine());
                    if (gameBoard.isFree(playerMove)) {
                        gameBoard.placeMark(playerMove, currentPlayer);
                        break;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                }
            }
            gameBoard.printBoard();
            moveCount++;

            // Check for win or draw
            if (gameBoard.checkWin()) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (gameBoard.isFull()) {
                System.out.println("No Winner");
                break;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        scanner.close();
    }
}

class GameBoard {
    private char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};

    public boolean isFree(int index) {
        return board[index / 3][index % 3] == '-';
    }

    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        return false;
    }

    public void placeMark(int index, char mark) {
        board[index / 3][index % 3] = mark;
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}

class ComputerOpponent {
    public int decideMove(GameBoard gameBoard, char mark) {
        // Implement rules here matching the task description
        // Placeholder implementation for the rules
        // This should be replaced with the specific logic to follow the rules specified in the task
        for (int i = 0; i < 9; i++) {
            if (gameBoard.isFree(i)) {
                return i; // Placeholder: Return the first free cell
            }
        }
        return -1; // Should never reach here if called correctly
    }
}