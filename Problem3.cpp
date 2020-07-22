// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    int noOfLives(vector<vector<int>>& board, int i, int j, int m, int n){
        int dirs[8][2]={{0,-1}, {0,1}, {1,-1},{1,0}, {1,1},{-1,-1},{-1,0},{-1,1}};;
        int count=0;
        for(int k=0; k<8; k++){
            int r = i+dirs[k][0];
            int c= j+dirs[k][1];
            if(r>=0 && r<m && c>=0 && c<n){
                if(board[r][c]==1||board[r][c]==3){
                    count++;
                 }
            }
        }
        
        return count;
    }
    
    void gameOfLife(vector<vector<int>>& board) {
        //3--( 1 to 0)
        //2 (0 to 1)
        int m = board.size();
        int n= board[0].size();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int lives = noOfLives(board, i, j, m, n);
                if(board[i][j]==1 || board[i][j]==3){
                    if(lives<2 || lives>3)
                        board[i][j]=3;
                }
                else{
                    if(lives==3){
                        board[i][j]=2;
                    }
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
};
