# // Time Complexity : O(n*m)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
# // Your code here along with comments explaining your approach:
# Iterate through the elements of the matrix, and replace inplace value of 1 by 2, if the live cell becomes dead, and replace inplace 0 by 3, if dead cell becomes live, according
# to their conditions. At the end, replace all 2 by 0 and all 3 by 1, and return the resulting matrix.

def countlives(board, i, j, rows, cols):
    dirs = [[1, -1], [1, 0], [1, 1], [-1, -1], [-1, 0], [-1, 1, ], [0, 1], [0, -1]]

    count = 0
    for dir in dirs:
        row = i + dir[0]
        col = j + dir[1]

        if row >= 0 and row < rows and col >= 0 and col < cols and (board[row][col] == 1 or board[row][col] == 2):
            count += 1

    return count



def gameOfLife(board):
    """
    Do not return anything, modify board in-place instead.
    """
    if len(board) == 0 or len(board[0]) == 0:
        return []

    rows = len(board)
    cols = len(board[0])

    for row in range(rows):
        for col in range(cols):
            count = countlives(board, row, col, rows, cols)  # count live neighbors

            if (board[row][col] == 1 and (count > 3 or count < 2)):  # live becomes dead
                board[row][col] = 2
            elif board[row][col] == 0 and count == 3:  # dead becomes live
                board[row][col] = 3

    for row in range(rows):
        for col in range(cols):
            if board[row][col] == 2:
                board[row][col] = 0
            elif board[row][col] == 3:
                board[row][col] = 1

    return board

print(gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))
