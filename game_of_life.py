# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : No
# // Any problem you faced while coding this :
# Pretty hard in python and was not able to code neighbor function


# // Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows=len(board)
        cols=len(board[0])
        
        directions = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[1,1],[1,-1],[-1,1]]
        def neighbors(r,c):
            n=0
            for i in directions:
                nr=r + directions[i][0]
                nc=c+ directions[i][1]
                
                if nc>=0 and nr<=0 and nr<rows and nc<cols and (board[nr][nc]==1 or board[nr][nc]==3):
                    n+=1
        
            return n
        
                ## I was not able to understand this function and run in python
        
        for r in range(rows):
            for c in range(cols):
                n=neighbors[r,c]
                if board[r][c]==1:
                    if board[r][c] in [2,3]:
                        board[r][c]=3
                    else:
                        board[r][c]=1
                
                else:
                    if n==3:
                        board[r][c]==2
                    else:
                        board[r][c]==0
                        
        
        for r in range(rows):
            for c in range(cols):
                if board[r][c]==1:
                    board[r][c]=0
                
                elif board[r][c] in [2,3]:
                    board[r][c]=1