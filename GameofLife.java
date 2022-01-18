//Challenges faced and Optimisation:
//Making the changes in the same with constant O(1) space is the challenge;
//Learnt: dirs array which calculates if current cell can be active or dead by checking all 8 cells of the neighbours;

//SC: O(1);
//TC: O(N); as one need to travel the whole array to make the changes compute the cells going live and cells going dead;

//Solution:
class Solution {
    
    int m,n;
    public void gameOfLife(int[][] board) {
        if(board==null || board.length==0) return;
        
        m=board.length;
        n=board[0].length;
        
        //changing the cells to 2 or 3 depending on if 1 or 0 has changed or not;
        //in. a way we can make the changes in the same matrix being used and we need not use a different matrix altogether;
        
        //need to traverse the board using m*n cells;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=countlives(board,i,j);
            
            if(board[i][j]==1){
                if(lives<2 || lives>3){
                    board[i][j]=2;
                    }
                }
            else{       //case when board[i][j]==0;
                if(lives==3){
                    board[i][j]=3;
                }
            }    
                
            }     
        }//After changing to 2,3 1 and 0 respectively;
        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=0;
                }else if(board[i][j]==3){
                    board[i][j]=1;
                }
            }
        }
        
    }
    
    private int countlives(int [][] board,int r,int c){
        //dirs matrix giving all the 8 directions
        int dirs[][]={{0,1},{0,-1},{-1,0},{1,0}, {-1,-1},{-1,1}, {1,-1},{1,1}};
        int count=0;
        
        //the loop is running for the constant time, so the changes made due to multplic will be constant again;
        //dir 1D array travels along the 2D array of the dirs array;
        for(int [] dir: dirs){
            int nr=r+ dir[0];
            int nc=c+ dir[1];
            //check if the nc and nr lies within the range of the matrix
            //if yes, then check in () that if condition of 1 or 2 comes in to add to the neighbor count;
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2) ){
                count++;
            }
        }
        return count;   
        //this will be the no of lives being returned for any given cell;
    }
}
