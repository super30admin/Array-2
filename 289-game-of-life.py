
"""
289. Game of Life
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 
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

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?


"""

class Solution:
    """
    Accepted
    Time Complexity: O(m*n)
    Space Complexity: O(1)

    Approach:
    - Use a helper function `countNebs` to count live neighbors for each cell.
    - Iterate over each cell:
        - Mark dead cells with three live neighbors as -1 (will become alive).
        - Mark live cells with less than two or more than three live neighbors as -2 (will die).
    - Iterate over the board again to update each cell's state:
        - Change -1 to 1 (dead to alive).
        - Change -2 to 0 (alive to dead).
    - Use -1 and -2 to track a cell's previous state while calculating the next state.
    
    """
    def gameOfLife(self, board: List[List[int]]) -> None:
        def countNebs(board, i: int, j: int) -> int:
            nebs = 0
            dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
            for dir in dirs:
                if (i + dir[0]) < m and i + dir[0] >=0 and (j + dir[1]) < n and (j + dir[1]) >=0:
                    tgt = board[i + dir[0]][j + dir[1]]
                    if tgt == 1 or tgt == -2:
                        nebs += 1
            return nebs

            
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                nebs = countNebs(board, i, j)
                if board[i][j] == 0 and nebs == 3:
                    board[i][j] = -1
                if board[i][j] == 1 and (nebs < 2 or nebs >3):
                    board[i][j] = -2
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 1
                if board[i][j] == -2:
                    board[i][j] = 0

LeetCode(PROBLEM, Solution).check()
