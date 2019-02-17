package edu.xidian.recall;

/**
 * @author 有兵
 * @date 2018/12/12 16:08
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 这个题思路非常清晰  主要就是处理完边界即可
 * 思路：首先将边界上单o进行深度遍历，将其改为*,然后对整个矩阵进行遍历，将*改为o，将其余的o改为X
 */
public class LeetCode_130 {
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        //遍历第一行并将O改为*  //遍历最后一行并将O改为*
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        //遍历第一列并将其相连的O改为X  //遍历最后一列并将其相连的O改为X
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        //遍历整个矩阵并将*改为O,将其余的O改为X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else {
                    continue;
                }
            }
        }
        return;
    }

    private void dfs(char[][] board, int startx, int starty) {
        if (board[startx][starty] == 'O') {
            board[startx][starty] = '*';
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && board[newx][newy] == 'O') {
                    dfs(board, newx, newy);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
