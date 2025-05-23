import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        PlayerInput playerInput = new PlayerInput();
        ComputerOpponent computerOpponent = new ComputerOpponent();

        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        char currentPlayer = 'x';
        
        while (true) {
            System.out.println(board);
            int position;
            if (playWithComputer && currentPlayer == 'o') {
                position = computerOpponent.decideMove(board, 'o');
                System.out.println("Computer (o) chooses: " + position);
            } else {
                position = playerInput.getNextMove(currentPlayer);
            }

            board.placeMark(position, currentPlayer);
            
            if (board.checkWin(currentPlayer)) {
                System.out.println("Winner: " + currentPlayer);
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }
            
            currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
        }

        playerInput.closeScanner();
    }
}

class GameBoard {
    private final char[] fields = new char[9];
    private final int[][] winConditions = {
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
        {0, 4, 8}, {2, 4, 6}             // diagonals
    };

    public GameBoard() {
        for (int i = 0; i < fields.length; i++) {
            fields[i] = '-';
        }
    }

    public boolean placeMark(int index, char mark) {
        if (index >= 0 && index < fields.length && fields[index] == '-') {
            fields[index] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin(char mark) {
        for (int[] condition : winConditions) {
            if (fields[condition[0]] == mark && fields[condition[1]] == mark && fields[condition[2]] == mark) {
                return true;
            }
        }
        return false;
    }

    public boolean isFree(int index) {
        return fields[index] == '-';
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
            if (i % 3 == 0 && i != 0) {
                sb.append("\n");
            }
            sb.append(fields[i]);
        }
        return sb.toString();
    }
}

class PlayerInput {
    private final Scanner scanner = new Scanner(System.in);

    public int getNextMove(char player) {
        System.out.println(player + "'s turn. Enter position (0-8): ");
        while (true) {
            try {
                int position = Integer.parseInt(scanner.nextLine());
                if (position >= 0 && position <= 8) {
                    return position;
                } else {
                    System.out.println("Please enter a number between 0-8.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}

class ComputerOpponent {
    public int decideMove(GameBoard board, char player) {
        for (int i = 0; i < 9; i++) {
            if (board.isFree(i)) {
                return i; // Placeholder for logic, always chooses the first free position
            }
        }
        return -1; // In case no position is free (should not happen)
    }
}