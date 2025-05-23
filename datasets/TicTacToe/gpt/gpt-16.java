import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        Game game = new Game(playWithComputer);
        game.start();
    }
}

class Game {
    private final Board board;
    private final Scanner scanner;
    private final boolean playWithComputer;
    private final ComputerOpponent computerOpponent;

    public Game(boolean playWithComputer) {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.playWithComputer = playWithComputer;
        this.computerOpponent = playWithComputer ? new ComputerOpponent() : null;
    }

    public void start() {
        int moveCount = 0;
        char currentPlayer = 'x';
        board.printBoard();
        
        while (true) {
            if (playWithComputer && currentPlayer == 'o') {
                int computerMove = computerOpponent.decideMove(board, currentPlayer);
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                board.placeMark(computerMove, currentPlayer);
                board.printBoard();
                if (board.checkForWin()) {
                    System.out.println("Winner: " + currentPlayer);
                    break;
                }
                if (board.isFull()) {
                    System.out.println("No Winner");
                    break;
                }
                currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
            } else {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                boolean validMove = false;
                while (!validMove) {
                    try {
                        int move = Integer.parseInt(scanner.nextLine());
                        if (board.placeMark(move, currentPlayer)) {
                            validMove = true;
                            board.printBoard();
                            if (board.checkForWin()) {
                                System.out.println("Winner: " + currentPlayer);
                                return;
                            }
                            if (board.isFull()) {
                                System.out.println("No Winner");
                                return;
                            }
                            currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
                        } else {
                            System.out.println("Invalid move, try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            }
            moveCount++;
        }
        scanner.close();
    }
}

class Board {
    private final char[] fields = new char[9];
    private final char emptyField = '-';

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = emptyField;
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length && fields[index] == emptyField) {
            fields[index] = mark;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < fields.length; i += 3) {
            System.out.println(fields[i] + "" + fields[i + 1] + "" + fields[i + 2]);
        }
    }

    public boolean checkForWin() {
        for (int i = 0; i < 8; i++) {
            String line = null;
            switch (i) {
                case 0:
                    line = "" + fields[0] + fields[1] + fields[2];
                    break;
                case 1:
                    line = "" + fields[3] + fields[4] + fields[5];
                    break;
                case 2:
                    line = "" + fields[6] + fields[7] + fields[8];
                    break;
                case 3:
                    line = "" + fields[0] + fields[3] + fields[6];
                    break;
                case 4:
                    line = "" + fields[1] + fields[4] + fields[7];
                    break;
                case 5:
                    line = "" + fields[2] + fields[5] + fields[8];
                    break;
                case 6:
                    line = "" + fields[0] + fields[4] + fields[8];
                    break;
                case 7:
                    line = "" + fields[2] + fields[4] + fields[6];
                    break;
            }
            if (line.equals("xxx") || line.equals("ooo")) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == emptyField) {
                return false;
            }
        }
        return true;
    }
}

class ComputerOpponent {
    public int decideMove(Board board, char player) {
        // Computer opponent logic to decide next move
        // Placeholder implementation. Real implementation goes here.
        // This is a simplified placeholder to show structure,
        // real AI or decision logic to follow specifications needed.

        // Prioritize winning moves, blocking, or picking strategic positions based on game specs.
        // For demonstration, simply returns 0-8 (the first valid move).
        for (int i = 0; i < 9; i++) {
            if (board.placeMark(i, player)) {
                board.placeMark(i, '-'); // Undo this trial placement.
                return i;
            }
        }
        return -1; // Should never happen if called correctly.
    }
}