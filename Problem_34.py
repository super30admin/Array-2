# TC: O(8*m*n) = O(mn)
# SC: O(1)

class Solution:
    def countAlive(self, board, i, j, m , n, dirs):
        count = 0
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            if (r >= 0 and c >= 0) and (r < m and c < n) and (board[r][c] == 1 or board[r][c] == 2):
                count += 1
        return count


    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # null

        # 1 -- 0  2
        # 0 -- 1  3

        m = len(board)
        n = len(board[0])

        dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        
        for i in range(0, m):
            for j in range(0, n):
                countAlive = self.countAlive(board, i, j, m, n, dirs)
                print(countAlive)
                if board[i][j] == 1:
                    #rule 1 and 3
                    if countAlive < 2 or countAlive > 3:
                        board[i][j] = 2
                else:
                    if countAlive == 3:
                        board[i][j] = 3

        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

