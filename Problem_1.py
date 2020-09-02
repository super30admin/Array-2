# 289. Game of Life

# code: 

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or len(board)==0 or len(board[0])==0:
            return
        
        r = len(board)
        c = len(board[0])
        
        for i in range(r):
            for j in range(c):
                aliveCount = self.helper(board, i, j)
                if (board[i][j]==1 and (aliveCount<2 or aliveCount>3)):
                    board[i][j] = 2 
                elif (board[i][j]==0 and (aliveCount==3)):
                    board[i][j] = 4
        
        for i in range(r):
            for j in range(c):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] ==4:
                    board[i][j] = 1
            
    
    def helper(self,board,i, j):
        count = 0
        
        dirs = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[1,1],[-1,1],[1,-1]]
        
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            
            if (r>=0 and r<len(board) and c>=0 and c<len(board[0]) and (board[r][c]==1 or board[r][c]==2)):
                count+=1
        
        
        return count

# Time Complexity: O(n*m)
# Space Complexity: O(1)
# Accepted on Leetcode: YES
# Any problems faced: No.