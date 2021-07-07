# Time Complexity : Brute Force: O(n), Optimized: O(m*n)
# Space Complexity : Brute Force: O(n), Optimized: O(m*n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Not able to do it inplace

class Solution(object):
    def __checkNeighbors(self, i, j, board, rows, cols):
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        aliveNeighbors = 0
        for neighbor in neighbors:
            r = (i + neighbor[0])
            c = (j + neighbor[1])
            if (r < rows and r >= 0) and (c < cols and c >= 0) and (board[r][c] == 1):
                aliveNeighbors += 1
        return aliveNeighbors
        
        
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        retBoard = [[None for _ in range(cols)] for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                aliveNeighbors = self.__checkNeighbors(i, j, board, rows, cols)
                print(aliveNeighbors)
                if board[i][j] == 1:
                    if aliveNeighbors < 2:
                        retBoard[i][j] = 0
                    elif aliveNeighbors == 2 or aliveNeighbors == 3:
                        retBoard[i][j] = 1
                    else:
                        retBoard[i][j] = 0
                else:
                    if aliveNeighbors == 3:
                        retBoard[i][j] = 1
                    else:
                        retBoard[i][j] = 0
        board = [[retBoard[row][col] for col in range(cols)] for row in range(rows)]
        