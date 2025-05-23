import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game(args.length == 1 && args[0].equals("ki"));
        game.start();
    }
}

class Game {
    private final Board board = new Board();
    private final IO io = new IO();
    private final boolean againstComputer;
    private final ComputerOpponent computer = new ComputerOpponent();

    public Game(boolean againstComputer) {
        this.againstComputer = againstComputer;
    }

    public void start() {
        char currentPlayer = 'x';
        int moveCount = 0;
        while (true) {
            board.display();
            boolean moveMade = false;
            while (!moveMade) {
                int position;
                if (againstComputer && currentPlayer == 'o') {
                    position = computer.decideMove(board);
                    io.displayComputerMove(currentPlayer, position);
                } else {
                    position = io.getPlayerMove(currentPlayer);
                }
                moveMade = board.placeMark(position, currentPlayer);
                if (!moveMade) {
                    io.displayInvalidMove();
                }
            }
            moveCount++;
            if (board.checkWin()) {
                board.display();
                io.displayWinner(currentPlayer);
                break;
            } else if (moveCount == 9) {
                board.display();
                io.displayDraw();
                break;
            }
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
        io.closeScanner();
    }
}

class IO {
    private final Scanner scanner = new Scanner(System.in);

    public int getPlayerMove(char player) {
        System.out.println("Move for player: " + player);
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the invalid input
            System.out.println("Invalid input. Please enter a number between 0 and 8.");
        }
        return scanner.nextInt();
    }

    public void displayInvalidMove() {
        System.out.println("Invalid move. Try again.");
    }

    public void displayWinner(char winner) {
        System.out.println("Winner: " + winner);
    }

    public void displayDraw() {
        System.out.println("No Winner");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayComputerMove(char player, int position) {
        System.out.println("Move for " + player + " by computer at position: " + position);
    }
}

class Board {
    private final char[] fields = new char[9];
    private final char empty = '-';

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = empty;
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length && fields[index] == empty) {
            fields[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 0; i < 8; i += 3) // Rows
            if (checkLine(i, i + 1, i + 2)) return true;
        for (int i = 0; i < 3; i++) // Columns
            if (checkLine(i, i + 3, i + 6)) return true;
        // Diagonals
        return checkLine(0, 4, 8) || checkLine(2, 4, 6);
    }

    private boolean checkLine(int a, int b, int c) {
        return fields[a] != empty && fields[a] == fields[b] && fields[b] == fields[c];
    }

    public void display() {
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i]);
            if ((i + 1) % 3 == 0) System.out.println();
        }
    }
}

class ComputerOpponent {

    public int decideMove(Board board) {
        // Your implementation for deciding the computer's move goes here
        // You can make use of the board's state and methods like board.isFieldFree(int)
        // and other logic based on the rules described for the computer's strategy
        // For simplicity, this will just choose the first free spot
        for (int i = 0; i < 9; i++) {
            // Placeholder logic: choose the first free field
            // You should replace this with logic according to the game rules
            if (board.placeMark(i, 'o')) {
                board.placeMark(i, '-'); // Undo the move for real checking
                return i;
            }
        }
        return -1; // Should never get here if the game logic is correct
    }
}