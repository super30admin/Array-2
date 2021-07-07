//(1) means live (0) means dead
//Rules: neighbors n<2 then (1) => (0)
// n=2,3 (1) remains (1)
//n>3 (1) => (0)
//n==3 (0) => (1)
//Time complexity O(MN) where M is number of rows and N no of columns
//Space Complexity O(1)
class Solution {
    //all directions stored in dir
    int[][] dir = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        //iterate over the matrix
        for(int i =0; i< board.length; i++)
        {
            for (int j = 0; j<board[0].length; j++)
            {
                //count of live neighbors
                int l = 0;
                //iterate over the dir check for every neighbor
                for(int[] d:dir)
                {
                    //Checking for the corner cases
                    if(i+d[0] < 0 || i+d[0] >= board.length || j+d[1] < 0 || j+d[1] >= board[0].length)
                        continue;
                    //counting all the live neighbors
                    if(board[i+d[0]][j+d[1]] == 1 || board[i+d[0]][j+d[1]] == 2)
                        l++;
                }
                //case1: when current [i,j] call is live
                if(board[i][j] == 1 && ((l<2)||(l>3)) )
                    board[i][j] = 2; //marking 2 for those cells that changed to dead
                //case2: when current [i,j] call is dead
                if(board[i][j] ==0 && l == 3)
                    board[i][j] = 3; // marking as 3 when dead changes to live
            }
        }
        //Reiterate for final output matrix
        for(int i =0; i< board.length; i++)
        {
            for (int j = 0; j<board[0].length; j++)
            {
                //taking modulo of 2 assigns all 2s to 0 and all 3s to 1
                board[i][j] = board[i][j] % 2;
            }
        }
    }
}