class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board or not len(board):
            return -1
        # 0 -> 1 = 2
        # 1 -> 0 = 3
        rows = len(board)
        cols = len(board[0])

        def getNeiCount(r, c):
            nei = 0
            for i in range(r - 1, r + 2):
                for j in range(c - 1, c + 2):
                    if (i == r and j == c) or i < 0 or j < 0 or i == rows or j == cols:
                        continue
                    if board[i][j] in [1, 3]:
                        nei += 1
            return nei

        for r in range(rows):
            for c in range(cols):
                neiCount = getNeiCount(r, c)

                if board[r][c]:
                    if neiCount not in [2, 3]:
                        board[r][c] = 3
                elif neiCount == 3:
                    board[r][c] = 2

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 2:
                    board[r][c] = 1
                elif board[r][c] == 3:
                    board[r][c] = 0

        # T: O(n * m), S: O(1)