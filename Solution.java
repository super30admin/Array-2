import java.util.ArrayList;
import java.util.List;

public class Solution {
}

// TC: O(r*c) SC:O(1)
class GameOfLife {
    int rows, cols;

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();

        int[][] board1 = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        System.out.println("Original Board:");
        printBoard(board1);

        solution.gameOfLife(board1);

        System.out.println("After One Step:");
        printBoard(board1);
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        // 1--> 0 change to 2 live to dead
        // 0--> 1 change to 3 dead to live
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int countLiveNeighbours = countLiveNeighbours(board, i, j);
                if (board[i][j] == 1) {
                    if (countLiveNeighbours < 2 || countLiveNeighbours > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (countLiveNeighbours == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countLiveNeighbours(int[][] board, int row, int col) {
        int count = 0;
        // Up, Down, left, right, UPL, UPR, LRL, LRR
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}

// TC: O(n) SC: O(1)
class NumbersDisappeared {
    public static void main(String[] args) {
        NumbersDisappeared solution = new NumbersDisappeared();

        int[] nums1 = { 4, 3, 2, 7, 8, 2, 1 };
        List<Integer> result1 = solution.findDisappearedNumbers(nums1);
        System.out.println("Disappeared Numbers 1: " + result1);

        int[] nums2 = { 1, 1, 2, 2, 3, 4, 4 };
        List<Integer> result2 = solution.findDisappearedNumbers(nums2);
        System.out.println("Disappeared Numbers 2: " + result2);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}