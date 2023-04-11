class Solution {
    // TC - O(n^2)
    // SC - S(1)
public:
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        int n = board[0].size();
        int count =0;

        for(int i =0; i<m;i++){
            for(int j =0; j<n;j++){
                count =0;
                if(i-1>=0 && j-1>=0){
                    if(board[i-1][j-1]>0){
                        count++;
                    }
                }
                if(i-1>=0 && j>=0){
                    if(board[i-1][j]>0){
                        count++;
                    }
                }    
                if(i-1>=0 && j+1<n){
                    if(board[i-1][j+1]>0){
                        count++;
                    } 
                }    
                if(i>=0 && j-1>=0){
                    if(board[i][j-1]>0){
                        count++;
                    }      
                }    
                if(i>=0 && j+1<n){
                    if(board[i][j+1]>0){
                        count++;
                    }    
                }    
                if(i+1<m && j>=0){
                    if(board[i+1][j]>0){
                        count++;
                    }  
                }    
                if(i+1<m && j-1>=0){
                    if(board[i+1][j-1]>0){
                        count++;
                    }    
                }
                if(i+1<m && j+1<n){
                    if(board[i+1][j+1]>0){
                        count++;
                    }
                }
                if(count<2){
                    if(board[i][j] == 1){ // under population
                       board[i][j] =2; 
                    }
                }
                if(count == 3){
                    if(board[i][j] == 0){ // reproduction
                       board[i][j] =-1; 
                    }
                }
                 if(count > 3){
                    if(board[i][j] == 1){ // over-population
                       board[i][j] =2; 
                    }
                }
            }
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }
        
    }
};