class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """1->0...2
            0->1....3"""
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.helper(board, i, j)
                if (count<2 or count>3) and board[i][j]==1:
                    board[i][j] = 2
                elif count==3 and board[i][j]==0:
                    board[i][j]=3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
                else:
                    pass
    def helper(self, board, i, j):
        dirs = [[0,1], [-1,0],[1,0],[0,-1],[-1,1],[1,1],[1,-1],[-1,-1]]
        result=0
        for dir in dirs:
            row = i+dir[0]
            col = j+dir[1]
            if row<=len(board)-1 and row>=0 and col>=0 and col<=len(board[0])-1 and (board[row][col]==1 or board[row][col]==2):
                result+=1
        return result
    
    """Time Complexity - O(mn)
    Space complexity - O(1)"""
                
        