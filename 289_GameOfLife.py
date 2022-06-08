"""
Leetcode - https://leetcode.com/problems/game-of-life/ (submitted)
TC- O(m*n) , SC- O(1)
Lecture- https://youtu.be/gfbrKPooo2w
FAQ-
How would you generalize finding neighbors if we change it to only 4 directions instead of 8? Use directions array
and add/remove from it (refer code)
Using extra space? Save new state in new 2D array with same size as the input
If the board is infinite? Use the sliding window (using lCol, rCol index) for the size of m*n as run this same algorithm

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births
and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells
first and then use their updated values to update other cells.

In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause
problems when the active area encroaches upon the border of the array (i.e., live cells reach the border).
How would you address these issues?
"""

'''
Idea - for inplace replacement, we cannot put the new state of a cell in it's place directly since we will lose it's
original state which will help determine next state for other elements. To solve this problem, we use labels '-2' for
cells who were initially dead and change it's state to alive. In other words, -2: 0 -> 1.
Similarly, we use label '2' for cells who were initially alive and change it's state to dead, ie. 2: 1 -> 0
'''


class Solution:
    def __init__(self):
        self.m = None
        self.n = None
        # 8 directions - top left, top, top right, left, right, bottom left, bottom, bottom right
        self.dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]

    # TC- O(8*m*n) = O(m*n), SC- O(1)
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None:
            return board

        self.m = len(board)
        self.n = len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                # considering only rules that change the state of the cell. Also using custom labels to restore
                # it's original state.
                if board[i][j] == 1 and (self.getAliveNeighbors(self.dirs, board, i, j) < 2
                                         or self.getAliveNeighbors(self.dirs, board, i, j) > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and self.getAliveNeighbors(self.dirs, board, i, j) == 3:
                    board[i][j] = -2
                # else there will be no change in the state

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == -2:
                    board[i][j] = 1

    def getAliveNeighbors(self, dirs, board, i, j):
        aliveNeighborsCount = 0
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            # if the neighbor is greater than 0, it's state was alive.
            if 0 <= nr < self.m and 0 <= nc < self.n and board[nr][nc] > 0:
                aliveNeighborsCount += 1

        return aliveNeighborsCount


board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
Solution().gameOfLife(board)
print('Next state of the board: ', board)
expected = [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]
print('expected: ', expected)
