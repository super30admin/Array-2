"""
Time Complexity : O(m*n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        # Changing the matrix according to the rules as:
        # 1 -> 0 = 2
        # 0 -> 1 = 3
        for i in range(m):
            for j in range(n):
                count = self.countLives(board, i, j, m, n)
                # Rule 1 & 3
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                # Rule 4
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        # Changing the matrix back to its original form
        # Changing all the 2,3 to their original nos.
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    # Function to count lives for the neighbours
    def countLives(self, board: List[List[int]], i: int, j: int, m: int, n: int):
        dirs = [(1,0), (0,1), (-1,-1), (-1,1), (1,-1), (0,-1), (-1,0), (1,1)]
        result = 0
        r, c = 0, 0
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            if (r>=0 and r < m) and (c>=0 and c<n) and (board[r][c] == 1 or board[r]                    [c]==2):
                result += 1
        return result