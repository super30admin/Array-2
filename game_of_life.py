# O(M * N) TIME AND O(1) SPACE
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                live_neighbors = self.getLiveNeighbors(i,j,board)
                if(board[i][j] == 1 or board[i][j] == -1):
                    if live_neighbors < 2 or live_neighbors > 3:
                        board[i][j] = -1
                else:
                    if live_neighbors == 3:
                        board[i][j] = 2
                        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
                    
    def getLiveNeighbors(self,i,j,board):
        directions = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        live_neighbors = 0
        for r,c in directions:
            row = i + r
            col = j + c
            if row >= 0 and row < len(board) and col >= 0 and col < len(board[0]):
                if(board[row][col] == 1 or board[row][col] == -1):
                    live_neighbors += 1
        return live_neighbors
    