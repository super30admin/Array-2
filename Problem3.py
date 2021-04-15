## Problem3 (https://leetcode.com/problems/game-of-life/)
# Time Complexity - O(n^2)
# Space Complexity - O(1) - making the changes in place

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return None
        m = len(board)
        n = len(board[0])
        # 1 - 0 => 2
        # 0 - 1 => 3
        i = 0
        j = 0
        def countlives(board, r, c):
            direction = [(0,1), (1,1), (1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1)]
            count = 0
            for dirr in direction:
                row = r + dirr[0]
                col = c + dirr[1]
                if(row >= 0 and row < m and col >=0 and col < n):
                    if(board[row][col] == 1 or board[row][col] == 2):
                        count += 1
            return count
        
        for i in range(m):
            for j in range(n):
                livecount = countlives(board,i,j)
                #rules
                if(board[i][j] == 1 and (livecount < 2 or livecount > 3)):
                    board[i][j] = 2
                elif(board[i][j] == 0 and livecount == 3):
                    board[i][j] = 3


        # convert it back from 2,3 to 0,1 respectively
        for i in range(m):
            for j in range(n):
                if(board[i][j] == 2):
                    board[i][j] = 0
                elif(board[i][j] == 3):
                    board[i][j] = 1
        
    
            
                
        
        
        
