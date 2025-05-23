import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playAgainstAI = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playAgainstAI);
        game.start();
    }
}

class Game {
    private final Board board = new Board();
    private final boolean playAgainstAI;
    private final AIPlayer aiPlayer;

    public Game(boolean playAgainstAI) {
        this.playAgainstAI = playAgainstAI;
        this.aiPlayer = new AIPlayer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int turn = 0;
        boolean gameEnded = false;

        System.out.println(board);

        while (!gameEnded) {
            char currentPlayerMark = turn % 2 == 0 ? 'x' : 'o';
            boolean validMove = false;
            int move = -1;

            while (!validMove) {
                if (currentPlayerMark == 'o' && playAgainstAI) {
                    move = aiPlayer.decideMove(board);
                    System.out.println((turn + 1) + ". Move: " + currentPlayerMark + " > " + move);
                    validMove = true;
                } else {
                    System.out.println((turn + 1) + ". Move: " + currentPlayerMark);
                    String input = scanner.nextLine();
                    try {
                        move = Integer.parseInt(input);
                        validMove = board.isFieldAvailable(move);
                        if (!validMove) {
                            System.out.println("Invalid move, try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please enter a number between 0 and 8.");
                    }
                }
            }

            board.placeMark(move, currentPlayerMark);
            System.out.println(board);
            turn++;

            if (board.hasWon(currentPlayerMark)) {
                System.out.println("Winner: " + currentPlayerMark);
                gameEnded = true;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                gameEnded = true;
            }
        }
        scanner.close();
    }
}

class Board {
    private final char[] fields = new char[9];
    private final char defaultChar = '-';

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = defaultChar;
        }
    }

    public boolean isFieldAvailable(int index) {
        return index >= 0 && index < fields.length && fields[index] == defaultChar;
    }

    public void placeMark(int index, char mark) {
        if (isFieldAvailable(index)) {
            fields[index] = mark;
        }
    }

    public boolean hasWon(char mark) {
        int[][] winConditions = new int[][]{
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}  // diagonals
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
            if (field == defaultChar) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
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

class AIPlayer {
    // Applied strategy: win, block, center, corners, random
    private final int[] preferredMoves = {4, 0, 2, 6, 8, 1, 3, 5, 7}; // center, corners, sides

    public int decideMove(Board board) {
        // Win or block check
        for (int i = 0; i < 9; i++) {
            if (board.isFieldAvailable(i)) {
                // Check for win
                board.placeMark(i, 'o');
                if (board.hasWon('o')) {
                    board.placeMark(i, '-'); // Undo move
                    return i;
                }
                board.placeMark(i, '-'); // Undo move

                // Check for block
                board.placeMark(i, 'x');
                if (board.hasWon('x')) {
                    board.placeMark(i, '-'); // Undo move
                    return i;
                }
                board.placeMark(i, '-'); // Undo move
            }
        }

        // Preferred moves
        for (int move : preferredMoves) {
            if (board.isFieldAvailable(move)) {
                return move;
            }
        }

        // Should never reach here
        return -1;
    }
}