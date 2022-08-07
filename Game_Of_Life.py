'''
Time Complexity - O(m*n)
Space Complexity - O(1)
'''


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count_lives = self.count_Alive(board, i, j)
                if (board[i][j] == 1):
                    if count_lives < 2 or count_lives > 3:
                        board[i][j] = 2
                else:
                    if count_lives == 3:
                        board[i][j] = 3
        print(board)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

    def count_Alive(self, board, i, j):
        m = len(board)
        n = len(board[0])
        count = 0
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0],
                [1, 1], [1, -1], [-1, 1], [-1, -1]]
        for d in dirs:
            new_r = i + d[0]
            new_c = j + d[1]
            if (new_r >= 0 and new_r < m) and (new_c >= 0 and new_c < n):
                if (board[new_r][new_c] == 1 or board[new_r][new_c] == 2):
                    count += 1
        return count
