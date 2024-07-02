// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        int[] mp = new int[n+1];
        Arrays.fill(mp, 0);
        for (int i=0;i<n;i++){
            mp[nums[i]]++;
        }

        for (int i=1;i<=n;i++){
            if (mp[i] == 0){
                arr.add(i);
            }
        }
        return arr;
    }
}


// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : little bit

class Solution {
    private int die = 2;
    private int live = 3;
    int[] dirX = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] dirY = {-1, -1, -1, 0, 1, 1, 1, 0};

    private int countLive(int i, int j,int[][] board){
        int count = 0;
        
        for (int k=0;k<dirX.length;k++){
            int x = i+dirX[k];
            int y = j+dirY[k];
            
            if (x>=0 && y>=0 && x < board.length && y<board[0].length ){
                
                if (board[x][y] == 1 || board[x][y] == die)   // becoz it changed from 1 to die
                    count ++;
            }
        }
        
        return count;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int around = countLive(i,j,board);
                if (board[i][j] == 0 && around == 3)
                    board[i][j] = live;
                else if (board[i][j] == 1){
                    if (around == 2 || around ==3)
                        continue;
                    if (around < 2 || around > 3)
                        board[i][j] = die;
                }
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                 if (board[i][j] == die)
                     board[i][j] = 0;
                 if (board[i][j] == live)
                     board[i][j] = 1;
                }
            }


    }
}

// Time Complexity : O(1) + 2 * O(n-1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : not exist
// Any problem you faced while coding this : already done it
    class Solution{
    static class Pair {

        int min;
        int max;
    }

    static Pair getMinMax(int arr[], int n) {
        Pair minmax = new  Pair();
        int i;

        if (n == 1) {
            minmax.max = arr[0];
            minmax.min = arr[0];
            return minmax;
        }

        if (arr[0] > arr[1]) {
            minmax.max = arr[0];
            minmax.min = arr[1];
        } else {
            minmax.max = arr[1];
            minmax.min = arr[0];
        }

        for (i = 2; i < n; i++) {
            if (arr[i] > minmax.max) {
                minmax.max = arr[i];
            } else if (arr[i] < minmax.min) {
                minmax.min = arr[i];
            }
        }

        return minmax;
    }
}