"""
// Time Complexity : o(m*n), m = rows and n = columns
// Space Complexity : o(1), in-place
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
class Solution:
    def count_live(self, board, i,j): #gives the count of living neighbour cells
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[1,1],[1,-1],[-1,1]] #array for simple navigation along all directions
        ct = 0
        
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            
            if r >= 0 and c >= 0 and r < len(board) and c < len(board[0]) and (board[r][c] == 1 or board[r][c] == 3): #counts the living neighbours
                ct +=1
        return ct
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        r = len(board)
        c = len(board[0])
        #1 --> 0: 3
        #0 --> 1: 2
        for i in range(r):
            for j in range(c):
                live = self.count_live(board, i, j) #
                
                if board[i][j] == 1 and (live < 2 or live > 3): #if earlier alive and number of neighbours less than 2 or more than 3, then change to dead
                    board[i][j] = 3 #now dead
                    
                elif board[i][j] == 0 and live == 3: #if earlier dead and number of neighbours exactly equal to 3, then change to alive
                    board[i][j] = 2 #now alive

        # for resultant matrix, convert all 3's to 0 and 2's to 1             
        for i in range(r):
            for j in range(c):
                if board[i][j] == 3: 
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1