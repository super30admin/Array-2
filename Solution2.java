/*
    Time Complexity : O(rows * columns);
    Space Complexity : O(1)
*/
class Solution {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int count = find(i, j, board);
                if(board[i][j] == 1){
                    if(count < 2)
                        board[i][j] = -1;
                    else if(count > 3)
                        board[i][j] = -1;
                }else{
                    if(count == 3)
                        board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    public int find(int i, int j, int[][] board){
        int ans = 0;
        if(i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1))
            ans++;
        if(i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1))
            ans++;
        if(i - 1 >= 0 && j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1))
            ans++;
        if(j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == -1))
            ans++;
        if(i + 1 < board.length && j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1))
            ans++;
        if(i + 1 < board.length && (board[i + 1][j] == 1 || board[i + 1][j] == -1))
            ans++;
        if(i + 1 <  board.length && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1))
            ans++;
        if(j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1))
            ans++;
        return ans;
    }
}
