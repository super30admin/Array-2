# Array-2

## Problem1 (https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. we will run a loop from 0 to nums.length. And we will find the correct index of that number as every number's correct index is at num-1 and mark it as negative
2. We will run a second for loop and if the value at any index is positive that means the number is missing at that index ad the number should be index+1 and we will add that to our ans list

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums.length == 0 || nums == null){
            return new ArrayList<>();
        }

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<nums.length ; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
## Problem2

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1. First we will find the index of min and max element
2. then we will have 3 cases i) to delete from front ii) to delete from back iii) to delete from both front and back
3. Return min of all the 3 cases 
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison

class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }

        int min = 0;
        int max = 0;

        for(int i = 1; i<nums.length; i++){
            if (nums[i] < nums[min]) {//find the min index
                min = i;
            }
            if (nums[i] > nums[max]) {//find the max index
                max = i;
            }
        }
        int front = Math.max(min, max) + 1; //delete from front
        int back = nums.length - Math.min(min, max); //delete from back
        int both = Math.min(min, max) + 1 + nums.length - Math.max(min, max); //delete from both front and back

        return Math.min(front, Math.min(back, both));
    }
}

## Problem3 (https://leetcode.com/problems/game-of-life/)

// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
1.	Mark transitions using temporary states: 1 → 0 as 2, and 0 → 1 as 3, without altering original neighbor data.
2.	Traverse the board, count live neighbors for each cell, and apply rules to mark state transitions.
3.	Convert temporary values back: finalize board by replacing 2 → 0 and 3 → 1.

class Solution {
    int[][] dirs;
    int m,n;

    public void gameOfLife(int[][] board) {

        this.dirs = new int[][]{{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1,-1}, {1,0}, {1,1}};

        this.m = board.length;
        this.n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = getCount(board, i, j);  // number of alive cells around it
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 3; // dead -> alive;
                }
                else if(board[i][j] == 1 && (count < 2 || count >3)){
                    board[i][j] = 2; // alive -> dead;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getCount(int[][] board, int i, int j){
        int count = 0;

        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            if(r>=0 && c>=0 && r<m && c<n){ 
                if(board[r][c] == 1 || board[r][c] == 2) count++;
            }
        }

        return count;
    }
}
