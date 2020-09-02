//  289_Game_Of_Life

//In Place
//using direction array
//TC:O(N*M)
//SC:O(1)

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        //change 1->0 ->-1 (any value)
        //change 0->1 ->2 (any value)
        
        int N=board.size(), M=board[0].size();
        
         for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                //get alive neighbours count
                int alive=getAliveNeighbours(board,r,c,N,M);
                //cout<<alive<<endl;
                //apply rules
                if(board[r][c] == 1 && (alive < 2 || alive > 3))  board[r][c] = -1;
                   
                if(board[r][c] == 0 && alive == 3) board[r][c] = 2;
            }
        }
        
        //revert all 2 to 0 and 4 to 1
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(board[r][c] == 2) board[r][c] = 1;
                else if(board[r][c] == -1) board[r][c] = 0;
            }
        }
        
        
    }
    
    /*
        [0,1,0]
        [0,0,1]
        [1,1,1]
        [0,0,0]

    */
    
    int getAliveNeighbours(vector<vector<int>> board,int r, int c, int N, int M){
        //all neighbours {row,col}
        vector<vector<int>> directionArray={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int ones=0;

        for(vector<int> dir:directionArray){
            //get neighbour index
            int row = r + dir[0];
            int col = c + dir[1];

            //check boundry conditions
            //change 1->0 ->-1 (any value)
            //change 0->1 ->2 (any value)
            if(row >= 0  &&  row < N  &&  col >= 0  &&  col < M){
                if(board[row][col] == 1  ||  board[row][col] == -1)
                    ones++;
            }
        }
        return ones;
    }
};


int main(int argc, const char * argv[]) {
    vector<vector<int>> board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    Solution s;
    s.gameOfLife(board);
    for(int r = 0; r < board.size(); r ++){
        for(int c = 0; c < board[0].size(); c ++){
            cout<<board[r][c]<<"\t";
        }
        cout<<endl;
    }
    cout<<endl;
    return 0;
}
