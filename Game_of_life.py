# Time Complexity : O(m* n)
# Space complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Instead of immediate flipping, cells transitioning from 0 to 1 are marked as 2, and cells moving from 1 to 0 are marked as 3.
# When counting neighbors, both 1 (current alive) and 3 (was alive, now dying) are treated as active cells to maintain originality.
# A second pass iterates through the grid to convert all 2s back to 1s and 3s back to 0s.

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 0 -> 1 : 2
        # 1 -> 0 : 3

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countAlive(board, i, j,m,n)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2
                
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0

    def countAlive(self, board,i,j,m,n):
        count = 0
        direction = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1) ]   
        for dr, dc in direction:
            r,c = i + dr, j + dc
            if 0 <= r < m and 0 <= c < n and board[r][c] in [1,3]:
                count += 1
        return count