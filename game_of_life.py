"""
Array-2

Problem3 (https://leetcode.com/problems/game-of-life/)
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.

Time Complexity : O(mxn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Tricks: 
we'll have directions list that has all 8 neighbour directions which will check the count of neighbours and retrun the count.
Now we'll check if board current value is 1 if yes then we check the count if it's alive or dead, if it's dead we change the value to 2 else we leave it as it is.
Now we'll check if board current value is 0 in else condition if yes then we check the count if it's alive then convert the value to 3.
The reason we convert to different numbers is that it doesn't corrupt the actual neighbours count when going through directions.
Finally we loop over the 2d array again and revert the 2 to 0's and 3 to 1's to.  

"""


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def count_live_neighbours(board, i, j):
            count = 0
            dirs = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1,0), (1,1)]
            m,n = len(board), len(board[0])

            for dir in dirs:
                i_dir, j_dir = i+dir[0], j+dir[1]
                if(0 <= i_dir < m and 0 <= j_dir < n and (board[i_dir][j_dir] == 2 or board[i_dir][j_dir] == 1)):
                    count += 1
            return count

        if not board or len(board) == 0:
            return None

        # live - dead : 1 - 2
        # dead - live : 0 - 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                count = count_live_neighbours(board, i, j)
                if board[i][j] == 1: 
                    if count < 2 or count > 3: # live to dead
                        board[i][j] = 2
                else:
                    if count == 3: # dead cell to live
                        board[i][j] = 3
      
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1

                elif board[i][j] == 2:
                    board[i][j] = 0
                        