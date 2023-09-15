class Solution:
    
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = len(board)
        m = len(board[0])
        for i in range(0, n):
            for j in range(0, m):
                liveNeighbors = self.countLiveNeighbors(board = board, row = i, col = j)
                if(board[i][j] == 1):
                    if(liveNeighbors < 2 or liveNeighbors > 3):
                        board[i][j] = 22
                else:
                    if(liveNeighbors == 3):
                        board[i][j] = 33
        
        for i in range(0, n):
            for j in range(0, m):
                if(board[i][j] == 22):
                    board[i][j] = 0
                if(board[i][j] == 33):
                    board[i][j] = 1
        
    def countLiveNeighbors(self, board: list[list[int]], row: int, col: int) -> int:
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        count = 0
        for i in range(0, len(dirs)):
            nr = row + dirs[i][0]
            nc = col + dirs[i][1]

            if(nr >= 0 and nr < len(board) and nc >= 0 and nc < len(board[0]) and (board[nr][nc] == 1 or board[nr][nc] == 22)):
                count += 1
        return count

        