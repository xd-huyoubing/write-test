package edu.xidian.stackAndqueue.queue;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @auther huyoubing
 * @date 2018/11/8 9:03
 */
public class LeetCode_126 {
    public int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        queue.addLast(new Pair<Integer, Integer>(n, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.removeFirst();
            Integer num = pair.getKey();
            Integer step = pair.getValue();
            for (int i = 1; ; i++) {
                int temp = num - i * i;
                if (temp < 0)
                    break;

                if (num == 0)
                    return step + 1;
                if (!visited[temp]) {
                    queue.addLast(new Pair<Integer, Integer>(temp, step + 1));
                    visited[temp] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode_126 leetCode126 = new LeetCode_126();
        System.out.println(leetCode126.numSquares(1888888888));
        System.out.println(leetCode126.numSquares(12));
    }
}
