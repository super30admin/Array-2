# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
If as per the conditions, element goes from 1 -> 0, we write it as 2
If as per the conditions, element goes from 0 -> 1, we write it as 3

Above is done to maintain the 0 and 1 value while calculating the
new value for all the elements of the matrix.

And then, we replace 2 with 0 and 3 with 1
"""
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])


        for i in range(0,m):
            for j in range(0,n):
                countOnes = self.countOnes(board,i,j,m,n)
                if board[i][j] == 1 and (countOnes < 2 or countOnes > 3):
                    # 1 to 0
                    board[i][j] = 2
                if board[i][j] == 0 and countOnes == 3:
                    # 0 to 1
                    board[i][j] = 3
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1


    def countOnes(self, board, i, j,m,n):
        count = 0

        dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]

            if 0 <= nr < m and 0 <= nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count += 1

        return count