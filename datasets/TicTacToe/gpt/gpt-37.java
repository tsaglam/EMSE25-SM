import java.util.Scanner;

class TicTacToeGame {

    public static void main(String[] args) {
        boolean playWithComputer = args.length == 1 && args[0].equals("ki");
        Board board = new Board();
        Player playerX = new Player('x');
        Player playerO = playWithComputer ? new ComputerPlayer('o') : new Player('o');
        Scanner scanner = new Scanner(System.in);

        board.printBoard();
        boolean isPlayerXTurn = true;
        int moveCount = 0;
        while (true) {
            moveCount++;
            if (isPlayerXTurn) {
                System.out.println(moveCount + ". Move: x");
                playerX.makeMove(board, scanner);
            } else {
                System.out.println(moveCount + ". Move: o");
                if (playWithComputer) {
                    ((ComputerPlayer) playerO).makeMove(board);
                } else {
                    playerO.makeMove(board, scanner);
                }
            }
            board.printBoard();
            if (board.checkWin()) {
                System.out.println("Winner: " + (isPlayerXTurn ? 'x' : 'o'));
                break;
            } else if (board.isFull()) {
                System.out.println("No Winner");
                break;
            }
            isPlayerXTurn = !isPlayerXTurn;
        }
        scanner.close();
    }
}

class Board {
    private final char[] cells = new char[9];

    public Board() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '-';
        }
    }

    public boolean isFree(int position) {
        return cells[position] == '-';
    }

    public void placeMark(int position, char mark) {
        if (isFree(position)) {
            cells[position] = mark;
        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i += 3) {
            System.out.println(cells[i] + "" + cells[i + 1] + "" + cells[i + 2]);
        }
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (cells[i * 3] != '-' && cells[i * 3] == cells[i * 3 + 1] && cells[i * 3 + 1] == cells[i * 3 + 2]
                    || cells[i] != '-' && cells[i] == cells[i + 3] && cells[i + 3] == cells[i + 6]) {
                return true;
            }
        }
        return cells[0] != '-' && cells[0] == cells[4] && cells[4] == cells[8]
                || cells[2] != '-' && cells[2] == cells[4] && cells[4] == cells[6];
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == '-') {
                return false;
            }
        }
        return true;
    }

    public char getMark(int position) {
        return cells[position];
    }

    public int findWinningMove(char mark) {
        for (int i = 0; i < cells.length; i++) {
            if (isFree(i)) {
                cells[i] = mark;
                if (checkWin()) {
                    cells[i] = '-'; // reset to original state
                    return i;
                }
                cells[i] = '-';
            }
        }
        return -1;
    }

    public int findBlockMove(char opponentMark) {
        return findWinningMove(opponentMark);
    }

    public int getFirstFreeCell() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == '-') {
                return i;
            }
        }
        return -1;
    }
}

class Player {
    protected char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    public void makeMove(Board board, Scanner scanner) {
        int position;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
                scanner.next(); // consume the non-int input
            }
            position = scanner.nextInt();
            if (position < 0 || position > 8 || !board.isFree(position)) {
                System.out.println("Invalid move. Try again.");
            }
        } while (position < 0 || position > 8 || !board.isFree(position));
        board.placeMark(position, this.mark);
    }
}

class ComputerPlayer extends Player {

    public ComputerPlayer(char mark) {
        super(mark);
    }

    public void makeMove(Board board) {
        int move = board.findWinningMove(this.mark);
        if (move == -1) {
            move = board.findBlockMove(this.mark == 'x' ? 'o' : 'x');
        }
        if (move == -1 && board.isFree(4)) {
            move = 4;
        }
        if (move == -1) {
            for (int i : new int[]{0, 2, 6, 8}) {
                if (board.isFree(i)) {
                    move = i;
                    break;
                }
            }
        }
        if (move == -1) {
            move = board.getFirstFreeCell();
        }
        System.out.println("Computer moves at " + move);
        board.placeMark(move, this.mark);
    }
}