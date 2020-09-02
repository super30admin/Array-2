
// Time Complexity : O(n*m) and we are traversing throught complete matrix
// Space Complexity :O(1) we are not creatung any new array. we are just updating the given array. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach



class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        vector<vector<int>> result;
        int rows = board.size();
        
        if (rows == 0){ // return if the input is NULL
            return;
        }
        int columns = board[0].size();
 
        
        for (int i = 0; i <= rows-1; i++){ // traverse through the complete matrix for each cell and check for adjacency.
            
            for ( int j = 0; j<=columns-1; j++){
                      int state = get_adj(board, i,j, rows, columns); // get adjacency values
                
                       if (board[i][j] == 1){
                           if (state < 2 || state > 3 ){ // the cell will die based on conditions given
                               board[i][j] = 2; // set the value to 2 just to indicate that the cell was previousely living.
                           }
                           
                       } else {
                           if( state ==3){ // set the value to 4 just to indicate that the cell was previousely dead.
                                board[i][j] = 4; // dead cell will relive based on these condition
                           }
                       } 
          
            }
        }
        
          for (int i = 0; i <=rows-1; i++){
            
            for ( int j = 0; j<=columns-1; j++){
                
                if (board[i][j] == 2){
                    board[i][j] = 0;  // reset all the 2 to 0 & 4 to 1 for the given as output.
                }
                
                 if (board[i][j] == 4){
                    board[i][j] = 1;
                }
            }
          }
        
    
    }

        
        int get_adj(vector<vector<int>>& board1, int i, int j, int rows, int columns){
            int array[8][2]  = {{-1,0}, {-1, 1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1} }; // all the adjacent values.
            int adj = 0;
            for ( int k = 0; k < 8; k++){
                int row = i + array[k][0];
                int col = j + array[k][1];
                if (row>= 0 && row< rows && col >=0 && col < columns && (board1[row][col] == 1 || board1[row][col] == 2 ) ){
                    adj +=1; // check for the boundary conditions to check we are going out of bound or not. 
                    // and then we will check whether the adjacent cell is live or previsely alive (1 or 2) then increase counter.
                }
            }
            return adj;
        }
    
};