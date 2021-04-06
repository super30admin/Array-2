# -*- coding: utf-8 -*-
"""
Created on Tue Apr  6 11:21:03 2021

@author: jgdch
"""

#Time complexity: O(MN), M is the nnumber of rows, N is the number of coulumns
#Space complexity:O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
       
        direction = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]

        rows = len(board)
        cols = len(board[0])

        for row in range(rows):
            for col in range(cols):

                live = 0
                for direc in direction:

                    r = (row + direc[0])
                    c = (col + direc[1])

                    if (r < rows and r >= 0) and (c < cols and c >= 0) and abs(board[r][c]) == 1:
                        live+= 1

                if board[row][col] == 1 and (live < 2 or live> 3):
                    board[row][col] = -1
                if board[row][col] == 0 and live== 3:
                    board[row][col] = 2

        for row in range(rows):
            for col in range(cols):
                if board[row][col] > 0:
                    board[row][col] = 1
                else:
                    board[row][col] = 0