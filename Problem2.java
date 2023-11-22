// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :

import java.util.Arrays;


public class Problem2 {
    private static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { -1, -1 }, { 1, -1 },
            { 1, 1 } };

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getNumberOfNeighbors(board, m, n, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2; // Mark for death
                } else if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 5; // Mark for resurrection
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0; // Apply death
                else if (board[i][j] == 5)
                    board[i][j] = 1; // Apply resurrection
            }
        }
    }

    private static int getNumberOfNeighbors(int[][] board, int m, int n, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2))
                count++;
        }
        return count;
    }

    public static void main(String[] arg) {
        int[][] nums = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        print(nums);
        gameOfLife(nums);
        System.out.println("********");
        print(nums);

    }

    private static void print(int[][] nums) {
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }
}
