package edu.xidian.recall;

/**
 * @author 有兵
 * @date 2018/12/12 15:38
 */
public class LeetCode_200 {
    //保存岛屿的数量
    int count = 0;
    //m为数组的行数，n为数组的列数
    int m, n;
    boolean[][] visited;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    countIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * floodfill算法   感染相邻的1的岛屿
     */
    private void countIslands(char[][] grid, int x, int y) {
        //递归终止条件融合进当前代码中去了
        if (grid[x][y] == '1') {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + d[i][0];
                int newY = y + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    countIslands(grid, newX, newY);
                }
            }
        }
    }
}
