import java.util.*;

class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playWithAI = args.length == 1 && args[0].equals("ki");
        GameBoard board = new GameBoard();
        InputOutput io = new InputOutput(scanner);
        ComputerOpponent ai = playWithAI ? new ComputerOpponent() : null;

        char currentPlayer = 'x';
        boolean isGameOver = false;
        int moveCount = 0;

        while (!isGameOver && moveCount < 9) {
            if (playWithAI && currentPlayer == 'o') {
                int move = ai.decideNextMove(board, currentPlayer);
                board.placeMark(move, currentPlayer);
                io.outputBoard(board.boardToString());
                if (board.checkWin(currentPlayer)) {
                    isGameOver = true;
                    io.outputWinner(currentPlayer);
                }
                currentPlayer = switchPlayer(currentPlayer);
            } else {
                io.outputMovePrompt(moveCount + 1, currentPlayer);
                boolean validMove = false;
                int move = -1;
                while (!validMove) {
                    move = io.readMove();
                    if (board.isFieldFree(move)) {
                        validMove = true;
                    } else {
                        io.outputInvalidMove();
                    }
                }
                board.placeMark(move, currentPlayer);
                io.outputBoard(board.boardToString());
                if (board.checkWin(currentPlayer)) {
                    isGameOver = true;
                    io.outputWinner(currentPlayer);
                }
                currentPlayer = switchPlayer(currentPlayer);
            }
            moveCount++;
        }

        if (!isGameOver) {
            io.outputNoWinner();
        }

        scanner.close();
    }

    private static char switchPlayer(char currentPlayer) {
        return currentPlayer == 'x' ? 'o' : 'x';
    }

    static class GameBoard {
        private final char[] fields;

        public GameBoard() {
            fields = new char[9];
            Arrays.fill(fields, '-');
        }

        public boolean isFieldFree(int index) {
            return fields[index] == '-';
        }

        public void placeMark(int index, char mark) {
            fields[index] = mark;
        }

        public String boardToString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i += 3) {
                sb.append(fields, i, 3).append("\n");
            }
            return sb.toString();
        }

        public boolean checkWin(char player) {
            int[][] winPositions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6}              // diagonals
            };
            for (int[] winPos : winPositions) {
                if (player == fields[winPos[0]] && player == fields[winPos[1]] && player == fields[winPos[2]]) {
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

        public int findWinningMove(char player) {
            // Implement the check for a winning move for player
            // This is an extension task; you may add logic similar to checkWin but for potential win scenarios
            return -1; // Placeholder: Logic for finding winning move
        }
    }

    static class InputOutput {
        private final Scanner scanner;

        public InputOutput(Scanner scanner) {
            this.scanner = scanner;
        }

        public void outputMovePrompt(int moveNumber, char player) {
            System.out.println(moveNumber + ". Move: " + player);
        }

        public int readMove() {
            return Integer.parseInt(scanner.nextLine());
        }

        public void outputInvalidMove() {
            System.out.println("Invalid move, try again.");
        }

        public void outputBoard(String board) {
            System.out.println(board);
        }

        public void outputWinner(char player) {
            System.out.println("Winner: " + player);
        }

        public void outputNoWinner() {
            System.out.println("No Winner");
        }
    }

    static class ComputerOpponent {

        public int decideNextMove(GameBoard board, char player) {
            char opponent = player == 'x' ? 'o' : 'x';
            // Implement AI logic based on the rules specified
            // 1. Win
            // 2. Block
            // 3. Center
            // 4. Corner
            // 5. Any
            return findBestMove(board, player, opponent); // Placeholder for AI decision making
        }

        private int findBestMove(GameBoard board, char player, char opponent) {
            // To be implemented: AI decision logic
            return 0; // Placeholder
        }
    }
}