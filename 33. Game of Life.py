class Solution:
    m, n = 0, 0

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None:
            return

        m, n = len(board), len(board[0])
        # 0 --- 1 = 2
        # 1 --- 0 = 3
        for i in range(0, m):
            for j in range(0, n):
                count = self.countLives(board, i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3

                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2

        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1

    def countLives(self, board, i, j):
        result = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]

        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            if (nr >= 0 and nr < len(board) and nc >= 0 and nc < len(board[0])) and (
                    board[nr][nc] == 1 or board[nr][nc] == 3):
                result += 1
        return result

# TC = O(m) * O(n)
# Space complexity : No extra space we are just changing the state of the input array and returned list does not count as extra space.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : got list out if index error
