class Solution {
    public boolean isValidSudoku(char[][] board) {
         // We need to check each Individual Boxes.
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                HashSet<Character> boxSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow + i][boxCol + j];
                        if (current != '.' && boxSet.contains(current)) {
                            return false;
                        }
                        boxSet.add(current);
                    }
                }
            }
        }
        // We need to each row and each colum at a time.
        for (int row = 0; row < 9; row++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char rowChar = board[row][col];
                char colChar = board[col][row];
                // For checking row sets.
                if (rowChar != '.' && rowSet.contains(rowChar)) {
                    return false;
                }
                rowSet.add(rowChar);
                // For checking column sets.
                if (colChar != '.' && colSet.contains(colChar)) {
                    return false;
                }
                colSet.add(colChar);

            }
        }
        return true;
    }
}
