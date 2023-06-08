# Time Complexity : O(n^2) where n is the total number of cells
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Since we need the original state of all neighbours to interpret the new state of the target index,
# we need a way to represent both old and new state within the same position.
# Here we denote a transition 1->0 with a 2. and a transition of 0->1 with a 3.
# This expands our representation to 4 states instead of 2 and helps with the calculation.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #  1->0 : 2
        #  0->1 : 3
        
        for r in range(len(board)):
            for c in range(len(board[0])):
                aliveNeighs = self.cntNeigh(r, c, board)
                if (aliveNeighs < 2 or aliveNeighs > 3) and board[r][c] == 1:
                    board[r][c] = 2
                if aliveNeighs == 3 and board[r][c] == 0:
                    board[r][c] = 3

        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == 3:
                    board[r][c] = 1
                elif board[r][c] == 2:
                    board[r][c] = 0

        return board


    def cntNeigh(self, r, c, board):
        cnt = 0
        neighs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        for (dr, dc) in neighs:
            nr = r + dr
            nc = c + dc
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]):
                cnt += self.getOrigCnt(board[nr][nc])
        return cnt
                
    def getOrigCnt(self, val):
        if val == 2:
            return 1
        if val == 3:
            return 0
        return val