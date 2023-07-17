// Time Complexity : O(8*m*n) = O(m*n)
// Space Complexity : O(1) as dirs array is constant of size 8
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//game of life. Have directions array for interation on all 8 neighours instead of writing conditions in code
//In place method as we replace the dead cells which became live with "3",
// and if live cell became dead then replace it with "2"
class Solution {
    int[][] dirs;
    public void gameOfLife(int[][] nums) {
        
        //0----1 ---->3
        //1----0 ---->2
        int n = nums.length; //rows
        int m = nums[0].length; //columns
                                  //up.   upleft.  upright left    right.  down.  downleft downright 
        dirs = new int[][]{{-1,0}, {-1,-1}, {-1,1}, {0,-1}, {0,1}, {1, 0}, {1,-1}, {1,1}};
        for(int i =0; i<n;i++) {
            for(int j =0; j<m;j++) {
                int cntlive = countLive(nums, i , j, n, m);

                if(nums[i][j]==0 && cntlive ==3){
                    nums[i][j] = 3;
                }
                if(nums[i][j] ==1 && (cntlive <2 || cntlive >3)){
                    nums[i][j] = 2;
                }
            }

        }

        for(int i =0; i<n;i++) {
            for(int j =0; j<m;j++) {
                if(nums[i][j] == 3){
                    nums[i][j] = 1;
                }
                if(nums[i][j] == 2){
                    nums[i][j] = 0;
                }
            }
        }
    }

    private int countLive(int[][] board, int i , int j, int n, int m){
        int count =0;
        for(int[] dir: dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && c>=0 && r<n && c<m && (board[r][c] == 1 || board[r][c] == 2)){
                count++;
            }
        }
        return count;

    }
}