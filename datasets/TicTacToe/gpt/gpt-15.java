import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game(args.length == 1 && args[0].equals("ki"));
        game.startGame();
    }
}

class Game {
    private Board board;
    private boolean vsComputer;
    private final Scanner scanner = new Scanner(System.in);
    private ComputerOpponent computerOpponent;

    public Game(boolean vsComputer) {
        this.vsComputer = vsComputer;
        board = new Board();
        if (vsComputer) {
            computerOpponent = new ComputerOpponent();
        }
    }

    public void startGame() {
        char currentPlayer = 'x';
        int moveCount = 0;

        System.out.println(board);

        while (true) {
            if (vsComputer && currentPlayer == 'o') {
                // Computer's move
                int move = computerOpponent.decideMove(board, 'o');
                System.out.println((moveCount + 1) + ". Move: o");
                board.placeMark(move, currentPlayer);
            } else {
                // Human player's move
                while (true) {
                    System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                    int move = Integer.parseInt(scanner.nextLine());
                    if (board.isFree(move)) {
                        board.placeMark(move, currentPlayer);
                        break;
                    } else {
                        System.out.println("Invalid move, try again.");
                    }
                }
            }

            moveCount++;
            System.out.println(board);

            if (board.checkForWin(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }

            currentPlayer = currentPlayer == 'x' ? 'o' : 'x';
        }

        scanner.close();
    }
}

class Board {
    private final char[] fields = new char[9];
    private final int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFree(int index) {
        return fields[index] == '-';
    }

    public void placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length) {
            fields[index] = mark;
        }
    }

    public boolean checkForWin(char mark) {
        for (int[] condition : winConditions) {
            if (fields[condition[0]] == mark && fields[condition[1]] == mark && fields[condition[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == '-') {
                return false;
            }
        }
        return true;
    }
    
    public boolean canWinNextMove(char mark) {
        for (int i = 0; i < fields.length; i++) {
            if (isFree(i)) {
                placeMark(i, mark); // Temporarily place mark
                boolean canWin = checkForWin(mark);
                placeMark(i, '-'); // Revert back
                if (canWin) {
                    return true;
                }
            }
        }
        return false;
    }

    public int decideCriticalMove(char currentPlayer, char opponent) {
        for (int i = 0; i < 9; i++) {
            if (isFree(i)) {
                placeMark(i, currentPlayer);
                if (checkForWin(currentPlayer)) {
                    placeMark(i, '-'); // Reset after check
                    return i;
                }
                placeMark(i, '-'); // Reset after check

                placeMark(i, opponent);
                if (checkForWin(opponent)) {
                    placeMark(i, '-'); // Reset after check
                    return i;
                }
                placeMark(i, '-'); // Reset after check
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i % 3 == 2 && i < fields.length - 1) sb.append("\n");
        }
        return sb.toString();
    }
}

class ComputerOpponent {
    public int decideMove(Board board, char mark) {
        int move = board.decideCriticalMove(mark, mark == 'x' ? 'o' : 'x');
        if (move != -1) return move;

        // Center
        if (board.isFree(4)) return 4;

        // Corners
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board.isFree(corner)) return corner;
        }

        // Other fields
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) return i;
        }

        return -1; // Should never reach here
    }
}