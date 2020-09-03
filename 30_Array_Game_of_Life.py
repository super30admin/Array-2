#Time Complexity : O(n*m) where n is the number of rows and m is the number of columns
#Space Complexity : O(1) //In place we are doing, just encoding, decoding 0->1: 2 and 1>0: 4
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def countliv(board,rows,cols,i,j): 
            neighbors=[(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
            count=0
            for n in neighbors: 
                r=i+n[0]
                c=j+n[1]
                
                if r>=0 and r<rows and c>=0 and c<cols and (board[r][c]==1 or board[r][c]==4):
                    count+=1
            return count
        
        rows=len(board)
        cols=len(board[0])
        
        for i in range(rows): 
            for j in range(cols): 
                alive=countliv(board,rows,cols,i,j)
                if board[i][j]==1 and (alive<2 or alive>3): 
                    board[i][j]=4
                elif board[i][j]==0 and alive==3: 
                    board[i][j]=2
        
        for i in range(rows): 
            for j in range(cols): 
                if board[i][j]==4: 
                    board[i][j]=0 
                elif board[i][j]==2: 
                    board[i][j]=1
                