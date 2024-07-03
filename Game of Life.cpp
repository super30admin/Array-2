// as discussed in class
// time: O(m*n)
// space: O(1)
class Solution {
private:
    int countAlives(vector<vector<int>>& board, int r, int c, int m, int n) {
        int count = 0;
        vector<vector<int>> dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(int i = 0; i < dirs.size(); i++) {
            //cout<<i;
            if((r + dirs[i][0]) < m && (c + dirs[i][1]) < n && (r + dirs[i][0]) >= 0 && (c + dirs[i][1]) >= 0) {    
                if(board[r + dirs[i][0]][c + dirs[i][1]] == 1 || board[r + dirs[i][0]][c + dirs[i][1]] == 3) {
                    count++;
                    cout<<i<<endl;
                }
            }
        }
        return count;
    }
public:
    void gameOfLife(vector<vector<int>>& board) {
        // 1 -> 0 = 3
        // 0 -> 1 = 4
        int m = board.size();
        int n = board[0].size();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int alives = countAlives(board, i, j, m, n);
                cout<<i<<" "<<j<<" "<<alives<<endl;
                if(board[i][j] == 1) {
                    
                    if(alives < 2 || alives > 3) {
                        board[i][j] = 3;
                        //cout<<i<<" "<<j<<endl;
                    }
                } else {
                    if(alives == 3) {
                        board[i][j] = 4;
                        //cout<<i<<" "<<j<<endl;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 3) {
                    board[i][j] = 0;
                }
                else if(board[i][j] == 4) {
                    board[i][j] = 1;
                }
            }
        }
    }
};