// time  : mn
// space : mn

class Solution {
    public void gameOfLife(int[][] board) {

        int live = 0;
        int dead = 0;

        int [][] dp = new int[board.length][];

        for(int i = 0; i < board.length; i++) dp[i] = board[i].clone();

        for(int i=0 ; i<board.length ; i++)
        {
            for(int j=0 ; j<board[0].length ; j++)
            {
                if(inbounds(i-1,j-1,board))
                {
                    if(dp[i-1][j-1] == 0) dead++;
                    else live++;
                }

                if(inbounds(i-1,j,board))
                {
                    if(dp[i-1][j] == 0) dead++;
                    else live++;
                }

                if(inbounds(i-1,j+1,board))
                {
                    if(dp[i-1][j+1] == 0) dead++;
                    else live++;
                }

                if(inbounds(i,j-1,board))
                {
                    if(dp[i][j-1] == 0) dead++;
                    else live++;
                }

                if(inbounds(i,j+1,board))
                {
                    if(dp[i][j+1] == 0) dead++;
                    else live++;
                }

                if(inbounds(i+1,j-1,board))
                {
                    if(dp[i+1][j-1] == 0) dead++;
                    else live++;
                }

                if(inbounds(i+1,j,board))
                {
                    if(dp[i+1][j] == 0) dead++;
                    else live++;
                }

                if(inbounds(i+1,j+1,board))
                {
                    if(dp[i+1][j+1] == 0) dead++;
                    else live++;
                }

                if(dp[i][j] == 1 && live<2) board[i][j] = 0;

                else if(dp[i][j] == 1 && (live == 2 || live == 3) ) board[i][j] = 1;

                else if(dp[i][j] == 1 && live > 3 ) board[i][j] = 0;

                else if(dp[i][j] == 0 && live == 3) board[i][j] = 1;

                live = 0;
                dead = 0;

            }
        }
    }

    private boolean inbounds(int i , int j , int[][] board )
    {
        return (i>=0 && j>=0 && i<board.length && j<board[0].length);
    }
}
