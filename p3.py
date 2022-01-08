"""
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



// Time Complexity : O(M*N)
// Space Complexity :(O1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
0,2 are "dead", and "dead->live"
1,3 are "live", and "live->dead"
"""



def gameOfLife(self, board):
    m,n = len(board), len(board[0])
    for i in range(m):
        for j in range(n):
            if board[i][j] == 0 or board[i][j] == 2:
                if self.nnb(board,i,j) == 3:
                    board[i][j] = 2
            else:
                if self.nnb(board,i,j) < 2 or self.nnb(board,i,j) >3:
                    board[i][j] = 3
    for i in range(m):
        for j in range(n):
            if board[i][j] == 2: board[i][j] = 1
            if board[i][j] == 3: board[i][j] = 0
            
def nnb(self, board, i, j):
    m,n = len(board), len(board[0])
    count = 0
    if i-1 >= 0 and j-1 >= 0:   count += board[i-1][j-1]%2
    if i-1 >= 0:                count += board[i-1][j]%2
    if i-1 >= 0 and j+1 < n:    count += board[i-1][j+1]%2
    if j-1 >= 0:                count += board[i][j-1]%2
    if j+1 < n:                 count += board[i][j+1]%2
    if i+1 < m and j-1 >= 0:    count += board[i+1][j-1]%2
    if i+1 < m:                 count += board[i+1][j]%2
    if i+1 < m and j+1 < n:     count += board[i+1][j+1]%2
    return count