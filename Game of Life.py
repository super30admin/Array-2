class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 1-->0 = 2
        #0--> 1 = 3
        for i in range(m):
            for j in range(n):
                live = self.livecount(board, i, j)

                if board[i][j] == 1:
                    if live < 2 or live > 3:
                        board[i][j] = 2
                else:
                    if live == 3:
                        board[i][j] = 3


        for i in range(m):
            for j in range(n):

                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1


    def livecount(self, board: List[List[int]], r: int, c: int) -> int:

        count = 0
        m = len(board)
        n = len(board[0])
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]

            if (nr >= 0 and nc >=0 and nr<m and nc<n  and (board[nr][nc]==2 or board[nr][nc]==1)):
                count = count +1

        return count        




        