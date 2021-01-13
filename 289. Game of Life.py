# // Time Complexity : O(mn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
   # Create a helper function that computes the no of live cells around a given cell
   # Make the transition of the state as 0-1 = 2 and 1-0 = 3 so as this can be identified 
   # in the further cells
   
   # Code the correspi=onding rules using ifs



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        
        m = len(board)
        n = len(board[0])
        
        def livingcount(board,i,j):
            dirs = [[-1,-1],[-1,0],[-1,1],[0,-1],
                    [0,1],[1,-1],[1,0],[1,1]]
            count = 0
            for direction in dirs:
                r = i + direction[0]
                c = j + direction[1]

                if(r >= 0 and c >= 0  
                   and
                   r < m and c < n 
                   and
                   (board[r][c] == 1 or board[r][c] == 2)):
                    count += 1
            return count

        for i in range(m):
            for j in range(n):
                count = livingcount(board,i,j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if count == 3 and board[i][j] == 0:
                    board[i][j] = 3
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 2:
                    board[i][j] = 0