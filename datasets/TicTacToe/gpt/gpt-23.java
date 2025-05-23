import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        boolean isComputerOpponent = args.length == 1 && args[0].equalsIgnoreCase("ki");
        Board board = new Board();
        IOHandler ioHandler = new IOHandler();
        ComputerPlayer computerPlayer = new ComputerPlayer();

        char currentPlayer = 'x';
        boolean gameEnded = false;

        ioHandler.printBoard(board);

        while (!gameEnded) {
            boolean moveMade = false;
            while (!moveMade) {
                int move;
                if (isComputerOpponent && currentPlayer == 'o') {
                    move = computerPlayer.decideMove(board);
                    ioHandler.printComputerMove(currentPlayer, move);
                } else {
                    move = ioHandler.getPlayerMove(currentPlayer);
                }

                moveMade = board.placeMark(move, currentPlayer);
                if (moveMade) {
                    ioHandler.printBoard(board);
                    gameEnded = board.checkWin() || board.checkDraw();
                    currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
                }
            }
        }

        if (board.checkWin()) {
            ioHandler.printWinner((currentPlayer == 'x') ? 'o' : 'x');
        } else if (board.checkDraw()) {
            ioHandler.printDraw();
        }
    }
}

class Board {

    private final char[] fields = new char[9];
    private final int[][] winConditions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                                           {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                                           {0, 4, 8}, {2, 4, 6}};

    public Board() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean checkWin() {
        for (int[] winCondition : winConditions) {
            if (fields[winCondition[0]] == fields[winCondition[1]] &&
                fields[winCondition[1]] == fields[winCondition[2]] &&
                fields[winCondition[0]] != '-') {
                return true;
            }
        }
        return false;
    }

    public boolean checkDraw() {
        for (char field : fields) {
            if (field == '-') {
                return false;
            }
        }
        return true;
    }

    public boolean placeMark(int position, char player) {
        if (position >= 0 && position < 9 && fields[position] == '-') {
            fields[position] = player;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            board.append(fields[i]);
            if (i % 3 == 2 && i != 8) {
                board.append("\n");
            }
        }
        return board.toString();
    }

    public boolean isFieldFree(int position) {
        return position >= 0 && position < 9 && fields[position] == '-';
    }

    public char[] getFields() {
        return fields.clone();
    }
}

class IOHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void printBoard(Board board) {
        System.out.println(board);
    }

    public int getPlayerMove(char player) {
        System.out.println("Move: " + player);
        while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.println("Invalid input. Please enter a number between 0 and 8.");
        }
        return scanner.nextInt();
    }

    public void printWinner(char player) {
        System.out.println("Winner: " + player);
    }

    public void printDraw() {
        System.out.println("No Winner");
    }

    public void printComputerMove(char player, int move) {
        System.out.println(player + " chooses position " + move);
    }
}

class ComputerPlayer {
    
    public int decideMove(Board board) {
        // Insert logic as described for the computer's move decision
        // This is a placeholder for the comprehensive logic based on the guidelines
        for (int i = 0; i < 9; i++) {
            if (board.isFieldFree(i)) {
                return i; // Placeholder decision
            }
        }
        return -1; // Fallback, should never happen
    }
}