'''
289 Game of Life
https://leetcode.com/problems/game-of-life/description/

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]


Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.


Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.

In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

Solution:
1. Separate matrix: Create an output matrix of the same size and apply the 4 rules to each cell of input matrix and save the result of the rules in the output matrix.
Time: O(MN), Space: O(MN)

2. In-place: Apply the 4 rules to each cell of input matrix but when changing the cell value following the application of the rule, we use two additional numbers:
a) 1 -> 0 (alive -> dead): 2
b) 0 -> 1 (dead -> alive): 3
All the other cells that did not switch values remain in their original state (i.e. either 0 or 1).
Thus,
c) 0 -> 0 (dead -> dead): 0
d) (1 -> 1) (alive -> alive): 1

Now, we have a matrix consisting of 4 possible values: 0, 1, 2, 3 which reflect all possible cases (a)-(d). To get the latest state, scan the matrix elements again and simply change all 2's to 0 and all 3's to 1.

https://www.youtube.com/watch?v=nTpBCqvW66E

Time: O(MN), Space: O(1)
'''

def game_of_life(mat):
    def count_live_neigbors(mat, i, j):
        #dirs = [ top, bottom, left, right, top left, top right, bottom left, bottom right]
        dirs = [ [-1,0], [1,0], [0,-1], [0,1], [-1,-1], [-1,1], [1,-1], [1,1]]

        num_live_nbrs = 0
        for dir in dirs:
            row, col = i + dir[0], j + dir[1]
            if 0 <= row < M and 0 <= col < N:
                if mat[row][col] == 1 or mat[row][col] == 2:
                    num_live_nbrs += 1
        return num_live_nbrs

    M = len(mat)
    if M == 0:
        return None
    N = len(mat[0])

    for i in range(M):
        for j in range(N):
            num_live_nbrs = count_live_neigbors(mat, i, j)
            if mat[i][j] == 1:
                if num_live_nbrs < 2 or num_live_nbrs > 3: # 1 -> 0: 2
                    mat[i][j] = 2
            else: # mat[i][j] == 0:
                if num_live_nbrs == 3: # 0 -> 1: 3
                    mat[i][j] = 3

    for i in range(M):
        for j in range(N):
            if mat[i][j] == 2:
                mat[i][j] = 0

            if mat[i][j] == 3:
                mat[i][j] = 1

def run_game_of_life():
    tests = ([[0,1,0],[0,0,1],[1,1,1],[0,0,0]], [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]), ([[1,1],[1,0]],[[1,1],[1,1]])

    for test in tests:
        mat, ans = test[0], test[1]
        print(f"\nLife before: {mat}")
        game_of_life(mat)
        print(f"Life after: {mat}")
        print(f"Pass: {ans == mat}")

run_game_of_life()
