    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/game-of-life/
    Time Complexity for operators : o(n*m) .. number of  elements in the matrix
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach same like basic approach: create the 2nd matrix same values as first and during calculation refer 1st matrix.
                              
            # 1. traverse thru thee matrix one by one. Check in the all 8 directions and calcuklatee the 
                 number of lifes. It will help to check the conditions.
              2. Once we have isaliove counter, then we can check then conditions. when Aliove<2 || alve >3
                 then make that value to dead. Make the value 2 as we will lost the previous value. 
                 (2 - will tell use that it was 1 and now it changhed to 0 that is dead)
                 (2 - will tell use that it was 0 and now it changhed to 1 that is alive)
              3. next check if it is dead nad number of lives is 3 then make it alive.
       */

   class gameOfLife {

    public static void main(String args[]) {
                    int nums[][] = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
                    gameOfLifeProblem(nums);
                    for(int i=0;i<nums.length;i++){
                        for(int j=0;j<nums[0].length;j++){
                            System.out.print(nums[i][j]);
                        }
                        System.out.println();
                    }
        }


    public static void gameOfLifeProblem(int[][] board) {
        
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        
        int n = board.length;
        int m = board[0].length;
         
        //change when it is dying to 2 so that you get to know that previous value is 1
        //change when it is gaining life to 3 so that you get to know that previous value is 0
        
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                   
                 int alive = calcuateLife(board,i,j,n,m);
                 
                 if(board[i][j] == 1 && (alive <2 || alive >3)){
                     board[i][j] = 2;
                 }else if(board[i][j] == 0 && alive ==3){
                     board[i][j] = 3;
                 }
              }
        }
        
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                   
                if(board[i][j] == 2)
                    board[i][j] = 0;
                 
                 if(board[i][j] == 3)
                     board[i][j] = 1;
              }
        }
    }
    
    public static int calcuateLife(int[][] board,int i,int j,int n,int m){
        int cnt = 0;
        
        int dirs[][] = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if(r>=0 && r < n && c>=0 && c <m && (board[r][c]==1 ||board[r][c]==2)){
                cnt +=1;
            }
        }
        
        return cnt;
    }
}