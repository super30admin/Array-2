#game of life
# time complexity : 0(mn)
#space complexity :0(1)
#Did this code successfully run on Leetcode :yes

# 1-> 0 : 2
# 0-> 1 : 3

class Solution(object):
    def count_live_cells(self,board,i,j,m,n):
        
        dr = [0,-1,-1,1,0,1,1,-1]
        dc = [-1,-1,0,-1,1,1,0,1]
        count = 0
        for k in range(8):
            if i + dr[k] >= 0 and i+dr[k] < m and j +dc[k] >=0 and j +dc[k]<n:
                if board[i+dr[k]][j+dc[k]] == 1 or board[i+dr[k]][j+dc[k]] == 2:
                    count = count +1
                    
        return count
        
        
    def gameOfLife(self, board):
        
        m = len(board)
        n = len(board[0])
        
        
       
    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 1:
                    count = self.count_live_cells(board,i,j,m,n)
                    if count < 2 :
                        board[i][j] = 2
                    elif count > 3:
                        board[i][j] = 2
                else:
                    count  = self.count_live_cells(board,i,j,m,n)
                    if count == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
                    
        return board
                    
                
                
                

                
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        