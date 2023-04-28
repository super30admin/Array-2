class Solution:
    def __init__(self):
        self.directions = [(0,1), (1,0), (1,1), (-1,0),
        (0,-1), (-1,-1), (-1, 1), (1, -1)]

    def countNeighbors(self, board, row, col):
        count = 0
        for dr,dc in self.directions:
            nr = row + dr
            nc = col + dc
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] in {1,3} :
                count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                neighbors = self.countNeighbors(board, i, j)
                if board[i][j] == 1:
                    if neighbors < 2 or neighbors > 3: #die of over or under population
                        board[i][j] = 3
                else:
                    if neighbors == 3:  
                        board[i][j] = 2
        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        
        