class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        

        int row = board.size();
        int col = board[0].size();
        int count_live_1;


        
 
        for(int i=0; i<row ; i++){
            for(int j=0;j<col;j++){

                 count_live_1 = count_live(board,i,j,row,col);
                if(board[i][j] == 1){
                    if(count_live_1<2 || count_live_1>3){
                        board[i][j] = 2;
                        }
                }
                       
                else{
                        if(count_live_1 == 3){
                            board[i][j] = 3;
                        }
                    }
                
            }
        }

       for(int i=0; i<row ; i++){
            for(int j=0;j<col;j++){

                if(board[i][j]==2){
                    board[i][j] = 0;
                }
                if(board[i][j]==3){
                    board[i][j] = 1;
                }
                
            }
       }

    }


    int count_live(vector<vector<int>> board,int i,int j,int row,int col){
        int count = 0;
        vector<vector<int>> dir = {{0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
       for(vector<int> k:dir){
            int r = i + k[0];
            int c = j + k[1];

            if(r>=0 && c>=0 && r<row && c<col && (board[r][c]==1 || board[r][c] ==2)){
                count++;
            }
       }
        return count;

    }
};