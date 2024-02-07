// 289. Game of Life
// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

/* 
    traversing through the board and checking the count of alive in all the directions and changing the current element dead or alive based
    on the conditions given ( 1 -> 0 = -1) (0 -> 1 = -2) for optimising the space to constant.

*/


// Your code here along with comments explaining your approach

void gameOfLife(vector<vector<int>>& board) {
    int m = board.size(), n = board[0].size(), c = 0;
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            c = countAlive(board,i,j,m,n);
            if(board[i][j] == 1 && (c > 3 || c < 2))
                board[i][j] = -1;
            if(board[i][j] == 0 && (c == 3))
                board[i][j] = -2;
        }
    }
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(board[i][j] == -1)
                board[i][j] = 0;
            if(board[i][j] == -2)
                board[i][j] = 1;
        }
    } 
    return;
}
int countAlive(vector<vector<int>>& board, int i, int j, int m, int n)
{
    int count = 0;
    if(0 <= i+1 && i+1< m && 0 <= j && j < n)
    {
        if(abs(board[i+1][j]) == 1)
            count++;
    }
    if(0 <= i-1 && i-1< m && 0 <= j && j < n)
    {
        if(abs(board[i-1][j]) == 1)
            count++;
    }
    if(0 <= i && i< m && 0 <= j+1 && j+1 < n)
    {
        if(abs(board[i][j+1]) == 1)
            count++;
    }
    if(0 <= i && i< m && 0 <= j-1 && j-1 < n)
    {
        if(abs(board[i][j-1]) == 1)
            count++;
    }
    if(0 <= i+1 && i+1< m && 0 <= j+1 && j+1 < n)
    {
        if(abs(board[i+1][j+1]) == 1)
            count++;
    }
    if(0 <= i-1 && i-1< m && 0 <= j-1 && j-1 < n)
    {
        if(abs(board[i-1][j-1]) == 1)
            count++;
    }
    if(0 <= i-1 && i-1< m && 0 <= j+1 && j+1 < n)
    {
        if(abs(board[i-1][j+1]) == 1)
            count++;
    }
    if(0 <= i+1 && i+1< m && 0 <= j-1 && j-1 < n)
    {
        if(abs(board[i+1][j-1]) == 1)
            count++;
    }
    return count;

}

