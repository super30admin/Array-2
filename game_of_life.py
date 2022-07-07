# time complexity: O(mn)
# space complexity: O(1)
# Approach: replace changing 1 to 0 with 2 and 0 to 1 with 3( any number)
# count the neighbours with value 1 and 2.
# do as said in the question

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = self.countNeighbours(board,i,j)
                if board[i][j] == 1:
                    if count < 2:
                        board[i][j] = 2
                    elif count > 3:
                        board[i][j] = 2
                else:
                    if count == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
                    
            
        
    def countNeighbours(self,board,row,col):
        m = len(board)
        n = len(board[0])
        count = 0
        dirs = [[-1,0],[0,1],[1,0],[0,-1],[-1,-1],[-1,1],[1,1],[1,-1]]
        for dir in dirs:
            newrow = row + dir[0]
            newcol = col + dir[1]
            if(newrow >=0 and newrow <m and newcol >=0 and newcol <n and (board[newrow][newcol] == 1 or board[newrow][newcol] == 2)):
                count = count+1
        return count
                    
        
        