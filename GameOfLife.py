'''Time Complexity: O(mn)
Space Complexity: O(1)'''

class Solution(object):
    def __countAlive(self,board,i,j):
        count=0
        #No. of rows
        m=len(board) 
        #No. of columns
        n= len(board[0])
        #Direction array
        directions=[[0,1], [0,-1], [1,0], [-1,0], [-1,-1], [-1,1], [1,-1], [1,1]]
        for direction in directions:
            r= direction[0]+i
            c=direction[1]+j
            #check if the r and c index are inbound
            #check if it was originally alive
            if r>=0 and c>=0 and r<m and c<n and (board[r][c] ==1 or board[r][c]==3) :
                count+=1
        return count
                
              
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #No. of rows
        m=len(board) 
        #No. of columns
        n= len(board[0])
        
        if len(board)==0:
            return None
        #0--> 1 ---- 2 and 1-->0 ------ 3
        for i in range(m):
            for j in range(n):
                count=self.__countAlive(board, i, j)
                if board[i][j]==1 and (count<2 or count>3):
                    board[i][j]=3
                elif board[i][j]==0 and count == 3:
                    board[i][j]=2
        
        for i in range(m):
            for j in range(n):
                if board[i][j]==3:
                    board[i][j]=0
                elif board[i][j]==2:
                    board[i][j]=1
        
        return board
