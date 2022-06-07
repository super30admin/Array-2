//Time Complexity- O(m*n)
//Space Complexity- O(1)

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                int live=0;
                for(int k=-1;k<=1;k++){
                    for(int l=-1;l<=1;l++){
                        int ni=i+k;
                        int nj=j+l;
                        if(l==0 && k==0){
                            continue;
                        }
                        if(ni>=0 && nj>=0 && ni<board.size() && nj<board[i].size() && (board[ni][nj]==1 || board[ni][nj]==3)){
                            live++;
                        }
                    }
                }
                if(board[i][j]==0){
                    if(live==3){
                        board[i][j]=2;
                    }
                }
                else if(board[i][j]==1){
                    if(live<2 || live>3){
                        board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }
};