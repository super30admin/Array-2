# Time Complexity : O(N*M)
# Space Complexity : O(1)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using the directions array to check all 8 possible neighbors of each cell in the board.
# I have a function counter to count the number of live neighbors for a given cell. I iterate through each cell in the board and apply the rules of the Game of Life.
# If a live cell has fewer than two live neighbors or more than three live neighbors it has died I mark it as 2.
# If a dead cell has exactly three live neighbors, it becomes a live cell and I mark it as 3.
# Finally, I iterate through the board again to update the cells to their new states: 2 becomes 0  and 3 becomes 1.

from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board)
        m = len(board[0])
        directions = [(1,0),(0,1),(-1,0),(0,-1),(1,1),(1,-1),(-1,-1),(-1,1)]
        def counter(r,c):
            count = 0
            for dr,dc in directions:
                nr = r +dr
                nc = c +dc
                if 0<= nr < n and 0 <= nc < m:
                    if board[nr][nc] == 1 or board[nr][nc] == 2:
                        count += 1
            return count
        for i in range(n):
            for j in range(m):
                count = counter(i,j)
                if board[i][j] == 1  and ( count < 2 or count >3):
                    board[i][j] = 2
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 3 
        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

        