import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Game game = new Game(playWithComputer);
        game.startGame();
    }
}

class Game {
    private final Board board;
    private final Scanner scanner;
    private final boolean playWithComputer;
    private final ComputerPlayer computerPlayer;

    public Game(boolean playWithComputer) {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
        this.playWithComputer = playWithComputer;
        this.computerPlayer = new ComputerPlayer();
    }

    public void startGame() {
        char currentPlayer = 'x';
        int moveCount = 0;
        boolean gameOver = false;

        System.out.println(board);

        while (!gameOver) {
            if (playWithComputer && currentPlayer == 'o') {
                int computerMove = computerPlayer.decideNextMove(board, 'o');
                board.placeMark(computerMove, currentPlayer);
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                System.out.println(board);
                currentPlayer = switchPlayer(currentPlayer);
                moveCount++;
            } else {
                System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
                int move = getPlayerMove(currentPlayer);
                board.placeMark(move, currentPlayer);
                System.out.println(board);
                currentPlayer = switchPlayer(currentPlayer);
                moveCount++;
            }

            if (board.hasWinner()) {
                gameOver = true;
                System.out.println("Winner: " + switchPlayer(currentPlayer));
            } else if (moveCount == 9) {
                gameOver = true;
                System.out.println("No Winner");
            }
        }
        scanner.close();
    }

    private int getPlayerMove(char player) {
        while (true) {
            try {
                int move = Integer.parseInt(scanner.nextLine());
                if (move >= 0 && move < 9 && board.isFieldFree(move)) {
                    return move;
                } else {
                    System.out.println("Invalid input. Please try again:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            }
        }
    }

    private char switchPlayer(char currentPlayer) {
        return (currentPlayer == 'x') ? 'o' : 'x';
    }
}

class Board {
    private final char[] fields;
    private final int[][] winningCombinations = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}  // diagonals
    };

    public Board() {
        fields = new char[9];
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean isFieldFree(int index) {
        return fields[index] == '-';
    }

    public void placeMark(int index, char player) {
        if (isFieldFree(index)) {
            fields[index] = player;
        }
    }

    public boolean hasWinner() {
        for (int[] combination : winningCombinations) {
            if (fields[combination[0]] != '-' && fields[combination[0]] == fields[combination[1]] && fields[combination[1]] == fields[combination[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        for (char field : fields) {
            if (field == '-') {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if ((i + 1) % 3 == 0 && i != 8) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class ComputerPlayer {
    public int decideNextMove(Board board, char player) {
        // Implementation based on specified rules
        // Placeholder for actual logic
        return 0; // This method should be implemented based on game rules.
    }
}