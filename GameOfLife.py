Time and Space complexity: O(n^2) linear complexity
Did it execute in leetcode: Error - too many values to unpack
Comments: I created another matrix of neighboring co-ordinates for each point in every iteration. Then, I tallied the neighboring points.
If the cell is live (value = 1) and sum of neighboring co-ordinates is 2 or 3, it is declaed live. Also, if sum is 3 and cell is dead 
(value = 0), it is again declared live by reproduction. Else, it is declared dead.

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        def checkLive(theBoard, i, j):
            neighbor_index = [(i+k, j+l) for k in [-1, 0, 1] for l in [-1, 0, 1] \
                              if 0<=i+k<=rows-1 and 0<=j+l<=cols-1]
            total_neighbors = sum([theBoard[i][j] for i, j in neighbor_index])
            if((theBoard[i][j] == 1 and total_neighbors in [2, 3]) or \
               (theBoard[i][j] == 0 and total_neighbors == 3)):
                return 1
            else:
                return 0
        board[:] = [[checkLive(board, i, j) for j in range(cols)] for i in range(rows)]
