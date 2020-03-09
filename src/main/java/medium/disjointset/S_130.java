package medium.disjointset;

import org.junit.Test;
import util.ShowUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hunan
 * @date 2020-03-01
 * @time 21:20
 */
public class S_130 {
    /**
     * 暴力+优化
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int r = board.length, c = board[0].length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && (i == 0 || j == 0 || i == r - 1 || j == c - 1)) {
                    doSolve(board, set, i * c + j, c);
                }
            }
        }


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!set.contains(i * c + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void doSolve(char[][] board, Set<Integer> set, int addressNo, int col) {
        set.add(addressNo);
        int i = addressNo / col;
        int j = addressNo % col;
        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
            int addr = (i - 1) * col + j;
            if (!set.contains(addr)) {
                doSolve(board, set, addr, col);
            }
        }

        if (i + 1 < board.length && board[i + 1][j] == 'O') {
            int addr = (i + 1) * col + j;
            if (!set.contains(addr)) {
                doSolve(board, set, addr, col);
            }
        }

        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
            int addr = i * col + j - 1;
            if (!set.contains(addr)) {
                doSolve(board, set, addr, col);
            }
        }

        if (j + 1 < col && board[i][j + 1] == 'O') {
            int addr = i * col + j + 1;
            if (!set.contains(addr)) {
                doSolve(board, set, addr, col);
            }
        }
    }

    /**
     * 并查集解法
     *
     * @param board
     */
    public void solve2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int r = board.length, c = board[0].length;
        List<Integer> edge = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] parent = new int[r * c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    int addr = i * c + j;
                    list.add(addr);
                    if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                        edge.add(addr);
                    }

                    parent[addr] = addr;
                    if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                        join(parent, (i - 1) * c + j, addr);
                    }

                    if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                        join(parent, i * c + j - 1, addr);
                    }
                }
            }
        }

        Set<Integer> edgeRoots = new HashSet<>();
        for (Integer addr : edge) {
            edgeRoots.add(searchRoot(parent, addr));
        }

        for (Integer addr : list) {
            if (!edgeRoots.contains(searchRoot(parent, addr))) {
                board[addr / c][addr % c] = 'X';
            }
        }
    }

    private void join(int[] parent, int i, int j) {
        int iroot = searchRoot(parent, i);
        int jroot = searchRoot(parent, j);
        if (iroot != jroot) {
            parent[iroot] = jroot;
        }
    }

    private int searchRoot(int[] parent, int addr) {
        int son = addr;
        int root = addr;
        while (parent[root] != root) {
            root = parent[root];
        }

        while (son != root) {
            int tmp = parent[son];
            parent[son] = root;
            son = tmp;
        }

        return root;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        ShowUtils.show(board);
        System.out.println("----------------");
        solve2(board);
        ShowUtils.show(board);
    }
}
