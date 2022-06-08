# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
# counting the total number of 1's of the neighbours of an element using count function
# defined all the directions in dir list.
# iterating through each element in the board and finding count and changing it to 2(0-->1), 3(1-->0) to save the previous state.
# once done with all elements in the array, re-iterate through the array and change all 2 -- > 1, 3 --> 0


class Solution:
    def count(self, board, i, j, dir, m, n):
        count = 0
        for x in dir:
            row = i + x[0]
            column = j + x[1]
            if 0 <= row < m and 0 <= column < n and (board[row][column] == 1 or board[row][column] == 3):
                count += 1
        return count

    def gameOfLife(self, board: list[list[int]]) -> list[list[int]]:
        """
        Do not return anything, modify board in-place instead.
        """
        dir = [(0, -1), (0, 1), (-1, 0), (-1, -1), (-1, 1), (1, 0), (1, 1), (1, -1)]
        m = len(board)
        n = len(board[-1])
        for i in range(m):
            for j in range(n):
                count = self.count(board, i, j, dir, m, n)
                if count < 2 and (board[i][j] == 1 or board[i][j] == 3):
                    board[i][j] = 3
                elif count > 3 and (board[i][j] == 1 or board[i][j] == 3):
                    board[i][j] = 3
                elif count == 3 and (board[i][j] == 0 or board[i][j] == 2):
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        return board


check = Solution()
print(check.gameOfLife([[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]))
