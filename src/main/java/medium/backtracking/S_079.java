package medium.backtracking;

import org.junit.Test;

public class S_079 {
    boolean[][] mark;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }

        mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (i < 0 || i == board.length || j < 0 || j == board[i].length) {
            return false;
        }

        if (mark[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        mark[i][j] = true;
        if (dfs(i - 1, j, board, word, index + 1)
                || dfs(i + 1, j, board, word, index + 1)
                || dfs(i, j - 1, board, word, index + 1)
                || dfs(i, j + 1, board, word, index + 1)) {
            return true;
        }
        mark[i][j] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}
                };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
