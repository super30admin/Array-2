#Time Complexity: O(m*n)
#Space Complexity: O(1)

class Solution:
    def gameOfLife(self, board) -> None:
        m = len(board)
        n = len(board[0]) if m else 0
        for i in range(m):
            for j in range(n):
                count = 0
                ## Count live cells in 3x3 block.
                for I in range(max(i-1, 0), min(i+2, m)):
                    for J in range(max(j-1, 0), min(j+2, n)):
                        count += board[I][J] & 1
                if (count == 4 and board[i][j]) or count == 3:
                    board[i][j] |= 2  # Mark as live.

        for i in range(m):
            for j in range(n):
                board[i][j] >>= 1
        

