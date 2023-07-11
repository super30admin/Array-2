
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def countAlive(r ,c):
            result = 0
            # print("hello")
            for d in dire:
                nr = r+ d[0]
                nc = c + d[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3):
                    result += 1
            return result

        m = len(board)
        n = len(board[0])
        dire = [0, 1], [1, 0], [0, -1], [-1, 0], [1, 1], [-1, -1], [-1, 1], [1, -1]

        for i in range(m):
            for j in range(n):
                countalive = countAlive(i, j)
                # print(countalive)
                if board[i][j] == 1 and (countalive > 3 or countalive < 2):
                    board[i][j] = 3
                if board[i][j] == 0 and countalive == 3:
                    board[i][j] = 2
        print(board)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1