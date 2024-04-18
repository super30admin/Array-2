# Array-2
## Problem3 (https://leetcode.com/problems/game-of-life/)

# Approach
# Traverse through the matrix. For every index, check its corresponding 8 elements. Based on the condition given in the question, if 0 is surrounded by 3 1's, change its value to 3.
# Similary, if 1 is surrounded by less than 2 1's or greater than 3 1's, change its value to 2. Create a new function to check the sum of neighboring elements. 
# In countlives function, if row and column are within range and neighboring elements value is 1 0r 2, increment count. Once done, traverse through the entire matrix again, if value is 2 set it to 0 and if value 3 set it to 1

# Time Complexity: O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0:
            return
        
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                cnt = self.countlives(board, i,j,m,n)
                if board[i][j] == 1 and (cnt < 2 or cnt > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and (cnt == 3):
                    board[i][j] = 3
            
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    
    def countlives(self, board, i, j, m ,n):
        res = 0
        dir = [[0,1],[1,0],[-1,0],[0,-1],[1,1],[-1,-1],[1,-1],[-1,1]]
        for x in dir:
            r = i + x[0]
            c = j + x[1]
            if (r >= 0 and r <m and c <n and c >= 0 and (board[r][c] == 1 or board[r][c] == 2)):
                res += 1
        return res