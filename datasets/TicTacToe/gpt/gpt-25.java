import java.util.Scanner;

class TicTacToeGame {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        IOManager ioManager = new IOManager(playWithComputer ? new ComputerPlayer() : null);
        
        ticTacToe.playGame(ioManager);
    }
}

class TicTacToe {
    private Board board;
    
    public TicTacToe() {
        this.board = new Board();
    }
    
    public void playGame(IOManager ioManager) {
        char currentPlayer = 'x';
        int moveCount = 1;

        while (true) {
            ioManager.outputBoard(board.toString());
            int index = ioManager.getPlayerMove(currentPlayer, board);
            board.placeMark(index, currentPlayer);
            if (board.checkWin(currentPlayer)) {
                ioManager.outputWin(currentPlayer);
                break;
            }
            if (moveCount++ == 9) {
                ioManager.outputDraw();
                break;
            }            
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }
    }
}

class Board {
    private char[] fields;
    
    public Board() {
        this.fields = new char[9];
        for (int i = 0; i < 9; i++) {
            fields[i] = '-';
        }
    }
    
    public boolean isFree(int index) {
        return fields[index] == '-';
    }
    
    public boolean checkWin(char player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
            if (player == fields[condition[0]] && player == fields[condition[1]] && player == fields[condition[2]]) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (fields[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public void placeMark(int index, char player) {
        if (index >= 0 && index < 9) {
            fields[index] = player;
        }
    }

    public int calculateWinningMove(char player) {
        for (int i = 0; i < 9; i++) {
            if (isFree(i)) {
                fields[i] = player;
                boolean wins = checkWin(player);
                fields[i] = '-';
                if (wins) return i;
            }
        }
        return -1;
    }
    
    public int calculateBlockingMove(char player) {
        char opponent = (player == 'x') ? 'o' : 'x';
        return calculateWinningMove(opponent);
    }
    
    public int findFreeCorner() {
        int[] corners = {0, 2, 6, 8};
        for (int corner : corners) {
            if (isFree(corner)) {
                return corner;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if (i % 3 == 2 && i != 8) sb.append("\n");
        }
        return sb.toString();
    }
}

class IOManager {
    private Scanner scanner;
    private ComputerPlayer computerPlayer;

    public IOManager(ComputerPlayer computerPlayer) {
        this.scanner = new Scanner(System.in);
        this.computerPlayer = computerPlayer;
    }

    public void outputBoard(String board) {
        System.out.println(board);
    }

    public int getPlayerMove(char player, Board board) {
        if (computerPlayer != null && player == 'o') {
            return computerPlayer.decideMove(board, player);
        }

        int move;
        while (true) {
            System.out.println("Move: " + player);
            try {
                move = Integer.parseInt(scanner.nextLine());
                if (move >= 0 && move < 9 && board.isFree(move)) {
                    return move;
                }
            } catch (NumberFormatException e) {
                // Invalid input, prompt again
            }
            System.out.println("Invalid move. Try again.");
        }
    }

    public void outputWin(char player) {
        System.out.println("Winner: " + player);
    }

    public void outputDraw() {
        System.out.println("No Winner");
    }

    public void close() {
        scanner.close();
    }
}

class ComputerPlayer {

    public int decideMove(Board board, char player) {
        int move = board.calculateWinningMove(player);
        if (move != -1) return move;

        move = board.calculateBlockingMove(player);
        if (move != -1) return move;

        if (board.isFree(4)) return 4;

        move = board.findFreeCorner();
        if (move != -1) return move;

        // Fallback to any free space
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) return i;
        }
        return -1; // Should never reach here.
    }
}