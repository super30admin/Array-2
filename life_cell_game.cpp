// Time Complexity : O(mn)
// Space Complexity : BF:O(mn) space:O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach:

//1.Edge case
//A. return id the board size is 0

//2. Brute force method 
//A. create an extra array store the result of the count in that araay
//B. copy the array back while returning

//3.Optimized method to save space
//A. Update the transitions to a different number -5: previously alive now dead 5: previously dead now alive
//B. Update the array and return

class Solution {
    
     int get_count_optimized (vector<vector<int>>& board ,int rows,int cols,int current_row,int current_col ){
       int dirs[8][2] = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
       int count=0;
      for(int i=0; i<8;i++){
          int temp_row =  current_row + dirs[i][0];
          int temp_col =  current_col + dirs[i][1];
          
          if(temp_row>=0 && temp_row<rows && temp_col>=0 && temp_col<cols && (board[temp_row][temp_col]==1 || board[temp_row][temp_col]==-5) ){
              count++;
          }
      }
     return count;
  }
    
    
   void  optimized_board_update(vector<vector<int>>& board){
       int rows = board.size();
      int cols=  board[0].size();
      
      vector<vector<int>> temp_board_values(rows, vector<int> (cols, 0));
      int count=0;
      for(int current_row=0; current_row<rows; current_row++){
          for(int current_col=0; current_col<cols; current_col++){
              count = get_count_optimized(board, rows, cols, current_row,current_col);
              //live check
              if(board[current_row][current_col]==1 ){
                  if(count<2 || count>=4){
                     board[current_row][current_col] = -5;
                  }
              }
               //dead check
              if(board[current_row][current_col]==0 ){
                  if(count==3){
                     board[current_row][current_col] = 5;
                  }
              }
          }
      }
     for(int current_row=0; current_row<rows; current_row++){
          for(int current_col=0; current_col<cols; current_col++){
              if(board[current_row][current_col] == -5){
                  board[current_row][current_col]= 0;
              }
              else if(board[current_row][current_col] ==5){
                   board[current_row][current_col] =1;
              }
          }
      }
      return;
  }

    
public:
    void gameOfLife(vector<vector<int>>& board) {
        //1.A
        if(board.size()==0){
            return;
        }
        //2.
        //return brute_force_board_update(board);
        //3.
        return optimized_board_update(board);
    }
};
