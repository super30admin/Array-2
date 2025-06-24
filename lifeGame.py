# Time Complexity : O(m * n) Traversing entire board twice
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

# We will loop through each cell and count it's neighbors and based on count of ;ive neighbors (update to 2 or 3) 
# Once all cells are done, change 2 to 0 alive to dead
# change 3 to 1, dead to alive 
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        rows = len(board)
        cols = len(board[0])

        for i in range(rows):
            for j in range(cols):
                ones = 0 # Initial neighbor count
                for x, y in [(-1, -1), (-1, 0), (-1, 1),
                             (0, -1),         (0, 1),
                             (1, -1), (1, 0), (1, 1)]: # 8 directions 
                    ni, nj = i + x, j + y
                    if 0 <= ni < rows and 0 <= nj < cols and (board[ni][nj] == 1 or board[ni][nj] == 2):
                        ones += 1

                if board[i][j] == 1:
                    if ones < 2 or ones > 3:
                        board[i][j] = 2  # alive to dead
                else:
                    if ones == 3:
                        board[i][j] = 3  # dead to  alive

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

        return board