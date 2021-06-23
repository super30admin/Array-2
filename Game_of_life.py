from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        directions = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]        
        for i in range(len(board)):
            for j in range(len(board[0])):
                # live neighbors count
                live = 0                
                for x, y in directions: 
                    # checking and counting neighbors in all directions
                    if ( i + x < len(board) and i + x >= 0 ) and ( j + y < len(board[0]) and j + y >=0 ) and abs(board[i + x][j + y]) == 1:
                        live += 1
                # Rule 1 or Rule 3 defined if live <2 and live > 3 change live to dead 
                if board[i][j] == 1 and (live < 2 or live > 3):     
                    board[i][j] = -1
                # Rule 4 defined if live neighbors equals to 3 change dead to live
                if board[i][j] == 0 and live == 3:                  
                    board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = 1 if(board[i][j] > 0) else 0
        return board

obj = Solution()

board =[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]

print(obj.gameOfLife(board))


#This problem is based on the cellular automata having a m*n matrix with 0 as dead 1 as live and solved with four rules.
#Solving the problem inplace manipulation changing values by adding and subtracting 2 to change the state as per rules.
#Time complexity - O(M*N)
#Space complexity - O(1)


#directions = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]