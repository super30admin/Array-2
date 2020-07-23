# Time Complexity : O(m*n) where m is the number of rows and n is the number of columns on input board
# Space Complexity: O(1)
# Works on leetcode: Yes
# Approach: Based on given rules, if a cell is 1 and have either <1 or >3 live neighbours, it turns to 0. If is a cell is 0
# and has exactly 3 neighbours, it turns to 1. So we change 0 or 1 with it's number of live neighbous in first iteration.
# And in second iteration, we replace 2 with 1 and 3 with 0.
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m,n = len(board), len(board[0])
        if m==0 or n==0:
            return 
        for ii in range(m):
            for jj in range(n):
                neighbours = sum([board[i][j]%2 for i in range(ii-1,ii+2) for j in range(jj-1,jj+2) if 0<=i<m and 0<=j<n]) - board[ii][jj]
                if board[ii][jj]==0 and neighbours==3:
                    board[ii][jj]=2
                if board[ii][jj]==1 and (neighbours<2 or neighbours>3):
                    board[ii][jj]=3
        for ii in range(m):
            for jj in range(n):
                if board[ii][jj]==2:
                    board[ii][jj]=1
                if board[ii][jj]==3:
                    board[ii][jj]=0
        