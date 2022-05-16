# Time Complexity : O(M*N) where is M is number of rows and N is number of columns in the board
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board) -> None:
        ROWS = len(board)
        COLS = len(board[0])
        dirs = [[-1, -1],[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = 0
                for d in dirs:
                    r, c = i + d[0], j + d[1]
                    if 0 <= r < ROWS and 0 <= c < COLS and (board[r][c] == 1 or board[r][c] == 10):
                        count += 1

                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 10
                elif board[i][j] == 1 and (count == 2 or count == 3):
                    board[i][j] = 1
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 11
                    
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 11:
                    board[i][j] = 1
                elif board[i][j] == 10:
                    board[i][j] = 0

        return board

solution = Solution()
print(f"OUTPUT >> {solution.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]])}")