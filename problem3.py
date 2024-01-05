#time complexity : O(n*m)
#space complexity :O(1)
#Submit on leetcode: yes

class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])

        def countNeibh(r, c):
            n = 0
            for i in range(r - 1, r + 2):
                for j in range(c - 1, c + 2):
                    if ((i == r and j == c) or i < 0 or j < 0 or i == row or j == col):
                        continue
                    if board[i][j] in [1, 3]:
                        n += 1
            return n

        for i in range(row):
            for j in range(col):
                neibh = countNeibh(i, j)
                if board[i][j] == 1:
                    if neibh in [2, 3]:
                        board[i][j] = 3  # 1 to 0 transition
                elif board[i][j] == 0 and neibh == 3:
                    board[i][j] = 2  # 0 to 1 transition

        for i in range(row):
            for j in range(col):
                if board[i][j] == 1:
                    board[i][j] = 0
                elif board[i][j] in [2, 3]:
                    board[i][j] = 1
                    

sol = Solution()

board = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0]
]

# Print the original board
print("Original Board:")
for row in board:
    print(row)

# Apply the game of life rules
sol.gameOfLife(board)

# Print the modified board
print("\nModified Board:")
for row in board:
    print(row)





