# Time Complexity O(m*n)
# Space Complexity O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        DEAD = 0
        LIVE = 1
        DEAD_TO_LIVE = 3
        LIVE_TO_DEAD = 4

        m = len(board)
        n = len(board[0])

        directions = [
            [-1, 0],  # UP
            [1, 0],  # DOWN
            [0, -1],  # LEFT
            [0, 1],  # RIGHT
            [-1, -1],  # TOP_LEFT
            [-1, 1],  # TOP_RIGHT
            [1, -1],  # DOWN_LEFT
            [1, 1]  # DOWN_RIGHT
        ]

        def aliveCount(board, i, j):
            m = len(board)
            n = len(board[0])
            _alivecount = 0

            for direction in directions:
                new_i = i + direction[0]
                new_j = j + direction[1]

                if new_i >= 0 and new_i < m and new_j >= 0 and new_j < n:
                    if board[new_i][new_j] == LIVE or board[new_i][new_j] == LIVE_TO_DEAD:
                        _alivecount += 1
            return _alivecount

        for i in range(m):
            for j in range(n):
                _alivecount = aliveCount(board, i, j)
                _currstatus = board[i][j]
                if _currstatus == LIVE:
                    if _alivecount < 2 or _alivecount > 3:
                        board[i][j] = LIVE_TO_DEAD
                else:
                    if _alivecount == 3:
                        board[i][j] = DEAD_TO_LIVE

        for i in range(m):
            for j in range(n):
                if board[i][j] == DEAD_TO_LIVE:
                    board[i][j] = LIVE
                elif board[i][j] == LIVE_TO_DEAD:
                    board[i][j] = DEAD


