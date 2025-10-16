# Time Complexity: O(m*n)
# Space Complexity: O(1)
# This problem can be solved in place by using the following encoding:
# 0 -> 0 : dead cell remains dead
# 1 -> 1 : live cell remains live
# 1 -> 0 : live cell becomes dead (encoded as 2)
# 0 -> 1 : dead cell becomes live (encoded as 3)
# Encoding the state changes in this way allows us to keep track of both the current and next states of each cell without using additional space.
# We iterate through each cell in the board, counting the number of live neighbors.
# Based on the rules of the Game of Life, we update the cell's state using our encoding. This ensures that we do not interfere with the original state of the cells while determining the next state.
# After processing all cells, we can update the board by converting 2 to 0 and 3 to 1.
# This approach ensures that we do not interfere with the original state of the cells while determining the next state.
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dir = [[0,1],[1,0],[0,-1],[-1,0],[1,1],[-1,-1],[1,-1],[-1,1]]
        def countLiveCell(i,j):
            live = 0
            for r,c in dir:
                if 0 <= i+r < len(board) and 0 <= j+c < len(board[0]):
                    if board[i+r][j+c] == 1 or board[i+r][j+c] == 2:
                        live += 1
            return live

        for i in range(len(board)):
            for j in range(len(board[0])):
                livecell = countLiveCell(i,j)
                if board[i][j] == 1:
                    if livecell < 2: board[i][j] = 2
                    if livecell > 3: board[i][j] = 2
                if board[i][j] == 0:
                    if livecell == 3: board[i][j] = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2: board[i][j] = 0
                if board[i][j] == 3: board[i][j] = 1