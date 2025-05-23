import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.startGame(scanner, args.length > 0 && args[0].equals("ki"));
        scanner.close();
    }
    
    static class Game {
        private Board board;
        private ComputerOpponent computerOpponent;
        private boolean versusComputer;

        public Game() {
            this.board = new Board();
            this.computerOpponent = new ComputerOpponent();
        }

        public void startGame(Scanner scanner, boolean versusComputer) {
            this.versusComputer = versusComputer;
            char currentPlayer = 'x';
            while (true) {
                System.out.println(board);
                if (versusComputer && currentPlayer == 'o') {
                    int move = computerOpponent.decideMove(board, 'o');
                    board.placeMark(move, 'o');
                    System.out.println("Computer placed 'o' at " + move);
                } else {
                    boolean validMoveMade = false;
                    while (!validMoveMade) {
                        System.out.println(currentPlayer + "'s turn. Enter a move (0-8):");
                        int move = scanner.nextInt();
                        validMoveMade = board.placeMark(move, currentPlayer);
                        if (!validMoveMade) {
                            System.out.println("This cell is occupied or the input was invalid. Try again.");
                        }
                    }
                }
                if (board.checkWin(currentPlayer)) {
                    System.out.println(board);
                    System.out.println("Winner: " + currentPlayer);
                    break;
                } else if (board.isFull()) {
                    System.out.println(board);
                    System.out.println("No winner.");
                    break;
                }
                currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
            }
        }
    }

    static class Board {
        private char[][] fields;

        public Board() {
            this.fields = new char[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    fields[row][col] = '-';
                }
            }
        }

        public boolean placeMark(int index, char player) {
            int row = index / 3;
            int col = index % 3;
            if (fields[row][col] == '-') {
                fields[row][col] = player;
                return true;
            }
            return false;
        }

        public boolean checkWin(char player) {
            for (int i = 0; i < 3; i++) {
                if ((fields[i][0] == player && fields[i][1] == player && fields[i][2] == player) ||
                    (fields[0][i] == player && fields[1][i] == player && fields[2][i] == player))
                    return true;
            }
            return (fields[0][0] == player && fields[1][1] == player && fields[2][2] == player) ||
                   (fields[0][2] == player && fields[1][1] == player && fields[2][0] == player);
        }

        public boolean isFull() {
            for (char[] row : fields) {
                for (char cell : row) {
                    if (cell == '-') {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (char[] row : fields) {
                for (char cell : row) {
                    sb.append(cell);
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    static class ComputerOpponent {
        public int decideMove(Board board, char player) {
            // Implement decision logic as per assignment hints.
            // For simplicity, just return first free slot.
            // Your task to implement win check, block opponent, etc.
            for (int i = 0; i < 9; i++) {
                if (board.placeMark(i, player)) {
                    board.placeMark(i, '-'); // Undo move.
                    return i;
                }
            }
            return 0; // Fallback.
        }
    }
}