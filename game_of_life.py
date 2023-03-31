# Time Complexity : O(m*n) because we are iterating through the matrix
# Space Complexity : O(1) because we are not using any extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
In this code we simply look at the neighbours to solve the game of life problem. To do it inplace we just use extra numbers 2 and 3.
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        if board == None or len(board) == 0:
            return

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                liveCount = self.getLiveCount(board, i, j)
                
                # if alive
                if board[i][j] == 1:
                    if liveCount < 2 or liveCount > 3:
                        board[i][j] = 2
                else:
                    if liveCount == 3:
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

    
    def getLiveCount(self, board, row ,column):
        count = 0

        direction = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]

        for direc in direction:
            nr = row + direc[0]
            nc = column + direc[1]

            if nr >= 0 and nr < len(board) and nc >= 0 and nc < len(board[0]):
                if (board[nr][nc] == 1 or board[nr][nc] == 2):
                    count += 1

        return count

            

