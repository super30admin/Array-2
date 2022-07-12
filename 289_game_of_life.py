'''

## Problem 289: Game of Life

## Author: Neha Doiphode
## Date:   07-10-2022

## Description:
    According to Wikipedia's article:
    "The Game of Life, also known simply as Life, is a cellular automaton devised by
    the British mathematician John Horton Conway in 1970."

    The board is made up of an m x n grid of cells,
    where each cell has an initial state: alive (represented by a 1) or dead (represented by a 0).
    Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
    using the following four rules (taken from the above Wikipedia article):
        * Any alive cell with fewer than two alive neighbors dies as if caused by under-population.
        * Any alive cell with two or three alive neighbors live on to the next generation.
        * Any alive cell with more than three alive neighbors dies, as if by over-population.
        * Any dead cell with exactly three alive neighbors becomes an alive cell, as if by reproduction.

    The next state is created by applying the above rules simultaneously to every cell in the current state,
    where births and deaths occur simultaneously.
    Given the current state of the m x n grid board, return the next state.

## Examples:
        Example 1:
            Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
            Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

        Example 2:
            Input: board = [[1,1],[1,0]]
            Output: [[1,1],[1,1]]

## Constraints:
    m == board.length
    n == board[i].length
    1 <= m, n <= 25

    board[i][j] is 0 or 1.

## Follow up:
    Could you solve it in-place?
    Remember that the board needs to be updated simultaneously:
    You cannot update some cells first and then use their updated values to update other cells.

    In this question, we represent the board using a 2D array.
    In principle, the board is infinite, which would cause problems when
    the active area encroaches upon the border of the array (i.e., alive cells reach the border).
    How would you address these problems?

## Time complexity: O(m * n), where m is number of rows and n columns.
                              We are looking in 8 directions always per cell but that is considered as constant time operation.
                              
## Space complexity: O(1), as we are not using auxiliary space.
'''

from typing import List

def get_input():
    print("Enter the number of rows on the board: ", end = "")
    rows = int(input())
    print("Enter the number of columns on the board: ", end = "")
    columns = int(input())
    input_matrix = []
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        input_matrix.append(l)

    return input_matrix

class Solution:

    def count_neighbors(self, board: List[List[int]], current_row: int, current_column: int, m: int, n: int) -> int:
        '''
        Returns count of neighbors.

        Directions
         * bottom       = next row, same column         = [1,   0]
         * top          = previous row, same column     = [-1,  0]
         * right        = same row, next column         = [0,   1]
         * left         = same row, previous column     = [0,  -1]
         * top-right    = previous row, next column     = [-1,  1]
         * top-left     = previous row, previous column = [-1, -1]
         * bottom-right = next row, next column         = [1,   1]
         * bottom-left  = next row, previous column     = [1,  -1]
        '''
        count = 0
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1], [-1, 1], [-1, -1], [1, 1], [1, -1]]

        for direction in directions:
            new_row    = current_row + direction[0] # row
            new_column = current_column + direction[1] # column

            # Condition 1: we need to check if new_row and new_column are within bounds of the board
            # Condition 2: Count how many live cells, check if the cell is 1 or if it was live earlier.
            #              if the cell was live earlier and has become dead in the previous iterations,
            #              we would have changed it to 3. So we need to count cells represented by 3 as well.
            if (new_row >= 0 and new_row < m) and (new_column >= 0 and new_column < n) and (board[new_row][new_column] == 1 or board[new_row][new_column] == 3):
                count += 1
        return count

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.

        Rules:
        1. alive cells:
            * < 2 alive neighbors -> change to dead.
            * 2/3 alive neighbors -> alive cell remains alive.
            * > 3 alive neighbors -> change to dead.
        2. Dead cells:
            * 3 alive neighbors   -> change to alive.

         Notes:
            Since we want to preserve input board while updating it for building up the answer,
            we need some internal translation for the cells which are changed from alive to dead or dead to alive.

            To do so, we are going to use, another set of simple integers.
            Translation:
                If cell has changed from alive to dead: 1 -> 0 = 3
                If cell has changed from dead to alive: 0 -> 1 = 2
        """
        if not len(board):
            return

        # Rows
        m = len(board)
        # Columns
        n = len(board[0])

        # Start iterating over rows and columns of the board.
        for i in range(m):
            for j in range(n):

                # to determine the next generation of the cell we need to first count its neighbors
                # and the determine the next stage for the cell.
                # This is also because, on the edges of the board/edge rows/columns cells are not going to have
                # all 8 neighbors.
                neighbors = self.count_neighbors(board, i, j, m, n)

                # Main conditions are
                # If currently, cell is dead or alive
                # if currently the cell is dead
                if board[i][j] == 0:
                    if neighbors == 3:
                        # change the state to alive.
                        # dead to alive we are going to treat as 2.
                        board[i][j] = 2

                # if currently the cell is alive
                else:
                    if neighbors < 2 or neighbors > 3:
                        board[i][j] = 3

        # Restore the answer.
        # If we see 2 that means, it was a dead cell changed to alive
        # If we see 3 that means, it was an alive cell changed to dead
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0

# Driver code
solution = Solution()
board = get_input()
print(f"Input board: {board}")
solution.gameOfLife(board)
print(f"Output board: {board}")
