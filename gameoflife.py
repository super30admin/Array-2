#Time Complexity: O(mn) m-> rows, n->columns
#space complexity : O(1) as we are mutating the same array
#did your code run on leetcode : yes

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if board == [[]]: return
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                countAlive = self.countAllAlive(board,i,j,m,n)
                #change current dead to alive 0-> 1 (2)
                if (board[i][j] == 0 and countAlive == 3 ):
                    board[i][j] = 2
                #change current alive to dead 1-> 0 (3)
                if(board[i][j] == 1 and (countAlive < 2 or countAlive > 3) ):
                    board[i][j] = 3
                    
        for i in range(m):
            for j in range(n):
                if (board[i][j] == 2 ) : board[i][j] = 1
                if (board[i][j] == 3 ) : board[i][j] = 0
        
        
    def countAllAlive(self, board: List[List[int]],i:int,j:int,m:int,n:int)->int:
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
        result = 0
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if r >= 0 and r < m and c >= 0 and c < n and (board[r][c] == 3 or board[r][c] == 1):
                result += 1
                
        return result
    
    
#Can you further optimize the code if the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border).

#Solution : Lets take example that board has 10k rows and 10k cols. First I going to divide the board of 10k by 10k into smaller boards of 100 rows and 100 cols. Only consider those boards of 100 by 100 where you have alive cells and perform all the operations on alive cell only
    
        


                    
        


