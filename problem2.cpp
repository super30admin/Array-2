//Time Complexity - O(M*N)
//Space Complexity - O(1)

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m=board.size(),n=board[0].size(),d=0,l=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0&&j>0){
                    if(board[i-1][j-1]==0||board[i-1][j-1]==2){
                            d++;
                        }
                    if(board[i-1][j-1]==1||board[i-1][j-1]==3){
                            l++;
                        }
                }
                if(i>0&&j<n-1){
                    if(board[i-1][j+1]==0||board[i-1][j+1]==2){
                            d++;
                        }
                    if(board[i-1][j+1]==1||board[i-1][j+1]==3){
                            l++;
                        }
                }
                if(i>0){
                    if(board[i-1][j]==0||board[i-1][j]==2){
                            d++;
                        }
                    if(board[i-1][j]==1||board[i-1][j]==3){
                            l++;
                        }
                }
                if(j>0){
                    if(board[i][j-1]==0||board[i][j-1]==2){
                            d++;
                        }
                    if(board[i][j-1]==1||board[i][j-1]==3){
                            l++;
                        }
                }
                if(j<n-1){
                    if(board[i][j+1]==0||board[i][j+1]==2){
                            d++;
                        }
                    if(board[i][j+1]==1||board[i][j+1]==3){
                            l++;
                        }
                }
                if(i<m-1&&j>0){
                    if(board[i+1][j-1]==0||board[i+1][j-1]==2){
                            d++;
                        }
                    if(board[i+1][j-1]==1||board[i+1][j-1]==3){
                            l++;
                        }
                }
                if(i<m-1&&j<n-1){
                    if(board[i+1][j+1]==0||board[i+1][j+1]==2){
                            d++;
                        }
                    if(board[i+1][j+1]==1||board[i+1][j+1]==3){
                            l++;
                        }
                }
                if(i<m-1){
                    if(board[i+1][j]==0||board[i+1][j]==2){
                            d++;
                        }
                    if(board[i+1][j]==1||board[i+1][j]==3){
                            l++;
                        }
                }
                if(board[i][j]==0){
                    if(l==3){
                        board[i][j]=2;
                    }
                }
                if(board[i][j]==1){
                    if(l<2||l>3){
                        board[i][j]=3;
                    }
                }
                d=0;l=0;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
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