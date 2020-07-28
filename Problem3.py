## Problem3 (https://leetcode.com/problems/game-of-life/)

#Time Complexity : O(n*m) m and n are dimensions of board.
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        columns=len(board[0])
        for i in range(rows):
            for j in range(columns):
                live=0

                # check for top element

                if i>0 and (board[i-1][j]==1 or board[i-1][j]==2):
                    live+=1

                #check for bottom element

                if i<rows-2 and(board[i+1][j]==1 or board[i+1][j]==2):
                    live+=1

                # check for right element
                if j<columns-2 and (board[i][j+1]==1 or board[i][j+1]==2):
                    live+=1

                # check for left element
                if j>0 and (board[i][j-1]==1 or board[i][j-1]==2):
                    live+=1

                # check for right bottom diagonal element
                if i < rows - 1 and j < columns - 1 and (board[i + 1][j + 1] == 1 or board[i + 1][j + 1] == 2):
                    live += 1

                # check for top left diagonal element
                if i > 0 and j > 0 and (board[i - 1][j - 1] == 1 or board[i - 1][j - 1] == 2):
                    # check for top left diagonal element
                    live+=1

                # check for top right diagonal element
                if i > 0 and j < columns - 1 and (board[i - 1][j + 1] == 1 or board[i - 1][j + 1] == 2):
                    live += 1


                # check for bottom left diagonal element
                if i < rows - 1 and j > 0 and (board[i + 1][j - 1] == 1 or board[i + 1][j - 1] == 2):
                    live += 1

                if board[i][j] == 1:
                    if live < 2:
                        board[i][j] = 2
                    elif live > 3:
                        board[i][j] = 2
                else:
                    if live == 3:
                        board[i][j] = 3

        for i in range(rows):
            for j in range(columns):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
                    
        return board

