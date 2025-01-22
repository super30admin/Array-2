"""

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. 
In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.


Example 1:

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Time Complexity : O(M*N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach uses in-place modification by encoding state transitions with additional values (2 and 3) to track live and dead cells without extra space.  
# First, iterated through the board, counting live neighbors and marking cells based on the rules of the game.  
# Finally, updated the board by converting marked states back to their final values.  


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        
    #   original |  new      |   state
    #       0    |      0    |     0
    #       1    |      0    |     1
    #       0    |      1    |     2  (in case of exactly 3)
    #       1    |      1    |     3  (in case of [2 or 3])

        r, c = len(board), len(board[0])

        def countNeighbor(m, n):
            nei = 0
            for i in range(m-1, m+2):
                for j in range(n-1, n+2):
                    
                    if ((i == m and j == n) or i < 0 or j < 0 or i == r or j == c):
                        continue
                    if board[i][j] in [1, 3]:
                        nei += 1
            return nei

        for i in range(r):
            for j in range(c):
                nei = countNeighbor(i, j)
                if board[i][j]:
                    if nei in [2, 3]:
                        board[i][j] = 3
                elif nei == 3:
                    board[i][j] = 2

        for i in range(r):
            for j in range(c):
                if board[i][j] in [2, 3]:
                    board[i][j] = 1
                elif board[i][j] == 1:
                    board[i][j] = 0
