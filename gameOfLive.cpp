// Time Complexity : O(mn) m-> number of rows n-> number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No



class Solution {
    vector<vector<int>> dir = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};
    int m;int n; 
public:
    void gameOfLife(vector<vector<int>>& board) {
                 
        m=board.size();
        n=board[0].size();       
        if(m==0){
            return; // if matrix is null, return
        }
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                int countAlive = count(board,i,j); 
                //cout << countAlive;
                if(board[i][j]==1 && (countAlive<2 || countAlive >3)){  
                    board[i][j]=2; //Make the cells zero
                }else if(board[i][j]==0 && countAlive == 3 ){
                    board[i][j]=3; //Make the cells one
                }
             }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j]=0;   
                }else if(board[i][j] == 3){
                    board[i][j]=1;
                }
            }
        }
        
        
    }
    
    int count(vector<vector<int>>& board, int i, int j){
        int result=0; //Count number of neighbors alive for a given cell
        for(auto ele : dir){
            int r = i + ele[0];
            int c = j + ele[1];    
            if(r >=0 && c>=0 && r <m && r<n && (board[r][c]==2 || board[r][c]==1)){
                result++;
            }        
        }
        return result;
    }

        
};
