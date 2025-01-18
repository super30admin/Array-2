class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 1 -> 0 : 2
        # 0 -> 1 : 3

        for i in range(m):
            for j in range(n):
                liveNeighbours = self.liveneighbors(board, i, j)
                if board[i][j] == 1:
                    if liveNeighbours < 2 or liveNeighbours > 3:
                        board[i][j] = 2
                else:
                    if liveNeighbours == 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    def liveneighbors(self, board: List[List[int]], r: int, c: int) -> int:
        self.dirs = [[-1,-1],[0,1], [1,0], [1,-1], [-1,0], [0,-1],[1,1], [-1,1]]
        count = 0
        m = len(board)
        n = len(board[0])
        for dirs in self.dirs:
            nr = r + dirs[0] #Check for neightbors
            nc = c + dirs[1]
            if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1
        return count


