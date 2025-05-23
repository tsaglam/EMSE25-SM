import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean againstAI = args.length == 1 && args[0].equals("ki");
        TicTacToeGame game = new TicTacToeGame(againstAI);
        game.play();
    }
}

class TicTacToeGame {
    private final Board board;
    private final IO io;
    private final boolean againstAI;
    private final ComputerOpponent computerOpponent;

    public TicTacToeGame(boolean againstAI) {
        this.board = new Board();
        this.io = new IO();
        this.againstAI = againstAI;
        this.computerOpponent = new ComputerOpponent();
    }

    public void play() {
        char currentPlayer = 'x';
        int moves = 0;
        while (true) {
            if (againstAI && currentPlayer == 'o') {
                int computerMove = computerOpponent.decideMove(board, 'o');
                board.placeMark(computerMove, 'o');
                io.printBoard(board.getBoardRepresentation());
                if (board.checkWin('o')) {
                    io.printWin('o');
                    break;
                }
                currentPlayer = 'x';
            } else {
                io.printMovePrompt(moves + 1, currentPlayer);
                int move = io.getPlayerMove(board);
                board.placeMark(move, currentPlayer);
                io.printBoard(board.getBoardRepresentation());
                if (board.checkWin(currentPlayer)) {
                    io.printWin(currentPlayer);
                    break;
                }
                currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            }
            if (board.isFull()) {
                io.printNoWinner();
                break;
            }
            moves++;
        }
        io.closeScanner();
    }
}

class Board {
    private final char[] fields = new char[9];
    private static final char FREE = '-';

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = FREE;
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == FREE;
    }

    public boolean checkWin(char mark) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };
        for (int[] condition : winConditions) {
            if (fields[condition[0]] == mark && fields[condition[1]] == mark && fields[condition[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == FREE) {
                return false;
            }
        }
        return true;
    }

    public void placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length && isFieldFree(index)) {
            fields[index] = mark;
        }
    }

    public String getBoardRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(fields[i]);
            if (i % 3 == 2 && i != fields.length - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }
}

class IO {
    private final Scanner scanner;

    public IO() {
        scanner = new Scanner(System.in);
    }

    public int getPlayerMove(Board board) {
        int move;
        do {
            String input = scanner.nextLine();
            try {
                move = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                move = -1;
            }
            if (move < 0 || move > 8 || !board.isFieldFree(move)) {
                System.out.println("Invalid move. Try again.");
                move = -1;
            }
        } while (move == -1);
        return move;
    }

    public void printBoard(String representation) {
        System.out.println(representation);
    }

    public void printMovePrompt(int moveNumber, char mark) {
        System.out.println(moveNumber + ". Move: " + mark);
    }

    public void printWin(char mark) {
        System.out.println("Winner: " + mark);
    }

    public void printNoWinner() {
        System.out.println("No Winner");
    }

    public void closeScanner() {
        scanner.close();
    }
}

class ComputerOpponent {
    public int decideMove(Board board, char playerMark) {
        // Implement AI logic here following the given priority rules
        // Placeholder implementation: just finds the first free spot
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) {
                return i;
            }
        }
        return -1; // Should never happen if called correctly
    }
}