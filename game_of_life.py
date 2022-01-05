# Time Complexity - O(mn)
# Space Complexity - O(1)

class Solution:
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        if len(board)==0 and len(board[0])==0:
            return -1
        for i in range(len(board)):
            for j in range(len(board[0])):
                # 1 -- 0 --> 2
                # 0 -- 1 -->3
                # rule 1 & 3
                if board[i][j]==1 and (self.countneighbours(board,i,j)<2 or self.countneighbours(board,i,j)>3):
                    board[i][j]=2
                # rule 2
                if board[i][j]==0 and self.countneighbours(board,i,j)==3:
                    board[i][j]=3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j]=0
                if board[i][j] == 3:
                    board[i][j]=1
        return board
    
    def countneighbours(self,board,i,j):
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        result = 0
        for val in dirs:
            r = i + val[0]
            c = j + val[1]
            if r>=0 and r<len(board) and c>=0 and c<len(board[0]) and (board[r][c]==1 or board[r][c]==2):
                result = result+1
        return result
