# Time Complexity : O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes  
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach: This code implements Conway’s Game of Life in-place with O(1) extra space. It uses temporary states (2 = live → dead, 3 = dead → live) so that updates don’t interfere with neighbor checks, and a helper function counts live neighbors for each cell. Finally, it iterates again to convert temporary states into the final 0 (dead) or 1 (live), producing the next generation of the board. 


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        #TC: O(m * n)   SC: O(1)
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [(-1, -1), (-1, 0), (-1, 1), (1, -1), (1, 0), (1, 1), (0, -1), (0, 1)]
        m, n = len(board), len(board[0])

        def getCount(i, j):
            count = 0
            for dx, dy in dirs:
                r, c = i + dx, j + dy
                if 0 <= r < m and 0 <= c < n:
                    if board[r][c] == 1 or board[r][c] == 2:
                        count += 1
            
            return count
        
        for i in range(m):
            for j in range(n):
                cnt = getCount(i, j)
                if board[i][j] == 0 and cnt == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and  (cnt < 2 or cnt > 3):
                    board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1