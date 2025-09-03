"""
TC: O(N*M) {we iterate the board twice, hence N*M}
SC: O(1) {We update the board in-place}

Approach:

The high-level idea is to iterate through all the indices of the board and count the neighboring 1s and perform the given operations in
the question description. To overcome the challenge of not using an extra space, we update the board with 2 for die and 3 for live
so that it does not disturb the structure for the other indices coming after.

Finally, we again change the 2s and 3s to their corresponding new values of 0s and 1s.

The problem ran successfully on Leetcode.
"""


from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        def inBounds(row, col):
            return 0<=row<n and 0<=col<m

        # map  0 -- > 1 as 3 lives
        # map  1 --> 0 as 2 dies
        nei = [[0,1], [1,0], [-1,0], [0,-1], [1,1], [-1,-1], [-1,1], [1, -1]]
        n,m = len(board), len(board[0])

        for r in range(n):
            for c in range(m):
                ones = 0
                for dr, dc in nei:
                    nr, nc = dr + r, dc + c
                    if inBounds(nr, nc):
                        if board[nr][nc] != 0 and board[nr][nc] != 3:
                            ones += 1
                if board[r][c] == 1 or board[r][c] == 3:
                    if ones < 2:
                        board[r][c] = 2
                    elif ones > 3:
                        board[r][c] = 2
                else:
                    if ones == 3:
                        board[r][c] = 3

        #changing back the 3 and 2 to their updated states      
        for r in range(n):
            for c in range(m):
                if board[r][c] == 3:
                    board[r][c] = 1
                elif board[r][c] == 2:
                    board[r][c] = 0