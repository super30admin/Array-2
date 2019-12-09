//Time Complexity - O(m*n) where m is the number of rows and n is the number of columns. Since we will be traversing each element once.
//Space Complexity - O(1) Since we are mutating the same array.
// This solution worked on LeetCode
// The directions will be used to get the 8 directions of an element.

class Solution {
    int[][] directions ={{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0 || board[0].length==0)  return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int lives = livecnt(board,i,j);     
                if(board[i][j]==1 && (lives <2 || lives > 3)){    //For 1->0 condition
                    board[i][j] =2; 
                }
                else if(board[i][j]==0 && lives == 3){    //For 0->1 condition
                    board[i][j] = 3;
                }
            }    
        }
         for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %= 2;           //%2 so that the 2 are changed to 0 and 3 are changed to 1 
            }
         }
    }
    private int livecnt(int[][] board,int i,int j ){
        int lives =0;
        for(int [] dir:directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x <0 || x >= board.length || y<0 || y >= board[0].length)
                continue;
            if(board[x][y] == 1 || board[x][y]== 2)   //Check if it is 1 or has become 2
                lives++;
        }
        return lives;
    }
}

