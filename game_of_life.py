"""
Approach : if cell is alive add 2 to the cell else do not update. At the end divide matrix by 2. 
What we are doing here is storing informaation about the next state in the second bit of the element.

Space O(1) 
Time O(MN)
"""
class Solution(object):
    
    def get_neighbours(self,r,c,board) :
        live = 0
        for x,y in [(r-1,c-1),(r-1,c),(r-1,c+1),(r,c-1),(r,c+1),(r+1,c-1),(r+1,c),(r+1,c+1)] :
            if (x>=0 and x < len(board)) and (y>=0 and y < len(board[0])) :
                live += (board[x][y] %2)
        return live
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        M = len(board)
        N = len(board[0])
          
        
        for r in range(M):
            for c in range(N) :
                live = self.get_neighbours(r,c,board)
                if ((board[r][c] % 2 == 1) and (live == 2)) or (live == 3)  :
                    board[r][c] +=2                    
                        
        for i in range(M) :
            for j in range(N) :
                board[i][j] /= 2
        
        return board
        
