# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n * m)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        - values changed in place to avoid using extra space
        - as values iterated, original number will be changed.
        - hence, original number changed to some third no.(commented below) 
        to keep track of both new and original values
        """
        total_rows = len(board)
        total_cols = len(board[0])
        # 1 -> 0 : 2
        # 0 -> 1 : 3
        for r in range(total_rows):
            for c in range(total_cols):
                count = neighborCount(board, r, c, total_rows, total_cols)
                if board[r][c] == 1 and (count < 2 or count > 3):
                    board[r][c] = 2
                elif board[r][c] == 0 and count == 3:
                    board[r][c] = 3

        for r in range(total_rows):
            for c in range(total_cols):
                if board[r][c] == 2:
                    board[r][c] = 0
                elif board[r][c] == 3:
                    board[r][c] = 1



def neighborCount(board, r, c, total_rows, total_cols):
        directions = [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]]
        count = 0
        for val in directions:
            new_row = r + val[0]
            new_col = c + val[1]

            if (0 <= new_row < total_rows) and (0 <= new_col < total_cols) and (board[new_row][new_col] == 1 or board[new_row][new_col] == 2):
                count += 1

        return count
                