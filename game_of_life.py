// Time Complexity : O(n*m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Tarverse through array and change states in-place using 
// 2 and 3 for state changes.

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        
        # 2 -> alive -> dead
        # 3 -> dead -> alive
        
        m=len(board)
        n=len(board[0])
        
        for i in range(len(board)):
            for j in range(len(board[i])):
                
                count= self.countLives(board,i,j,m,n)
                
                if( board[i][j]==1):
                    
                    if(count<2 or count>3):
                        board[i][j]=2
                else:
                    if(count==3):
                        board[i][j]=3
        
        for i in range(m):
            for j in range(n):
                if(board[i][j]==2):
                    board[i][j]=0
                if(board[i][j]==3):
                    board[i][j]=1
        return(board)
    def countLives(self,board,i,j,m,n):
        
        dir=[[-1,0],[-1,-1],[0,-1],[1,-1],[1,0],[1,1],[0,1],[-1,1]]
        count=0
        for d in dir:
            
            r=i+d[0]
            c=j+d[1]
            
            if(r>=0 and r<m and c>=0 and c<n and (board[r][c] ==1 or board[r][c] ==2)):
                count+=1
        return(count)
        
        
        