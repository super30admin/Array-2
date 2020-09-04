// Time Complexity :O(N^2)
// Space Complexity :O(N^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
Worte a function to count the total alive cells around particulat matrix element and implemented the conditions to check weather that particular cell lives or dies.
class Solution {
    public void gameOfLife(int[][] board) {
        
        if(board == null || board.length==0 || board[0].length==0){
            return;
        }
        
        int n=board.length; int m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int alive= countAlive(board,n,m,i,j);
                
                if(board[i][j]==1 &&(alive<2 || alive>3)){
                    board[i][j]=2;
                }else if(board[i][j]==0 && alive==3){
                    board[i][j]=4;
                }
             }
        }
                   
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==4){
                    board[i][j]=1;
                }
            }
        }
                   
    }
    
    
    public int countAlive(int[][]board, int n, int m, int i, int j){
        int count=0;
        
        int [][]dirs={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
        for(int[] dir :dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            
            if(r>=0 && r<n && c>=0 && c<m && (board[r][c]==1 || board[r][c]==2)){
                count+=1;
            }
        }
            return count;
        }
        
    }
