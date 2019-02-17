package edu.xidian.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 有兵
 * @date 2018/12/12 16:07
 */
public class LeetCode_79 {
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        m = board.length;
        if (m <= 0) {
            return false;
        }
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (findPath(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[][] board, int x, int y, int index, String word) {
        //如果是最后一个字母并且该字母在board中能够找到则返回true
        if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
            return true;
        }
        if (board[x][y] == word.charAt(index)) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && findPath(board, newX, newY, index + 1, word)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'a', 'b'},
                        {'c', 'd',}
                };
        String word = "abcd";
        LeetCode_79 leetCode_79 = new LeetCode_79();
        boolean exist = leetCode_79.exist(board, word);
        System.out.println(exist);
    }
}
