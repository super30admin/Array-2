# Time Complexity : O(M*N)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def getState(self,board,i,j,m,n):
        dir = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        res = 0
        for d in dir:
            r = i+d[0]
            c = j+d[1]
        
            if (r>=0 and r<m and c>=0 and c<n and (board[r][c]==1 or board[r][c]==2)):
                res+=1
        return res
            
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board)==0:
            return
        #alive 1->0->2
        #ded 0->1->3
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                c = self.getState(board,i,j,m,n)
                
                if board[i][j]==1:
                    if c<2 or c>3:
                        board[i][j]=2
                elif board[i][j]==0:
                    if c==3:
                        board[i][j]=3
                        
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
        
        return board  

b = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
obj = Solution()
print(obj.gameOfLife(b))                
            
        
        