//TC: O(8mn) where m is the number of rows and n is the number of columns 
//SC: O(1) since no space is being used. 

class Solution {
    
    int countAlive(vector<vector<int>>& board, int r, int c, int m, int n){
        //set some directions to make it easier to iterate over
        vector<pair<int, int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1} };
        int count = 0;
        
        for(int i=0; i<dirs.size(); i++){
            int rval = r+dirs[i].first;
            int cval = c+dirs[i].second;
            
            //check if the coordinates are valid and if the neighboring cell is 1 or was previously one.
            if(rval >= 0 && rval<m && cval>=0 && cval<n && (board[rval][cval] == 1 || board[rval][cval] == 2))
                count++;
        }
        
        return count;
        
        
    }
    
public:
    //can be done by setting dying(1 to 0) cells as 2 and cells becoming live(0 to 1) as 3. Then we carry out the checks for living or dead. 
    //If <2 live, then dies ; if >3 live, then dies, if ==3 live then becomes alive.
    
    void gameOfLife(vector<vector<int>>& board) {     
        
        int m = board.size();
        int n = board[0].size();
        
        //check for the rules. Extremely important that we also check for the current state of the board as well as rules.
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                int alives = countAlive(board, r,c, m, n);
                //IMPORTANT HERE |
                if(board[r][c] == 1 && (alives < 2 || alives > 3))
                    board[r][c] = 2;
                else if(board[r][c] == 0 && (alives== 3))
                    board[r][c] = 3;                
            }
            
        }
        
         //revert back to 1s and 0s.
         for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(board[r][c] == 3)
                    board[r][c] = 1;
                else if(board[r][c] == 2)
                    board[r][c] = 0;
            }
         }
        
        
        
        
    }
};