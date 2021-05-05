class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
#          0 ----> 1 : 2
#          1-----> 0 : 3

        m = len(board)
        n = len(board[0])
        
        for i in range(0, m):
            for j in range(0, n):
                q = self.findNeighbours(board,m,n,i,j)
                
                if board[i][j] == 0:
                    if q == 3:
                        board[i][j] = 2
                
                else:
                    if q<2 or q>3:
                        board[i][j] = 3
        
        
        for i in range(0,m):
            for j in range(0, n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        
        
    def findNeighbours(self, board: List[List[int]], m: int, n:int, i:int,j:int):
        
        dir = [[1,0],[1,1],[0,1],[-1,1],[-1,0],[-1,-1],[0,-1],[1,-1]]
        counter = 0
        for direction in dir:
            r = i+direction[0]
            c = j+direction[1]
            
            if r>=0 and c>=0 and r<=m-1 and c<=n-1 and (board[r][c]==1 or board[r][c]==3):
                counter+=1

        return counter
    
# Approach is to use state preservation mechanism--this is done here by substituting formerly alive to dead as 2 and the reverse as 3
#  In another iteration, we change back to correct values.
#  More to do with understanding the problem and considering edge cases to avoid runtime errors
#  Time complexity is O(n^2)
