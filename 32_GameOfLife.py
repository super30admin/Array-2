# time - O(M*N) , space - O(1)
# accepted in leetcode
# Doing inplace solution my placing a different number for 1 and 0 and then in the second iteration for the matrix replacing back
# with original numbers, so as to avoid wrong update due to previous updates.
class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0: # edge case
            return
        for i in range(len(board)):
            for j in range(len(board[0])):
                liveNeighbors = self.live_NeighborCount(board, i, j) # count of liveneighbour will get from this method
                # check for rule 1 & 3 at a time as both rule change live node to dead.
                if board[i][j] == 1 and (liveNeighbors < 2 or liveNeighbors > 3):
                    board[i][j] = -1 # assigning a different number
                # check for Rule 4 where a dead node comes back as zombie based on count of live neighbours.
                if board[i][j] == 0 and liveNeighbors == 3:
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])): # ressigning 0 and 1
                if board[i][j] == 2: board[i][j] = 1
                if board[i][j] == -1: board[i][j] = 0

    def live_NeighborCount(self, board, i, j): # checking for count of live neighbours
        # previously dead and now live = 2, mapped to 1 in 2nd iteration
        # previously live and now dead = -1, mapped to 0 in 2nd iteration
        count = 0
        n = len(board)
        m = len(board[0])
        # vertical up
        if i > 0:
            if board[i - 1][j] == 1 or board[i - 1][j] == -1: count += 1
        # vertical down
        if i < n - 1:
            if board[i + 1][j] == 1 or board[i + 1][j] == -1: count += 1
        # top left
        if i > 0 and j > 0:
            if board[i - 1][j - 1] == 1 or board[i - 1][j - 1] == -1: count += 1
        # top right
        if i > 0 and j < m - 1:
            if board[i - 1][j + 1] == 1 or board[i - 1][j + 1] == -1: count += 1
        # horizontal left
        if j > 0:
            if board[i][j - 1] == 1 or board[i][j - 1] == -1: count += 1
        # horizontal right
        if j < m - 1:
            if board[i][j + 1] == 1 or board[i][j + 1] == -1: count += 1
        # bottom left
        if i < n - 1 and j > 0:
            if board[i + 1][j - 1] == 1 or board[i + 1][j - 1] == -1: count += 1
        # bottom right
        if i < n - 1 and j < m - 1:
            if board[i + 1][j + 1] == 1 or board[i + 1][j + 1] == -1: count += 1
        return count