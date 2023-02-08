# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes


# // Your code here along with comments explaining your approach



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        if board == None or len(board) == 0: #checking for null condition
            return
        
        directions = ((-1,0), (1,0), (0,-1), (0,1), (-1,-1), (-1,1), (1,1), (1,-1)) # setting up all the possible directions for a cell
        def count_of_live_cells(board, i, j): # we check the count of live neighbor cells for a given point in the matrix
            result = 0
            for d in directions:
                nr = i + d[0]
                nc = j + d[1]
                if (nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 3 or board[nr][nc] == 1)):
                    result += 1
            return result

        for i in range(m): # using nested loops we check all the conditions and mark 1 -> 0 => 3 and 0 -> 1 => 2
            for j in range(n):
                count_alive = count_of_live_cells(board, i, j)
                if board[i][j] == 1 and ((count_alive < 2) or (count_alive > 3)):
                    board[i][j] = 3
                if board[i][j] == 0 and (count_alive == 3):
                    board[i][j] = 2
        
        for i in range(m):  # using nested loops we substitute the values for 3 and 2 with 0 and 1 respectively
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1