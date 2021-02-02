
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def countLives(self,board,i,j,n,m) -> int:          //check for all the 8 neighbors to find the number of live elements 
        nums=[(-1,-1),(-1,0),(-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        cnt=0
        for num in nums:
            row=i+num[0]
            col=j+num[1]
            if row>=0 and row<n and col>=0 and col<m and (board[row][col]==1 or board[row][col]==2) :
                cnt+=1
        return cnt
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board==None or len(board)==0 or len(board[0])==0:
            return
        n=len(board)
        m=len(board[0])
        
        #2: means alive-> dead
        #3: means dead ->alive
        
        for i in range(n):
            for j in range(m):
                cnt=self.countLives(board, i, j, n, m)
                if board[i][j]==1 and (cnt> 3 or cnt<2):      //condition 1 and condition3
                    board[i][j]=2
                elif board[i][j]==0 and cnt==3:     //condition 4
                    board[i][j]=3
                    
        for i in range(n):
            for j in range(m):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
        
        return board
