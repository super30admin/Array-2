# Time Complexity : O(m*n) where m is number of rows and n is number of colums in the board.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
Iterate over the board, keeping flags for when element goes from live to dead OR dead to live.
Iterate again, setting it back to current state: dead 0 or alive 1.
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                liveCount = self.countLiveNeighbors(board, i, j)
                print(1, j, liveCount)

                if board[i][j] == 1 or board[i][j] == 2:
                    if liveCount < 2 or liveCount > 3:
                        board[i][j] = 2

                if board[i][j] == 0 or board[i][j] == 3:
                    if liveCount == 3:
                        board[i][j] = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1

    def countLiveNeighbors(self, board: List[List[int]], i: int, j: int) -> int:
        #       top,  t-right, right, b-right, bottom, b-left, left, t-left
        dirs = [(-1,0), (-1,1), (0,1), (1,1), (1,0), (1,-1), (0,-1), (-1,-1)]

        m = len(board)
        n = len(board[0])

        live = 0

        for offset in dirs:
            n_i = offset[0]+i 
            n_j = offset[1]+j 
            if n_i < m and n_i >= 0 and n_j < n and n_j >= 0:
                if board[n_i][n_j] == 1 or board[n_i][n_j] == 2:
                    live += 1

        return live
        
        