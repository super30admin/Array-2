    # Time Complexity : O(m*n)
    # Space Complexity : O(m*n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def countAlive(board, i, j, m, n):
            directions = [[0,1], [1,0], [0,-1], [-1,0], [1,1], [-1,-1], [-1,1], [1,-1]]
            count = 0

            for d in directions:
                row = i + d[0];
                col = j + d[1];

                if row>=0 and row<m and col>=0 and col<n and (board[row][col] ==1 or board[row][col] ==2):
                    count += 1

            return count

        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = countAlive(board, i, j, m, n)
                print(count)
                if board[i][j] == 1 and (count<2 or count>3):
                    board[i][j] = 2
                    
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j]= 0

                if board[i][j] == 3:
                    board[i][j]= 1
        
        return board
