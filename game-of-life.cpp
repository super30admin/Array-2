//Time complexity - O(nm)
//Space complexity - I(1)

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
       int m = board.size(),n = board[0].size(); 
        int count = 0;
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                count=0;
                for (int I=max(i-1, 0); I<min(i+2, m); ++I)
                for (int J=max(j-1, 0); J<min(j+2, n); ++J){
                    if(i==I && j==J) continue;
                    count += (abs(board[I][J])==1?1:0);
                }
                
                if((count < 2 || count >3) && board[i][j] == 1){
                    board[i][j] = -1;
                } 
                if(count == 3 && board[i][j] == 0){
                    board[i][j] = 2; 
                }
            }
        }
        
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board[row].size(); col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
};