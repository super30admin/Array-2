//Time = O(mn)
//Space = O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])  # get dimensions of the board

        # define helper function to get the number of live neighbors for a given cell
        def getLiveNeighbors(row, col):
            count = 0
            for i in range(max(0, row - 1), min(m, row + 2)):
                for j in range(max(0, col - 1), min(n, col + 2)):
                    if (i, j) != (row, col) and 1 <= board[i][j] <= 2:
                        count += 1
            return count

        # update the board in-place
        for i in range(m):
            for j in range(n):
                liveNeighbors = getLiveNeighbors(i, j)
                if board[i][j] == 1 and (liveNeighbors < 2 or liveNeighbors > 3):
                    board[i][j] = 2  # mark cells that were alive but die in the next state
                elif board[i][j] == 0 and liveNeighbors == 3:
                    board[i][j] = -1  # mark cells that were dead but come to life in the next state

        # update the board again to reflect the next state
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0  # dead cell
                elif board[i][j] == -1:
                    board[i][j] = 1  # live cell
