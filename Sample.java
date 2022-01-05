// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index =  Math.abs(nums[i])-1;
            if(nums[index] > 0){
                 nums[index] *=-1;
            }
                
            
        }
            for(int i =0;i<nums.length;i++){
                if(nums[i] > 0){
                    result.add(i+1);
                }
            }
            return result;
    }
}
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    int [][] dirs;
        int m;
        int n;
    public void gameOfLife(int[][] board) {
        if(board == null) return;
         m = board.length;
         n = board[0].length;
        dirs = new int [][]{{0,1},{0,-1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                //1--0-->2
                //0---1--3
                int countLive = countLive(board,i ,j);
                if(board[i][j] == 1 && (countLive<2)||(countLive>3)){
                    board[i][j] = 2;
                }if(board[i][j] == 0 && countLive==3){
                    board[i][j] = 3;
                }
            }
        }
            for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j] == 2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
        public int countLive(int [][]board,int i ,int j){
            int result = 0;
            for(int[] dir : dirs){
                int r = i+dir[0];
                int c = j+dir[1];
                if(r>=0 && c>=0 && r<m && c<n && (board[r][c] == 1||board[r][c] == 2)){
                    result++;
                }
            }
            return result;
            
        }
        
    }

