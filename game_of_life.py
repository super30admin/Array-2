#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 21:12:47 2021

@author: ameeshas11
"""


#Time Complexity : O(mn)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def __check_rule(self, val, live, dead):
        if val == 1:
            if live>3 or live<2:
                return 3
            else:
                return val
        else:
            if live==3:
                return 2
            else:
                return val
    
    def __count(self, board, i, j, r, c):
        l1 = [-1, -1, -1, 0, 0, 1, 1, 1]
        l2 = [-1, 0, 1, -1, 1, -1, 0, 1]
        live = 0
        dead = 0
        for k in range(8):
            if i+l1[k]>-1 and i+l1[k]<r and j+l2[k]>-1 and j+l2[k]<c:
                if board[i+l1[k]][j+l2[k]] == 1 or board[i+l1[k]][j+l2[k]] == 3:
                    live +=1
                else:
                    dead +=1
        return live, dead
                
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        live = 0
        dead = 0
        r = len(board)
        c = len(board[0])
        
        for i in range(r):
            for j in range(c):
                live, dead = self.__count(board, i, j, r, c) 
                board[i][j] = self.__check_rule(board[i][j], live, dead)
                
        for i in range(r):
            for j in range(c):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        
        