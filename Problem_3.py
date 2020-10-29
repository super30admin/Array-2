"""
Time Complexity : O(m*n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This question follows state change pattern. At every point, we will calculate living neighbors (by iterating
through the direction array). As we have to change the state simultaneously at every cell, we have choosen 2 and
3 respectively for to be living and to be dead cell.
"""


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # 0-->1 :2
        # 1-->0 :3
        if not board:
            return None
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = self.liveneighbors(board, i, j)
                if board[i][j] == 1 and (count > 3 or count < 2):
                    board[i][j] = 3
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        return board

    def liveneighbors(self, board, i, j):
        count = 0
        array = [(-1, -1), (-1, 0), (-1, 1), (0, 1),
                 (1, 1), (1, 0), (1, -1), (0, -1)]
        for a in array:
            row = i+a[0]
            col = j+a[1]
            if 0 <= row < len(board) and 0 <= col < len(board[0]) and (board[row][col] == 1 or board[row][col] == 3):
                count += 1
        return count
