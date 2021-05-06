/*
Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

Problem3 (https://leetcode.com/problems/game-of-life/)
*/
// Your code here along with comments explaining your approach

class Sample {
    private static List<Integer> missing_numbers(int[] nums) {
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        int place;
        for (int num : nums) {
            place = Math.abs(num) - 1;
            nums[place] = - Math.abs(nums[place]);
        }
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) output.add(i + 1);
        }
        return output;
    }

    private static int[] min_max(int[] nums) {
        // Time Complexity : O(1.5n)
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : N/A
        // Any problem you faced while coding this : No

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        if(n < 2) return nums;
        // for each pair compare with min and max
        for(int i = 0; i < nums.length - 1; i++) {
            // compare smaller one with min and bigger one with max
            if (nums[i] < nums[i + 1]) {// comparision 1
                if (nums[i] < min) {    // comparision 2
                    min = nums[i];
                }
                if (nums[i + 1] > max) {// comparision 3
                    max = nums[i + 1];
                }
            } else {
                if (nums[i + 1] < min) {// comparision 2
                    min = nums[i + 1];
                }
                if (nums[i] > max) {    // comparision 3
                    max = nums[i];
                }
            }
        }
        // efficiency = 1.5 * n comparision vs 2n comparisions for naive method.
        return new int[] {min, max};
    }

    int m, n;
    private static int[][] game_of_life(int[][] board) {
        // Time Complexity : O(m * n) m = rows, n = columns
        // Space Complexity : O(1)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        
        m = board.length;
        n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = countCells(i, j, board);
                int cell = board[i][j];
                // rule 1 & 3 (under-population & over-population)
                if (cell == 1 && (count < 2 || count > 3)) {
                    // store intermediate state: 1 -> 0
                    board[i][j] = 2;
                //rule 4
                } else if (cell == 0 && count == 3) {
                    // store intermediate state: 0 -> 1
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int cell = board[i][j];
                if(cell == 2) {
                    // update intermediate state: 1 -> 0
                    board[i][j] = 0;
                } else if (cell == 3) {
                    // update intermediate state: 0 -> 1
                    board[i][j] = 1;
                }
            }
        }

        return board;
        
    }
    
    private int countCells(int i, int j, int[][] board) {
        int[][] directions = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int count = 0;
        for(int[] direction: directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if ( x >= 0 && x < m && y >= 0 && y < n ) {
                int cell = board[x][y];
                if (cell == 1 || cell == 2) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = missing_numbers(new int[] {1, 2, 3, 3, 4, 5});
        for(int n: missingNumbers) {
            System.out.print(n + " ");
        }
        int[] minMax = min_max(new int[] {1, -10, 2, -2, 9, 5});
        System.out.println(String.format("\nMin and Max: %d, %d", minMax[0], minMax[1]));

        int[][] board = game_of_life(new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}});
        System.out.println(Arrays.toString(board));
    }
}