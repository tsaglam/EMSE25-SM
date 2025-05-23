import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.play(args.length == 1 && args[0].equals("ki"));
    }
}

class Game {
    private GameBoard board = new GameBoard();
    private IOManager io = new IOManager();
    private ComputerOpponent computer = new ComputerOpponent(board);

    public void play(boolean versusComputer) {
        char currentPlayer = 'x';
        boolean isGameOver = false;
        int moveCount = 0;

        io.showBoard(board.getBoard());

        while (!isGameOver) {
            int position;
            boolean moveValid;

            do {
                if (!versusComputer || currentPlayer == 'x') {
                    io.showMovePrompt(moveCount + 1, currentPlayer);
                    position = io.getNextMove();
                } else {
                    position = computer.decideMove(currentPlayer);
                    io.showComputerMove(moveCount + 1, currentPlayer, position);
                }

                moveValid = board.isPositionAvailable(position);
                if (!moveValid) {
                    io.showInvalidMoveMessage();
                }
            } while (!moveValid);

            board.placeMark(currentPlayer, position);
            io.showBoard(board.getBoard());
            moveCount++;
            
            if (board.hasWon(currentPlayer)) {
                io.showWinner(currentPlayer);
                isGameOver = true;
            } else if (moveCount == 9) {
                io.showDraw();
                isGameOver = true;
            }

            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
    }
}

class GameBoard {
    private char[] fields = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

    public boolean isPositionAvailable(int position) {
        return position >= 0 && position < 9 && fields[position] == '-';
    }

    public void placeMark(char player, int position) {
        if (isPositionAvailable(position)) {
            fields[position] = player;
        }
    }

    public boolean hasWon(char player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condition : winConditions) {
            if (player == fields[condition[0]] && player == fields[condition[1]] && player == fields[condition[2]]) {
                return true;
            }
        }

        return false;
    }

    public String getBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            builder.append(fields[i]);
            if ((i + 1) % 3 == 0 && i != 8) builder.append("\n");
        }
        return builder.toString();
    }
}

class IOManager {
    private Scanner scanner = new Scanner(System.in);

    public void showBoard(String board) {
        System.out.println(board);
    }

    public void showMovePrompt(int moveNumber, char player) {
        System.out.println(moveNumber + ". Move: " + player);
        System.out.print("> ");
    }

    public void showComputerMove(int moveNumber, char player, int position) {
        System.out.println(moveNumber + ". Move: " + player + " (Computer chose " + position + ")");
    }

    public int getNextMove() {
        return scanner.nextInt();
    }
    
    public void showInvalidMoveMessage() {
        System.out.println("Invalid move, try again.");
    }

    public void showWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void showDraw() {
        System.out.println("No Winner");
    }
}

class ComputerOpponent {
    private GameBoard board;

    public ComputerOpponent(GameBoard board) {
        this.board = board;
    }

    public int decideMove(char player) {
        // Placeholder logic for a simple AI move decision
        // This should include the logic for deciding moves based on the game rules
        for (int i = 0; i < 9; i++) {
            if (board.isPositionAvailable(i)) {
                return i;
            }
        }
        
        return -1; // Should not reach here if the game is being played correctly
    }
}