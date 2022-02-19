class Solution {
    
    private int[][] directions= new int[][]{
        {-1,-1},//north west
        {-1,0},//north
        {-1,1},//north east
        {0,1},//east
        {1,1},//south east
        {1,0},//south
        {1,-1},//south west
        {0,-1} //west
    };
    
    private int getLNCount(int [][] board, int i, int j){
        
        int m= board.length;
        int n= board[0].length;
        int count=0;
        
        for(int[] direction : directions){ // here we r creating a 1D array direction which will change in every iteration according to the row of 2D directions array
            
            int x= i+ direction[0]; // getting the row index of neighbouring element
            int y= j+ direction[1]; // getting the column index of neighbouring element
            
            if(x>=0 && x<m && y>=0 && y<n){ // checking if the element is out of bounds
                if(board[x][y]==-2 || board[x][y]==1){ // since we have put -1 instead of 1 for the sake of storing 1
                count++;
                }
            }
        }
        
        
        return count;
    }
    
    public void gameOfLife(int[][] board) {
        int m= board.length;
        int n= board[0].length;
        
        //LN<2 or >3, 1->0
        //LN=3, 0->1
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int LN= getLNCount(board, i, j); // Number of Live Neighbours
                if(board[i][j]==1){  // if the input is 1
                    if(LN<2 || LN>3){  
                        board[i][j]=-2; //1 to 0-> -2
                    }
                }
                else{   // if input is 0
                    if(LN==3){
                        board[i][j]=-1;  //0 to 1-> -1
                    }
                }
            }
        }
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(board[i][j]==-1){
                    board[i][j]=1; // if -1 restoring to final value 1
                }
                if(board[i][j]==-2){
                    board[i][j]=0;  // if -2 restoring to final value 0
                }
            }
        }
    }
}