"""
https://leetcode.com/problems/game-of-life/

Time Complexity : O(m * n) where m is number of rows and n is the number of cols in board
Space Complexity : O(1) as no auxillary data structure is used
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
1. As we have to go to the 8 directions we will create an array of 8 directions
2. Every time we will traverse we will check the boundary condition, If the rows and cols are valid, we will keep a count of number of 1s.
3. In the first pass, if original number is 1 and number of 1s are either 2 or 3 then 1 will remain 1 else 1 -> -2. Similary for the dead cell if number of 1s are 3 then 0 -> -3
4. In the second pass we will simply change -2 -> 0 and -3 -> 1
"""

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board) #number of rows
        n = len(board[0]) #number of cols

        directions = [[-1,0], [-1, 1], [0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1] ]
        
        #Replace 1->0 with -3 and 0->1 with -2
        for i in range(m):
            for j in range(n):
                countof1 = 0
                for dire in directions:
                    row = i + dire[0]
                    col = j + dire[1]
                    if row >= 0 and row < m and col >= 0 and col < n:
                        if board[row][col] == 1 or board[row][col] == -3:
                            countof1 += 1
                if board[i][j] == 0 or board[i][j] == -2:
                    if countof1 == 3:
                        board[i][j] = -2
                elif board[i][j] == 1 or board[i][j] == -3:
                    if countof1 == 2 or countof1 == 3:
                        board[i][j] = 1
                    else:
                        board[i][j] = -3
        
        #Replace -2 with 1 and -3 with 0:
        for i in range(m):
            for j in range(n):
                if board[i][j] == -2:
                    board[i][j] = 1
                elif board[i][j] == -3:
                    board[i][j] = 0