# https://leetcode.com/problems/game-of-life/
# Time O(mxn) : Traverse over board of m x n
# Space O(1) : We modify the original board 

class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        dirs = [[-1,0], [0,-1], [0,1], [1,0], [-1,-1], [1,1], [1,-1], [-1, 1]]
        m,n = len(board), len(board[0]) 
        for i in range(m):
            for j in range(n):
                count1 = 0
                
                for d in dirs:
                    r, c = i+d[0], j+d[1]
                    if r >= 0 and r <m and c>=0 and c<n and board[r][c] > 0:
                        count1 += 1
                
                if board[i][j]: # if board[i][j] == 1
                    if count1 < 2 or count1 > 3:
                        board[i][j] = 2
                else: # if board[i][j] == 0
                    if count1 == 3:
                        board[i][j] = -1
        
        # reset to modified 0/1               
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0


board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
s = Solution()
output = s.gameOfLife(board)
print(board)