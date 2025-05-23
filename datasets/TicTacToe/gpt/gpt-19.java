import java.util.Arrays;

class Board {
    private final char[] fields = new char[9];
    private final char emptyMarker = '-';
    
    public Board() {
        Arrays.fill(fields, emptyMarker);
    }
    
    public boolean isFieldAvailable(int index) {
        return fields[index] == emptyMarker;
    }
    
    public boolean placeMark(int index, char mark) {
        if (isFieldAvailable(index)) {
            fields[index] = mark;
            return true;
        }
        return false;
    }
    
    public boolean isWinner(char mark) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((fields[i * 3] == mark && fields[i * 3 + 1] == mark && fields[i * 3 + 2] == mark) ||
                (fields[i] == mark && fields[i + 3] == mark && fields[i + 6] == mark)) {
                return true;
            }
        }
        return (fields[0] == mark && fields[4] == mark && fields[8] == mark) ||
               (fields[2] == mark && fields[4] == mark && fields[6] == mark);
    }
    
    public boolean isFull() {
        for (char field : fields) {
            if (field == emptyMarker) {
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
            if (i % 3 == 2 && i != fields.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    
    public int findWinningField(char mark) {
        for (int i = 0; i < 9; i++) {
            if (isFieldAvailable(i)) {
                placeMark(i, mark);
                if (isWinner(mark)) {
                    fields[i] = emptyMarker; // Undo move
                    return i;
                }
                fields[i] = emptyMarker; // Undo move
            }
        }
        return -1;
    }
}