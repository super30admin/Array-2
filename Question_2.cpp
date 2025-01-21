#include <iostream>
#include <vector>
using namespace std;

void gameOfLife(vector<vector<int>>& board) {
    int m = board.size(), n = board[0].size();
    for(int i=0;i<=m-1;i++){
        for(int j=0;j<=n-1;j++){
            vector<int>row_transitions = {1,-1,0,0,1,1,-1,-1};
            vector<int>col_transitions = {0,0,1,-1,1,-1,1,-1};
            int live = 0;
            for(int p =0;p<=7;p++){
                bool is_inbounds = i+row_transitions[p]>=0&&i+row_transitions[p]<=m-1&&j+col_transitions[p]>=0&&j+col_transitions[p]<=n-1;
                if(is_inbounds&&(board[row_transitions[p]+i][col_transitions[p]+j]==1||board[row_transitions[p]+i][col_transitions[p]+j]==3)) live++;
            }
            if(board[i][j]) board[i][j] = (live==2||live==3)?1:3;
            else  board[i][j] = (live==3)?2:0;
        }
    }
    for(int i=0;i<=m-1;i++)
        for(int j=0;j<=n-1;j++)
            board[i][j] = (board[i][j]==2)?1:(board[i][j]==3)?0:board[i][j];
        
    
}

int main(){
    vector<vector<int>> board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    gameOfLife(board);
    for(auto row:board){
        for(auto cell:row) cout<<cell<<" ";
        cout<<endl;
    }
    return 0;
}