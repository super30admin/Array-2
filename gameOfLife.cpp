// Time Complexity :O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
        int countLiveNeighbors(vector<vector<int>>& board, int i , int j){
            int m = board.size();
            int n = board[0].size();
            int count=0;
            //using dirs array for all 8 neighbors of cell
            int dirs[8][2]= {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};

            //computing neighbors location for every cell using dirs array
            for(int k=0; k<8; k++){
                int nr = i+dirs[k][0];
                int nc = j+dirs[k][1];
            //counting live neighbors
                if(nr>=0&& nr<m && nc>=0 && nc<n &&(board[nr][nc] ==1 || board[nr][nc] ==2)){
                    count++;
                }
            }
            return count;
        }
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();

        //keeping track of count of live neighbors needed to make dead to alive or
        //alive to dead
        int liveNeighbors=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int liveNeighbors = countLiveNeighbors(board, i ,j);
                
                //1->0 : use 2 (live to dead)
                //0->1 : use 3 (dead to live)
                //check if alive then see neighnors count to get dead
                if(board[i][j] ==1){
                    if(liveNeighbors <2 || liveNeighbors >3){
                        board[i][j] =2;
                    }
                }
                //check if dead then see neighnors count to become alive
                else if(board[i][j] ==0){
                    if(liveNeighbors ==3){
                        board[i][j] =3;
                    }
                }
            }        
        }
        //transforming board to 1s and 0s state
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] =0;
                }
                else if(board[i][j] == 3){
                    board[i][j] =1;
                }
            }
        }
        
    }
};
