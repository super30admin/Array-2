#Time Complexity :  O(mn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    
    def countneighbors(self,board,row,col,m,n):
        count =0
        dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for ele in dirs:
            r = row+ele[0]
            c = col+ele[1]
            if (r<m and r>=0) and (c>=0 and c<n):
                if board[r][c]==1 or board[r][c]==3:
                    count=count+1
        return count
                
                
            
        
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        
        for row in range(0,m):
            for col in range(0,n):
                count = self.countneighbors(board,row,col,m,n)
                if (count<2 or count>3) and (board[row][col]==1):
                    board[row][col] =3
                    
                if (board[row][col]==0) and (count==3):
                    board[row][col]=2
                    
        for row in range(0,m):
            for col in range(0,n):
                if board[row][col]==3:
                    board[row][col]=0
                elif board[row][col]==2:
                    board[row][col]=1
            