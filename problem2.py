#Time complexity O(n^2) and space complexity O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
#Considering the below values for the conditions
        # 0->1=3
        # 1->0=4
        
        rows=len(board)
        cols=len(board[0])
#Traversing loops and assigning the values depending on the conditions
        for r in range(rows):
            for c in range(cols):
                
                livingcells=self.count(board,r,c)
                
                if board[r][c]==1:
                    if livingcells >3 or livingcells <2:
                        board[r][c]=4
                        
                else:
                    
                    if livingcells == 3:
                        board[r][c]=3
                        
#Converting the values back to zeros and ones                       
        for r in range(rows):
            for c in range(cols):
                
                if board[r][c]==3:
                    board[r][c]=1
                elif board[r][c]==4:
                    board[r][c]=0
 
#Function for counting the living cells
    def count(self,board,r,c):
        
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        rows = len(board)
        cols = len(board[0])
        living=0
        
        for i in neighbors:
            nr=(r+i[0])
            nc=(c+i[1])
            
            if nr>=0 and nr<rows and nc>=0 and nc<cols:
                if board[nr][nc]==1 or board[nr][nc]==4:
                    
                    living+=1
                
        return living
