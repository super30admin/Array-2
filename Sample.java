// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Sample {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1] && nums[i]!=i + 1) {
                swap(nums, nums[i] - 1, i );
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i] - 1) {
                ans.add(i + 1);
            }
        }
        return ans;


    }
    private void swap(int[] nums,int a,int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



    // Time Complexity : O(m * n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes
    public void gameOfLife(int[][] board) {
        int m = board.length - 1;
        int n = board[0].length - 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 0 && getCountLives(board, i, j) == 3 ) {
                    board[i][j] = 2; // dead to live
                }
                if (board[i][j] == 1 && (getCountLives(board, i, j) < 2 || getCountLives(board, i, j) > 3)) {
                    board[i][j] = 3; // live to dead
                }
            }

        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 2){
                    board[i][j] = 1;
                }

                if (board[i][j] == 3){
                    board[i][j] = 0;
                }
            }
        }

    }
    private int getCountLives(int[][] board, int r, int c) {
        int count = 0;

        int [][] dir = new int[][]{
                {1, 1},
                {1, 0},
                {1, -1},
                {0, -1},
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {0, 1}
        };
        for (int i = 0; i < dir.length; i++) {
            if (0 <= r + dir[i][0]  && (r + dir[i][0]) <= board.length - 1 && (c + dir[i][1]) >= 0 && (c + dir[i][1]) <= board[r].length - 1) {
                if (board[r + dir[i][0]][c + dir[i][1]] == 1 || board[r + dir[i][0]][c + dir[i][1]] == 3) {
                    count++;
                }
            }
        }
        return count;

    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : yes


    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        int min = Integer.MAX_VALUE;
        int max = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length < 2) {

            list.add(arr[0]);
            list.add(arr[0]);
            return list;
        }

        for (int i = 0; i < arr.length; i++) {
            if(i + 1 >= arr.length ) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
                break;
            }
            if(arr[i] > arr[i + 1]) {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            } else {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i + 1]);
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }
}