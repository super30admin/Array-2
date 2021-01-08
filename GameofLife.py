# // Time Complexity :O(nxm) 
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if(board==[]):
            return
        #0 -> 1 3
        #1 -> 0 2
        n=len(board)
        m=len(board[0])
        for i in range(n):
            for j in range(m):
                count=self.countalive(board,i,j)
                if(board[i][j]==1 and (count<2 or count>3)):
                    board[i][j]=2
                if(board[i][j]==0 and count==3):
                    board[i][j]=3
        for i in range(n):
            for j in range(m):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==3):
                    board[i][j]=1
        
        
    def countalive(self,board,i,j):
        direct=[[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[1,1],[-1,1],[1,-1]]
        count=0
        for d in direct:
            r=i+d[0]
            c=j+d[1]
            if(r>=0 and c>=0 and r<len(board)and c<len(board[0]) and (board[r][c]==2 or board[r][c]==1)):
                count=count+1
    
                
        return count
                    
                    
        
                
    