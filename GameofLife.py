// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    
    def countAlive(self,board,i,j,n,m): # to find the number of alive persons
        dirs=[(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)] #all 8 directions
        count =0
        for dir in dirs: # iterating through all 8 directions for every index
            r=dir[0]+i
            c=dir[1]+j
            if (r>=0 and r<n) and (c>=0 and c<m) and (board[r][c]==1 or board[r][c]==2):
                count+=1
        return count # return count of neighbouring elements
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board)==0 or len(board[0])==0:
            return
        n=len(board)
        m=len(board[0])
        for i in range(n):
            for j in range(m):
                alive=self.countAlive(board,i,j,n,m)
                if board[i][j]==1 and (alive<2 or alive>3): # using count change state
                    board[i][j]=2
                elif board[i][j]==0 and alive==3:
                    board[i][j]=4

        for i in range(n):
            for j in range(m):
                if board[i][j]==2: # change to original state based on changed states
                    board[i][j]=0
                elif board[i][j]==4:
                    board[i][j]=1
            
            

                