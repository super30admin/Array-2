# Time Complexity : O(mn), 
# Space Complexity : o(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def countives(board,r,c):
            dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[-1,-1],[-1,1],[1,-1]]
            count =0
            for di in dirs:
                nr = r+di[0]
                nc= c+di[1]
                if (nr >=0 and nr < m and nc >=0 and nc<n and (board[nr][nc] ==1 or board[nr][nc]==2)):
                    count+=1
            return count
        
        if board==None or len(board)==0: 
            return
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                lives = countives(board, i,j)
             
                if board[i][j]==1:
                    if lives <2 or lives > 3:
                        board[i][j]=2
                        
                else:
                    if lives ==3:
                        board[i][j]=3
        for i in range(m):
            for j in range(n):
                lives = countives(board, i,j)
                if board[i][j]==2:
                    board[i][j]=0
                else:
                    if board[i][j] ==3:
                        board[i][j]=1
                        