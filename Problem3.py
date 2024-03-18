#T.C. O(m*n), where m = no of rows and n = no of columns
#S.C. O(1), as this is an in-place algorithm

'''
Approach
As this algorithm is in-place, there has to be a way for the element to know what the original element was. so here I used a table to keep track of an element's original state.

Original State     New State  Status

0                  0            0
1                  0            1
0                  1            2
1                  1            3

If the element remains 1, according to the rules here, we will change the value to 3. if the element changes from 1 to 0, we change it to 1. 
if the element changes from 0 to 1, we keep it 1. same with 0.

'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        def countNeighbors(r, c):
            noofnei = 0
            for i in range(r - 1, r + 2):
                for j in range(c -1, c + 2):
                    if ((i == r and j == c) or i < 0 or j < 0 or 
                    i == rows or j == cols):
                        continue
                    if board[i][j] in [1,3]:
                        noofnei += 1
            return noofnei
        
        for r in range(rows):
            for c in range(cols):
                noofnei = countNeighbors(r, c)
                if board[r][c]:
                    if noofnei in [2, 3]:
                        board[r][c] = 3
                elif noofnei == 3:
                    board[r][c] = 2

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == 1:
                    board[r][c] = 0
                elif board[r][c] in [2,3]:
                    board[r][c] = 1
        
