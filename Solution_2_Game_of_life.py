// Time Complexity : O(m*n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


'''
1. We can calculate the count lives using a function and update
   number of lives in a new matrix
   TC and SC for this approach is O(m*n) and O(m*n)

2. To do this in Constant space, we will use variables to remember 
   state change.
   
3. I am using (1-->0  variable 4) and (0-->1  variable 5)
   cs  ns    lives
   1    0      n<2
   1    1      n=2or 3
   1    0      n>3
   0    1      n=3
   
4. Change 4,5 to 0,1 in the end.
'''







class Solution:
    def alive_count(self,i,j,m,n,board):
        
        d=[[-1,-1],[-1,0],[-1,1],
           [0,-1],[0,1],
           [1,-1],[1,0],[1,1]
          ]
        
        ck=0
        for k in d:
            x,y=i+k[0],j+k[1]
            if  (x>=0 and x<m) and (y>=0 and y<n):
                
                if (board[x][y]==1 or board[x][y]==4):
                    ck=ck+1
 
        
        return ck
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m=len(board)
        n=len(board[0])
        
        #  1 --> 0  4
        #  0 --> 1  5
        
        for i in range(0,m):
            for j in range(0,n):
                
                c=self.alive_count(i,j,m,n,board)
                
                #alive
                if (board[i][j]==1) and (c<2 or c>3):
                    board[i][j]=4
                    
                #dead
                if (board[i][j]==0 ) and c==3:
                    board[i][j]=5
                    
        print(board)
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j]==4:
                    board[i][j]=0
                
                elif board[i][j]==5:
                    board[i][j]=1
        