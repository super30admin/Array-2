class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == 0 or len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        # 1 --> 0 --> 2
        # 0 --> 1 --> 3
        for i in range(m):
            for j in range(n):
                liveNeighborCount = self.countLiveNeighbors(board,i,j)
                if board[i][j] == 1:
                    if liveNeighborCount < 2 or liveNeighborCount > 3:
                        board[i][j] = 2
                else:
                    if liveNeighborCount == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

    def countLiveNeighbors(self, board, row,col):
        m = len(board)
        n = len(board[0])
        count = 0
        # U D L R UL UR LL LR
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for Dir in dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            if nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count = count + 1
        return count




        