# Time Complexity: O(n * m)
# Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1->0 : 2 (orginally 1)
        # 0->1 : 3 (orginally 0)
        n = len(board)
        m = len(board[0])
        for i in range(n):
            for j in range(m):
                count = 0
                if board[i][j] == 1 or board[i][j] == 2:
                    # i-1, j-1
                    if i >= 1 and j >= 1 and (board[i-1][j-1] == 1 or board[i-1][j-1] == 2):
                        count += 1
                    # i-1,j
                    if i >= 1 and (board[i-1][j] == 1 or board[i-1][j] == 2):
                        count += 1
                    # i-1, j+1
                    if i >= 1 and j < m-1 and (board[i-1][j+1] == 1 or board[i-1][j+1] == 2):
                        count += 1
                    # i, j-1
                    if j >= 1 and (board[i][j-1] == 1 or board[i][j-1] == 2):
                        count += 1
                    # i, j+1
                    if j < m-1 and (board[i][j+1] == 1 or board[i][j+1] == 2):
                        count += 1
                    # i+1, j-1
                    if i < n-1 and j >= 1 and (board[i+1][j-1] == 1 or board[i+1][j-1] == 2):
                        count += 1
                    # i+1, j
                    if i < n-1 and (board[i+1][j] == 1 or board[i+1][j] == 2):
                        count += 1
                    # i+1,j+1
                    if i < n-1 and j < m-1 and (board[i+1][j+1] == 1 or board[i+1][j+1] == 2):
                        count += 1
                    if count < 2 or count > 3:
                        board[i][j] = 2
                elif board[i][j] == 0 or board[i][j] == 3:
                    # i-1, j-1
                    if i >= 1 and j >= 1 and (board[i-1][j-1] == 1 or board[i-1][j-1] == 2):
                        count += 1
                    # i-1,j
                    if i >= 1 and (board[i-1][j] == 1 or board[i-1][j] == 2):
                        count += 1
                    # i-1, j+1
                    if i >= 1 and j < m-1 and (board[i-1][j+1] == 1 or board[i-1][j+1] == 2):
                        count += 1
                    # i, j-1
                    if j >= 1 and (board[i][j-1] == 1 or board[i][j-1] == 2):
                        count += 1
                    # i, j+1
                    if j < m-1 and (board[i][j+1] == 1 or board[i][j+1] == 2):
                        count += 1
                    # i+1, j-1
                    if i < n-1 and j >= 1 and (board[i+1][j-1] == 1 or board[i+1][j-1] == 2):
                        count += 1
                    # i+1, j
                    if i < n-1 and (board[i+1][j] == 1 or board[i+1][j] == 2):
                        count += 1
                    # i+1,j+1
                    if i < n-1 and j < m-1 and (board[i+1][j+1] == 1 or board[i+1][j+1] == 2):
                        count += 1
                    if count == 3:
                        board[i][j] = 3
        
        for i in range(n):
            for j in range(m):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
