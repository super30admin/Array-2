# Time Complexity : O (m * n) because we are traversing through the complete matrix
# Space Complexity : O(1) because we are changing the values in the same array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# since we do not want to create a separate array, we are changing the given matrix
# the rules are for every live cell -> if the no of live neighbours < 2 or > 3, the cell will change to 0
# for a 0 cell, if no of live neighbours = 3, then the cell changes to 1
# but if we change the 1s to 0s, then it will hinder in counting our live neighbours
# so we have to change 1 -> 0, we change it to 2 instead
# and if we have to change 0 -> 1, we change to 3 instead
# and while counting live neighbours, we count 1ns and 2s (because the 2 was originally 1)
# 1 - 0 = 2
# 0 - 1 = 3

class Solution(object):
    

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if board is None:
            return None
        # no of rows
        n = len(board)

        # iterating through the board
        for i in range(n):
            for j in range(len(board[0])):
                # counting no if live neighbours
                count = self.countLiveNeighbours(i, j, board)
                # if the current cell is a live cell
                if board[i][j] == 1:
                    # based on the given rule, it changes to 0
                    # but we are changing it to 2 for now
                    if count < 2 or count > 3:
                        board[i][j] = 2
                # if the current cell is a dead cell
                elif board[i][j] == 0:
                    # based on the given rule, it changes to 1
                    # but we are changing it to 3 for now
                    if count == 3:
                        board[i][j] = 3
        # since we have to return the original array, we change back the 2s and 3s
        for i in range(n):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    # counting the live neighbours
    def countLiveNeighbours(self, i, j, board):
        # array for the indices of all possible 8 neighbours
        dirs = [[-1,0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        count = 0
        for dir in dirs:
            # the new indices based on the indicies array that we will traverse
            nr = i + dir[0]
            nc = j + dir[1]
            # if the calculated index is less than 0, for example, the condition will fail
            # so we are dong edge case checks on the new row/ new column index instead of i and j
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]):
                # if the neighbour cell is 1 or 2, then it is a live cell => count++
                if board[nr][nc] == 1 or board[nr][nc] == 2:
                    count += 1

        return count
                
 

        
        