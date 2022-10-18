package matrix;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTracking(board, i, j, word, 0)){
                    return true;
                };
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, int i, int j, String word, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = (char)257;
        pos++;
        if (pos == word.length()) {
            return true;
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int i_ = dir[0] + i;
            int j_ = dir[1] + j;
            if (backTracking(board, i_, j_, word, pos)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
