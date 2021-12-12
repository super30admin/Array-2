// Time Complexity : O(mn)m= no of rows, n= no of columns
// Space Complexity :O(mn) used an auxiliary array 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
public class Solution2 {
    public void gameOfLife(int[][] board) {
        if(board==null ||board.length==0)
            return;
        
        int m=board.length;
        int n=board[0].length;
        // applying the rules 
        // not changing the state but making it 2 or 3
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=countlives(board,i,j);
                if(board[i][j]==1){
                    if(lives<2 ||lives>3)
                        board[i][j]=2;
                }
                else{
                    if(lives==3)
                        board[i][j]=3;   
                }
                    
            }
        }
        // changing the board to get the final array
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2)
                    board[i][j]=0;
                if(board[i][j]==3)
                    board[i][j]=1;
            }
    }
 }    
    private int countlives(int [][] board,int r,int c){
        // reaching all the neighbours in 8 directions
        // checking if its a valid board entry that satisfies the constraint
        int [][] dirs={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int count=0;
        for(int [] dir:dirs){
            int nr=dir[0]+r;
            int nc=dir[1]+c;
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length && (board[nr][nc]==1 || board[nr][nc]==2 ))
                count++;
        }
        return count;
    }
}