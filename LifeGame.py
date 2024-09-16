# Time Complexity : O(M*N) WHERE M is number of rows and N is number of columns
# Space Complexity : O(1)

class Solution(object):
    
    def countlives(self,board,i,j):
            count =0 
            dirs = ((0,1),(0,-1),(-1,0),(1,0),(1,1),(1,-1),(-1,1),(-1,-1))
            for dir in dirs:
                r  = i + dir[0]
                c =  j + dir[1]
                if r >=0 and c>=0 and r <self.m and c <self.n and (board[r][c] ==1 or board[r][c] ==8):
                    count+=1
            return count
    
    
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        #1-->0 ----> 8
        #0-->1 ----> 7
        self.m = len(board)
        self.n = len(board[0])
        
        for i in range(self.m):
            for j in range(self.n):
                livingcount = self.countlives(board,i,j)
                # rule 1 and rule 3
                if board[i][j]==1:
                    if livingcount < 2 or livingcount >3:
                        board[i][j] = 8
                elif livingcount ==3:
                        board[i][j] = 7
        
        for l in range(self.m):
            for k in range(self.n):
                if board[l][k] ==7:
                    board[l][k] =1
                if board[l][k] ==8:
                    board[l][k] =0
        return board
        
        
            
        
        
            