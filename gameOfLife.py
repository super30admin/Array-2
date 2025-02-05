"""
Arrays approach (normal traversal)
TC = O(m * n)
SC = O(1))
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        """
        Rules --
        1 < 2 live neighbors || 1 > 3 live neighbors ===> 0
        0 == 3 live neighbors ===> 1

        To do in place, when a live cell becomes dead, i.e. 1 --> 0 ===> 2
        To do in place, when a dead cell becomes live, i.e. 0 --> 1 ===> 3
        """
        m = len(board)
        n = len(board[0])

        # traverse through the elements to identify the live and dead neighbors
        for i in range(m):
            for j in range(n):
                # count live neighbors
                liveNeighbors = self.countLiveNeighbors(board, i, j, m, n)

                # if live
                if board[i][j] == 1:
                    if liveNeighbors < 2 or liveNeighbors > 3:
                        board[i][j] = 2
                else:
                    if board[i][j] == 0:
                        if liveNeighbors == 3:
                            board[i][j] = 3
        # replace the 2s and 3s back to 0 and 1 respectively after all the elements in the matrix are processed
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                else:
                    if board[i][j] == 3:
                        board[i][j] = 1

    def countLiveNeighbors(self, board, i, j, m, n):
        count = 0
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0], [-1, 1], [-1, -1], [1, 1], [1, -1]]
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]

            if (nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count += 1
        return count