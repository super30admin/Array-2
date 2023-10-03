#Time Complexity : O(m*n) since we iterate through the matrix
#Space Complexity : O(1) since we are not using any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: Using the directions array we can check the neighbours of a particular index in the matrix. Using this directions array
# we check the number of alive neighbouring cells. Since we dont use any extra space, we change the value in the same matrix. We use
# indicators for the same (1 -> 0 = 3 and 0 -> 1 = 2). Once we have the count of alive neighbouring cells, we check the given conditions
# and change the state using indicators within the same matrix. We again iterate through the matrix and change the state back to normal 
#(i.e. 2 -> 1 and 3 -> 0)

class Solution:
    #       down      up      right   left  downright  upleft  downleft  upright
    dirs = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)]
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 1 -> 0 = 3
        # 0 -> 1 = 2
        for i in range(m):
            for j in range(n):
                countAlive = self.countAlive(board, i, j, m, n)
                if(board[i][j] == 1 and (countAlive < 2 or countAlive > 3)):
                    board[i][j] = 3
                if(board[i][j] == 0 and countAlive ==3):
                    board[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3: board[i][j] = 0
                if board[i][j] == 2: board[i][j] = 1

    def countAlive (self, board, i, j, m, n):
        count = 0
        for dirr in self.dirs:
            nr = i + dirr[0]
            nc = j + dirr[1]
            if (nr >= 0 and nc >=0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3)):
                count += 1
        
        return count