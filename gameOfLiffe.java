//TC : O(mn) SC : O(1)
class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {

        m = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int liveCount = getLiveNodes(board,i,j);

                if(board[i][j] == 1)
                {
                    if(liveCount < 2 || liveCount > 3)
                        board[i][j] = 2;
                }
                else
                {
                    if(liveCount == 3)
                        board[i][j] = 3;
                }
            }
        }

        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(board[i][j]==2)
                    board[i][j]=0;
                else if(board[i][j]==3)
                    board[i][j]= 1;
            }

        }

    }
    private int getLiveNodes(int[][]board, int r, int c){
        int [][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int count = 0;
        for(int[]dir:dirs){
            int rn = dir[0]+r;
            int cn = dir[1]+c;
            if(rn>=0&&cn>=0&&rn<m&&cn<n){
                if(board[rn][cn]==1||board[rn][cn]==2)
                    count++;
            }
        }
        return count;
    }
}