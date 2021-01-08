#Time Complexity :O(m*n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if(board==None or len(board)==0):
            return []
        
        m=len(board) 
        n=len(board[0])
        
        for i in range(m):
            for j in range(n):
                count=self.getLive(board,i,j,m,n)
                #Rule 1 and 3
                if(board[i][j]==1 and (count<2 or count>3)):
                    board[i][j]=2
                #Rule 4
                if(board[i][j]==0 and count==3):
                    board[i][j]=3
        
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==3):
                    board[i][j]=1
    
    
    def getLive(self,board,i,j,m,n):
        dire=[[0,1],[0,-1],[1,0],[-1,0],[-1,1],[-1,-1],[1,-1],[1,1]]
        count=0
        for k in dire:
            r=i+k[0]
            c=j+k[1]
            if(r>=0 and c>=0 and r<m and c<n and (board[r][c]==1 or board[r][c]==2)):
                count+=1
        return count
            
        
        
        
                    
        