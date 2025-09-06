# (https://leetcode.com/problems/game-of-life/)

# m -- no. of rows
# n -- no. of cols
# Time Complexity : O(8 * (m * n)) = O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we are using the concept of temporary state change. Since we only have current states as 1 for alive and 0 for dead, we 
# use another state 2 to mark the state change of (1 -> 0) and use another state 3 to mark the state change of (0 -> 1). In this way, even
# if update the state of a cell, we would know whether it was originally dead or alive. 

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        # method to count all alive cells among its neighbors
        def getAliveCells(row, col, board):
            liveCount = 0
            directions = [(0, -1), (-1, 0), (0, 1), (1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]
            for dr, dc in directions:
                # new row, col
                nr = row + dr
                nc = col + dc

                # check bounds of nr and nc
                if((0 <= nr < len(board)) and (0 <= nc < len(board[0]))):
                    if(board[nr][nc] == 1 or board[nr][nc] == 2):
                        # the neigh state was 1, it was an active cell
                        liveCount += 1

            return liveCount



        # for state change 1 -> 0, keeping temp state of 2
        # for state change 0 -> 1, keeping temp state of 3
        for i in range(rows):
            for j in range(cols):
                # for every element check all the live cells among its 8 neighbors
                aliveNeigh = getAliveCells(i, j, board)
                if(board[i][j] == 1):
                    # the original state of cell at (row, col) = 1, active
                    if(aliveNeigh < 2 or aliveNeigh > 3):
                        # make the cell dead, mark it with state 2
                        board[i][j] = 2
                elif(board[i][j] == 0):
                    # the original state of cell at (row, col) = 1, dead
                    if(aliveNeigh == 3):
                        # make the dead cell active
                        # mark the state as 3
                        board[i][j] = 3

        # make the matrix to updated state
        for i in range(rows):
            for j in range(cols):
                if(board[i][j] == 2):
                    # cell is now dead
                    board[i][j] = 0

                elif(board[i][j] == 3):
                    # cell is now active
                    board[i][j] = 1

sol = Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
sol.gameOfLife(board)
print(board)
board = [[1,1],[1,0]]
sol.gameOfLife(board)
print(board)

board = [[0]]
sol.gameOfLife(board)
print(board)

                