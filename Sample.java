// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

// # Array-2

// ## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
           List<Integer> list = new ArrayList<>();
           int n = nums.length;
           for(int i=0; i<n; i++){
               //if number is there make corresponding index negative
               int index = Math.abs(nums[i]) - 1;
               if(nums[index] > 0){
                   nums[index] = nums[index] * -1;
               }
           }

           for(int i=0; i<n ; i++){
               if(nums[i] > 0){
                   list.add(i+1);
               }else{
                   nums[i] = nums[i] * -1;
               }
           }
           return list;
    }
}

// Time Complexity : 0(m*n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.
// ## (https://leetcode.com/problems/game-of-life/)

class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        //left i, j i, j-1, right i, j+1 up i-1, j down i+1, j, 
        this.dirs =new int[][]{{0,-1},{0, 1},{-1,0},{1, 0}, {-1,-1}, {-1, 1}, {1,1}, {1, -1}};
        // 1 --- 0 2
        // 0 --- 1 3
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //count number of alives
                int count = countAlive(board, i, j, m, n);
                // 1 & overpopulation and under population
                if(board[i][j] == 1 && (count < 2|| count > 3)){
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3;
                }
            }
        }
        //mutated value changing back to original
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

        private int countAlive(int[][] board, int i, int j, int m, int n){
            int count = 0;
            for(int[] dir: dirs){
                int nr = i + dir[0];
                int nc = j + dir[1];
                //if in bound and either 1 or 2 to check number of alives
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && (board[nr][nc] == 1 || board[nr][nc] == 2)){
                    count++;
                }
            }
            return count;
        }

    }
