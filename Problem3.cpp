// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class Solution {
public:
    bool valid(int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
            return false;
        return true;
    }
    int countLiveNeigh(int i, int j, vector<vector<int>>& b)
    {
        int chi[] = {1, -1, 1, -1, -1, 0, 1,  0};
        int chj[] = {1, -1, -1, 1,  0, 1, 0, -1};
        int liveN = 0;
        for(int ch = 0; ch < 8; ch++) {
            if(valid(i + chi[ch], j + chj[ch], b.size(), b[0].size()) 
               && 
               (b[i+chi[ch]][j + chj[ch]] == 1 || b[i+chi[ch]][j + chj[ch]] == 2)
              )
                liveN += 1;
        }
        
        return liveN;
    }
    
	void gameOfLife(vector<vector<int>>& board) {

        if(!board.size())
            return;
        
        int n = board.size();
        int m = board[0].size();
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                
                int liveN = countLiveNeigh(r, c, board);
                if(board[r][c] == 1 && (liveN < 2 || liveN > 3))
                    board[r][c] = 2; // turn to 0(2)
                
                else if(board[r][c] == 0 && liveN == 3)
                    board[r][c] = -1; // turn to 1(-1)
            }
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(board[r][c] == 2)
                    board[r][c] = 0;
                else if(board[r][c] == -1)
                    board[r][c] = 1;
            }
        }
        
	}
};