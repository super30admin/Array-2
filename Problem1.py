# Time Complexity :O(n^m) where n is number of rows and m is column
# Space Complexity :O(1)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 289

# According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised
# by the British mathematician John Horton Conway in 1970."
#
# The board is made up of an m x n grid of cells, where each cell has an initial state:
# live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight
# neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
#
# Any live cell with fewer than two live neighbors dies as if caused by under-population.
# Any live cell with two or three live neighbors lives on to the next generation.
# Any live cell with more than three live neighbors dies, as if by over-population.
# Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
# The next state is created by applying the above rules simultaneously to every cell in the current state,
# where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

# Example 1:
#
#
# Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
# Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
#
# Example 2:
#
#
# Input: board = [[1,1],[1,0]]
# Output: [[1,1],[1,1]]


def main():
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    ans = gameOfLife(board)
    print(ans)
def gameOfLife(board):
    """
    :type board: List[List[int]]
    :rtype: None Do not return anything, modify board in-place instead.
    """

    # Checking if the board is empty or None
    if not board:
        return None

    # Rows and cols of board
    n = len(board)
    m = len(board[0])

    # Two concepts.
    # '2' -> A cell which was alive is now dead.
    # '3' -> A cell which was dead is now alive.
    # In the end we will modify 2 and 3.

    # This is the method which will give the count of the neighbors in adjacent blocks. We will check only if the current block is 1 or 2 (because we have just updated to keep atrack. new values will be compared as if it was alive. )
    def countLives(i, j, n, m):
        dir = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)]
        count = 0
        for each in dir:
            r = i + each[0]
            c = j + each[1]
            if (r >= 0 and r < n and c >= 0 and c < m and (board[r][c] == 1 or board[r][c] == 2)):
                count += 1
        return count

    # Looping over the matrix.
    for i in range(n):
        for j in range(m):
            # Taking the count of the livecells nearby
            count = countLives(i, j, n, m)

            # If the cell is alive and the count is few than 2 or count > 3 then we make it dead and assign as 2. Condition no 1 and 3
            if board[i][j] == 1 and (count < 2 or count > 3):
                board[i][j] = 2

            # If the cell is dead and has exact 3 live cells nearby then it is alive and we make it 3. From dead to alive. Condition no 4. Condition no 2 requires no additional code, because it stays the same.
            elif board[i][j] == 0 and (count == 3):
                board[i][j] = 3

    # Finally we change back 2 to dead and 3 to alive.
    for i in range(n):
        for j in range(m):
            if board[i][j] == 2:
                board[i][j] = 0
            elif board[i][j] == 3:
                board[i][j] = 1

    return board

if __name__ == '__main__':
    main()