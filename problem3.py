'''https://leetcode.com/problems/game-of-life/

'''

# Time Complexity : O(N*M)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    
    def __init__(self):
        self.m = 0
        self.n = 0
    
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0: return
        
        self.m = len(board)
        self.n = len(board[0])
        
        # cell transition 1 --> 0 : 2
        # cell transition 0 --> 1 : 3
        for i in range(self.m):
            for j in range(self.n):
                countLiveCells = self.getCount(board, i, j)
                if board[i][j] == 1 or board[i][j] == 2: # current cell is live
                    if countLiveCells < 2 or countLiveCells > 3:
                        board[i][j] = 2
                else: # current cell is dead
                    if countLiveCells == 3:
                        board[i][j] = 3
                
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        
        return
    
    
    def getCount(self, board, i, j): # count 1s arround current cell
        dxn = [
            [-1, 0], # up
            [1, 0], # down
            [0, -1], # left
            [0, 1], # right
            [-1, -1], # up left
            [-1, 1], # up right
            [1, -1], # down left
            [1, 1], # down right
        ]
        total = 0
        for d in dxn:
            r = i + d[0]
            c = j + d[1]
            if r >= 0 and r < self.m and c >= 0 and c < self.n and (board[r][c] == 1 or board[r][c] == 2):
                total += 1
        
        return total
            
        