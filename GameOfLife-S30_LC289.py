class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # Leetcode submission successful.
        # Time Complexity = O(m*n) asymptotically.
        # Space Complexity = O(1) as we have edited the board/matrix in-place.

        rows = len(board)
        cols = len(board[0])

        # 0 -> 1 : nowlive
        # 1 -> 0 : nowdead
        for c in range(cols):
            for r in range(rows):
                live_neighs = self.countLiveNeighs(board, r, c)
                if board[r][c] == 0:
                    if live_neighs == 3:
                        board[r][c] = 'nowlive'
                else:
                    if live_neighs < 2 or live_neighs > 3:
                        board[r][c] = 'nowdead'

        # Updating the board to keep 0s and 1s.
        for c in range(cols):
            for r in range(rows):
                if board[r][c] == 'nowlive':
                    board[r][c] = 1
                elif board[r][c] == 'nowdead':
                    board[r][c] = 0

    def countLiveNeighs(self, board, row, col):
        count = 0

        # dirs template which we will follow later as well.
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [-1, -1], [1, -1], [-1, 1]]

        for dir in dirs:
            n_row = row + dir[0]
            n_col = col + dir[1]

            # Need to check if new row and col are in bounds.
            # nowdead has to be considered because it was live(1) before.
            if (n_row >= 0 and n_col >= 0 and n_row < len(board) and n_col < len(board[0]) and (
                    board[n_row][n_col] == 1 or board[n_row][n_col] == 'nowdead')):
                count += 1
        return count