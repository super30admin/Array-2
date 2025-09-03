import java.util.Arrays;

// Time Complexity : O(m * n) since we will have to iterate over each element in the matrix
// Space Complexity : O(1) since we are updating the input matrix in place to mark the dead and alive numbers
// Did this code successfully run on Leetcode :Yes
//Approach: Iterate over each element, follow the rules, there are 8 directions to check the neighbors in (top, down, left, right, up left, up right, down left, down right)
//if the neighbor is alive (1) or newly dead (2) count both cases for alive (current state)
//if the alive neighbors count is 3, mark the element as dead (3)
//We use 2 and 3 initially to mark newly dead and alive to avoid getting into count mismatch issues
//After we are done updating the states , we put 2 as 0, 3 as 1 in the matrix
public class GameOfLife {

    public void gameOfLife(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                final int alive = countAlive(matrix, i, j);
                //if alive count < 2 (underpopulation) or alive > 3 (over population) and value at i,j = 1, mark it as dead = 2
                if (matrix[i][j] == 1 && (alive < 2 || alive > 3)) matrix[i][j] = 2;
                //if alive = 3 value at i,j = 0, mark it as alive = 3
                if (matrix[i][j] == 0 && alive == 3) matrix[i][j] = 3;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2)
                    matrix[i][j] = 0; //put dead as 0, after doing the iterations in the previous nested loop
                if (matrix[i][j] == 3)
                    matrix[i][j] = 1; //put alive as 1, after doing the iterations in the previous nested loop
            }
        }
    }

    private int countAlive(int[][] matrix, int i, int j) {
        int count = 0;
        int[][] directions = new int[][] {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int[] dir: directions) {
            int nr = i + dir[0], nc = j + dir[1];
            if (nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length
                    && (matrix[nr][nc] == 1 || matrix[nr][nc] == 2)
            ) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        final GameOfLife gameOfLife = new GameOfLife();
        int[][] matrix = new int[][] {
                {0,1,0},{0,0,1},{1,1,1}, {0,0,0}
        };
        gameOfLife.gameOfLife(matrix);
        System.out.println(Arrays.deepToString(matrix));
        //final state -> [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
    }
}
