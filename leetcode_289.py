#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:51:29 2026

@author: rishigoswamy

    LeetCode 289: Game of Life
    Link: https://leetcode.com/problems/game-of-life/

    Approach:
    In-place update using temporary state encoding.

    We must update all cells simultaneously, so we cannot overwrite a cell
    and lose its original state while counting neighbors.

    Use encoded transitions:
        -1 : Live (1)  -> Dead (0)
         2 : Dead (0)  -> Live (1)

    While counting live neighbors, use:
        abs(board[r][c]) == 1
    because:
        1  (live) stays live
       -1 (live -> dead) was originally live

    Steps:
        1. Precompute 8 directions.
        2. First pass: apply rules and mark transitions using -1 and 2.
        3. Second pass: finalize values (-1 -> 0, 2 -> 1).

    // Time Complexity : O(m * n)
        For each cell, we check up to 8 neighbors.
    // Space Complexity : O(1)
        In-place transformation (no extra matrix needed).
"""

from typing import List

class Solution:
    def gameRules(self, aliveCount):
        return True
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        stateMatrix = []
        for i in range(0, len(board)):
            stateMatrix.append([0]* len(board[0]))
        
        directions = []
        for i in range(-1,2):
            for j in range(-1,2):
                if i== 0 and j==0:
                    continue
                directions.append([i,j])

        # Live -> Dead = -1
        # Dead -> Live = 2


        for i in range(0, len(stateMatrix)):
            for j in range(0, len(stateMatrix[0])):
                count = 0
                for direction in directions:
                    row = i + direction[0]
                    col = j + direction[1]
                
                    if 0 <= row and row < len(board) and 0 <= col and col < len(board[0]):
                        if abs(board[row][col]) == 1:
                            count+=1
                
                if board[i][j] == 1 and count < 2:
                    board[i][j] = -1
                elif board[i][j] == 1 and count in (2,3):
                    board[i][j] = 1
                elif board[i][j] == 1 and count > 3:
                    board[i][j] = -1
                elif board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == -1:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1