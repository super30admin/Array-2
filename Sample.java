// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//o(n*m) time and o(1) space
class Solution {
    int m; int n;
    public void gameOfLife(int[][] board) {
        //null
        if(board == null) return;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                int count = countLive(board, i, j);
                if(board[i][j] == 1 && (count<2 || count>3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && (count==3)){
                    board[i][j] = 2;
                }
            }
        }
        for(int i = 0; i<m;i++){
            for(int j = 0; j<n;j++){
                if(board[i][j]==3)board[i][j] =0;
                if(board[i][j]==2)board[i][j] =1;

            }
        }
    }
    private int countLive(int[][] board, int i, int j){
        int result = 0;
        int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int [] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c]==1 || board[r][c]==3)){
                result++;
            }
        }
        return result;
    }
}

//o(n) time and constant space

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;

        for (int i = 0 ; i< nums.length; i++){
            int idx = Math.abs(nums[i]) - 1 ;
            if(nums[idx]>0){
                nums[idx] *= -1;

            }
        }
        for(int i = 0; i< nums.length; i++){
            if(nums[i] <0){
                nums[i] *= -1;

            }
            else{
                result.add(i+1);

            }
        }
        return result;
    }
}
