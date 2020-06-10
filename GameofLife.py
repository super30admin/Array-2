#289. Game of Life
# Time Complexity : O(mn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : No



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        rows = len(board)
        cols = len(board[0])

        for i in range(rows):
            for j in range(cols):
                lives = self.get_lives(board, i, j, rows, cols)                
                if board[i][j] == 1:
                    if lives > 3 or lives < 2:
                        board[i][j] = 3

                else:
                    if lives == 3:
                        board[i][j] = 2

        for i in range(rows):
            for j in range(cols):

                if board[i][j] == 3:
                    board[i][j] = 0

                elif board[i][j] == 2:
                    board[i][j] = 1


    def get_lives(self, board, i, j, rows, cols):

        dirs = [(-1,0),(0,-1),(1,0),(0,1),(-1,-1),(-1,1),(1,-1),(1,1)]

        lives= 0
        for r,c in dirs:

            rr = i + r
            cc = j + c
            if rr >=0 and rr < rows and cc >= 0 and cc < cols:
                if board[rr][cc] == 3 or board[rr][cc] == 1:
                    lives += 1

        return lives

