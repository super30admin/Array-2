''' Time Complexity : O(m * n) 
    Space Complexity : O(1) ; 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Temporary mark hthe change 1 -> 0 : 2 and 0 -> 1 : 3
'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def getLiveCount(board, i , j):
                    # 
            count = 0
            dirs = [(i,j+1),(i,j-1),(i+1,j),(i-1,j),(i -1,j+1),(i+1,j+1),(i+1,j-1),(i-1,j-1)]
            for r, c in dirs:
                if (0<=r<rows and 0<=c<cols and (board[r][c] == 1 or board[r][c] == 2)):
                    count += 1
            return count

        rows, cols = len(board), len(board[0])
        for i in range(rows):
            for j in range(cols):
                count = getLiveCount(board, i , j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif (board[i][j] == 1 and (count < 2 or count > 3)):
                    board[i][j] = 2
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1