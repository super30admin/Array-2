# Time Complexity : O(r*c)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this :  "board[r - 1][c + 1]" is evaluated wrong

class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        bottom = len(board)
        right = len(board[0])

        for r in range(len(board)):
            for c in range(len(board[0])):
                live_neighbours = 0
                try:
                    if board[r - 1][c - 1] == 1 and c - 1 > -1:
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r - 1][c] == 1:
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r - 1][c + 1] == 1 and c + 1 < len(board[0]):
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r][c - 1] == 1 and c - 1 > -1:
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r][c + 1] == 1 and c + 1 < len(board[0]):
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r + 1][c - 1] == 1 and c - 1 > -1:
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r + 1][c] == 1:
                        live_neighbours += 1
                except:
                    pass
                try:
                    if board[r + 1][c + 1] == 1 and c + 1 < len(board[0]):
                        live_neighbours += 1
                except:
                    pass

                if board[r][c] == 0:
                    if live_neighbours == 3:
                        board[r][c] = 1
                elif board[r][c] == 1:
                    if live_neighbours < 2:
                        board[r][c] = 0
                    elif live_neighbours == 2:
                        board[r][c] = 1
                    elif live_neighbours == 3:
                        board[r][c] = 1
                    elif live_neighbours > 3:
                        board[r][c] = 0

        return board