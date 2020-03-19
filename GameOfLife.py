# -*- coding: utf-8 -*-
"""
Created on Thu Feb  6 14:29:53 2020

@author: WELCOME
"""
"""
Game of Life
Time - O(m*n)
Space - O(1)
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        directions=((0,1),(1,0),(1,1),(-1,-1),(-1,0),(0,-1),(1,-1),(-1,1))
        def liveNeighbours(row,column):
            count=0
            for dirs in directions:
                newRow=row+dirs[0]
                newColumn=column+dirs[1]
                if newRow>=0 and newRow<len(board) and newColumn>=0 and newColumn<len(board[0]) and (board[newRow][newColumn]==1 or board[newRow][newColumn]==-1):
                    count+=1
            return count
                    
                
            
            
        for i in range(len(board)):
            for j in range(len(board[0])):
                num=liveNeighbours(i,j)
                if (board[i][j]==0 and num==3):
                    board[i][j]=2
                elif (board[i][j]==1 and num<2):
                    board[i][j]=-1
                elif (board[i][j]==1 and (num>3)):
                    board[i][j]=-1
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=1
                elif board[i][j]==-1:
                    board[i][j]=0