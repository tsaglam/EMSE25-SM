import java.util.Scanner;

class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean againstAI = args.length == 1 && args[0].equals("ki");
        GameBoard board = new GameBoard();
        Player currentPlayer = Player.X;
        AIComputer ai = new AIComputer();

        System.out.println(board);

        while (true) {
            if (againstAI && currentPlayer == Player.O) {
                int move = ai.decideMove(board);
                board.makeMove(move, currentPlayer);
                System.out.println(currentPlayer + "'s move: " + move);
            } else {
                System.out.println(board.getMoveNumber() + ". Move: " + currentPlayer);
                while (true) {
                    int move;
                    try {
                        move = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        continue;
                    }

                    if (board.isMoveValid(move)) {
                        board.makeMove(move, currentPlayer);
                        break;
                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                }
            }

            System.out.println(board);
            if (board.hasWinner()) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
        }
        scanner.close();
    }
}

enum Player {
    X, O
}

class GameBoard {
    private final Player[] fields = new Player[9];
    private int moveNumber = 1;

    public boolean isMoveValid(int index) {
        return index >= 0 && index < fields.length && fields[index] == null;
    }

    public void makeMove(int index, Player player) {
        if (isMoveValid(index)) {
            fields[index] = player;
            moveNumber++;
        }
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (fields[i] != null && fields[i] == fields[i + 3] && fields[i] == fields[i + 6]) return true;
            int row = i * 3;
            if (fields[row] != null && fields[row] == fields[row + 1] && fields[row] == fields[row + 2]) return true;
        }
        if (fields[0] != null && fields[0] == fields[4] && fields[0] == fields[8]) return true;
        if (fields[2] != null && fields[2] == fields[4] && fields[2] == fields[6]) return true;
        return false;
    }

    public boolean isFull() {
        for (Player field : fields) {
            if (field == null) return false;
        }
        return true;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null) {
                builder.append("-");
            } else {
                builder.append(fields[i].toString().toLowerCase());
            }
            if ((i + 1) % 3 == 0) builder.append("\n");
        }
        return builder.toString();
    }
}

class AIComputer {
    public int decideMove(GameBoard board) {
        // Simplified decision-making for the sake of example
        // Here you should implement the logic to decide the next move based on the current state of the board
        // For simplicity, this will just select the first empty field (this should be replaced with your own logic)
        for (int i = 0; i < 9; i++) {
            if (board.isMoveValid(i)) {
                return i;
            }
        }
        return -1; // Should never happen if called correctly
    }
}