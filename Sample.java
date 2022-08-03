// Time Complexity : O(MN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes   
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    
    //TC O(MN)
    //SC 0(1)
    
    /* 
    iterate through the matrix and handle the rules
    for values changing the state from 1 to 0 mark it as 2
    for values changing the state from 0 to 1 matk it as 3
    
    calculate countAlives;
     
     declare the dirs array with top,bottom,topleft.... with the indexes, count the values of count around the neighbours 
     
     apply the countAlives to the board array
    
    */
    
    int m;
    int n;
    int [][] dirs;
    public void gameOfLife(int[][] board) {
        
         m= board.length;
         n= board[0].length;
         dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                int count = countAlives(board,i,j);
                
                if(board[i][j] ==1 && (count<2 || count>3))
                    board[i][j] =2;
                if(board[i][j]==0 && count ==3) 
                    board[i][j] =3;
            }
        }
        
                for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 2 ) board[i][j] =0;
                if(board[i][j] ==3) board[i][j] =1;
            }
         }
        
    }
    
    private int countAlives(int[][] board,int i,int j){
        
        int count =0;
        for(int[] dir: dirs){
        int rowindex = i+dir[0];
        int colindex = j+dir[1];
            
            if(rowindex >=0 && rowindex<m && colindex >= 0 && colindex <n
               && (board[rowindex][colindex] ==1 || board[rowindex][colindex] ==2 ))
                count++;
        }
        return count;
        
    }
}
