# Time complexity : O(n)
# Space complexity : O(1) when we update the value of nums inplace

# The code ran on Leetcode

# First step is to calculate neighbors for each cell. Use the values below to update states in place, based on input criteria
# 3 represents dead cell that was alive
# 2 represents alive cell that was dead

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        def get_neighbors(i, j, board, m, n):
            dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [1,1], [-1, -1], [-1, 1], [1, -1]]
            count = 0
            for x, y in dirs:
                x_new = i + x; y_new = j + y

                if 0 <= x_new < m and 0 <= y_new < n and (board[x_new][y_new] == 1 or board[x_new][y_new] == 3):
                    count+=1
            return count


        for i in range(m):
            for j in range(n):

                cur_state = board[i][j]
                neighbors = get_neighbors(i, j, board, m, n)

                # case 1 
                if cur_state == 1 and (neighbors > 3 or neighbors < 2):
                    board[i][j] = 3
                elif cur_state == 0 and neighbors ==3:
                    board[i][j] = 2

        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
        return board



        
