# Time Complexity: O(n * m)
# Space Complexity: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or board is None:
            return 0

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                countLiveNeighbors = countLives(board, i, j)
                if board[i][j] == 0:
                    if countLiveNeighbors == 3:
                        board[i][j] = 2
                else:
                    if countLiveNeighbors < 2:
                        board[i][j] = 3
                    if countLiveNeighbors > 3:
                        board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
        
        def countLives(board, r, c):
            count = 0
            dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1}}

            for dir in dirs:
                nr = r + dir[0]
                nc = c + dir[1]
                if nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3):
                    count += 1

            return count
