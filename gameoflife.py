# Time Complexity : log(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, in edge cases
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
		# Do not return anything, modify board in-place instead.
		# """

#         1 -> 0 = -1 ( consider while neighbour counting one's)
#         0 -> 1 = -2 (don't consider while neighbour counting one's
        for row in range(len(board)):
            for column in range(len(board[0])):
                neighbour_count = 0
                val = board[row][column]
                for r,c in [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]:
                    if 0 <= row+r<len(board) and 0 <= column+c < len(board[0]):
                        new_row, new_column = row+r,column+c
                        if abs(board[new_row][new_column]) == 1:
                            neighbour_count += 1
                if neighbour_count < 2 and abs(val) == 1:
                    board[row][column] = -1
                elif neighbour_count > 3 and abs(val) == 1:
                    board[row][column] = -1
                elif neighbour_count == 3 and abs(val) == 0:
                    board[row][column] = -2

#       converting all -1 to 0
#       converting all -2 to 1
        for row in range(len(board)):
            for column in range(len(board[0])):
                if board[row][column] == -1:
                    board[row][column] = 0
                elif board[row][column] == -2:
                    board[row][column] = 1