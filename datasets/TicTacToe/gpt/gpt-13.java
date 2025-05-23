import java.util.Scanner;

class TicTacToe {
    private final char[] board;
    private final char player1 = 'x';
    private final char player2 = 'o';
    private boolean isPlayer1Turn;
    private static Scanner scanner;

    TicTacToe() {
        this.board = new char[9];
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = '-';
        }
        this.isPlayer1Turn = true;
    }

    public boolean move(int index, char player) {
        if (index < 0 || index >= this.board.length || this.board[index] != '-') {
            return false;
        }
        this.board[index] = player;
        return true;
    }

    public boolean isFull() {
        for (char cell : this.board) {
            if (cell == '-') {
                return false;
            }
        }
        return true;
    }

    public boolean hasWon(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i * 3] == player && board[i * 3 + 1] == player && board[i * 3 + 2] == player) ||
                (board[i] == player && board[i + 3] == player && board[i + 6] == player)) {
                return true;
            }
        }
        return (board[0] == player && board[4] == player && board[8] == player) ||
               (board[2] == player && board[4] == player && board[6] == player);
    }

    public int findWinningMove(char player) {
        for (int i = 0; i < this.board.length; i++) {
            if (board[i] == '-') {
                board[i] = player;
                boolean wins = hasWon(player);
                board[i] = '-'; // Undo the move
                if (wins) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int findBlockingMove(char player) {
        char opponent = (player == this.player1) ? this.player2 : this.player1;
        return findWinningMove(opponent);
    }

    public int findCenterMove() {
        return (board[4] == '-') ? 4 : -1;
    }

    public int findCornerMove() {
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (board[corner] == '-') {
                return corner;
            }
        }
        return -1;
    }

    public int findAnyMove() {
        for (int i = 0; i < this.board.length; i++) {
            if (board[i] == '-') {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.board.length; i++) {
            s.append(this.board[i]);
            if ((i + 1) % 3 == 0 && i + 1 != this.board.length) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        scanner = new Scanner(System.in);
        boolean againstComputer = args.length == 1 && args[0].equals("ki");
        ComputerOpponent computerOpponent = new ComputerOpponent(game);

        System.out.println(game.toString());
        int moveCount = 0;

        while (true) {
            char currentPlayer = game.isPlayer1Turn ? game.player1 : game.player2;
            System.out.println((moveCount + 1) + ". Move: " + currentPlayer);
            int moveIndex = -1;

            if (game.isPlayer1Turn || !againstComputer) {
                while (moveIndex == -1) {
                    String input = scanner.nextLine();
                    try {
                        moveIndex = Integer.parseInt(input);
                        if (!game.move(moveIndex, currentPlayer)) {
                            System.out.println("Invalid move, please try again.");
                            moveIndex = -1;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }
            } else {
                moveIndex = computerOpponent.makeMove(currentPlayer);
                game.move(moveIndex, currentPlayer);
            }

            System.out.println(game.toString());

            if (game.hasWon(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (game.isFull()) {
                System.out.println("No Winner");
                break;
            }

            game.isPlayer1Turn = !game.isPlayer1Turn;
            moveCount++;
        }
        scanner.close();
    }
}

class ComputerOpponent {
    private final TicTacToe game;

    ComputerOpponent(TicTacToe game) {
        this.game = game;
    }

    public int makeMove(char player) {
        int move = game.findWinningMove(player);
        if (move != -1) return move;

        move = game.findBlockingMove(player);
        if (move != -1) return move;

        move = game.findCenterMove();
        if (move != -1) return move;

        move = game.findCornerMove();
        if (move != -1) return move;

        return game.findAnyMove();
    }
}