# O(M * N) TIME AND O(1) SPACE
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        for i in range(len(board)):
            for j in range(len(board[i])):
                live_cells = self.getLiveCells(i,j,board)
                if board[i][j]:
                    if live_cells < 2:
                        board[i][j] = -1
                    elif live_cells > 3:
                        board[i][j] = -1
                else:
                    if live_cells == 3:
                        board[i][j] = 2
                        
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
                
    def getLiveCells(self,i,j,board):
        live_cells = 0
        if j < len(board[0]) - 1 and (board[i][j+1]==1 or board[i][j+1] == -1):
            live_cells += 1
        if i < len(board) - 1 and j < len(board[0]) - 1 and (board[i+1][j+1]==1 or board[i+1][j+1] == -1):
            live_cells += 1
        if i < len(board) - 1 and (board[i+1][j]==1 or board[i+1][j] == -1):
            live_cells += 1
        if i < len(board) - 1 and j > 0 and (board[i+1][j-1]==1 or board[i+1][j-1] == -1):
            live_cells += 1
        if j > 0 and (board[i][j-1]==1 or board[i][j-1] == -1):
            live_cells += 1
        if i > 0 and j > 0 and (board[i-1][j-1]==1 or board[i-1][j-1] == -1):
            live_cells += 1
        if i > 0 and (board[i-1][j]==1 or board[i-1][j] == -1):
            live_cells += 1
        if i > 0 and j < len(board[0]) - 1 and (board[i-1][j+1]==1 or board[i-1][j+1]==-1):
            live_cells += 1
        return live_cells
        
    
                
        