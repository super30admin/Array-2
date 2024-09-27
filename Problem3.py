
// Time Complexity : O(mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Count all the neighbour elements live status and based on the rules modify the live status with ne values (2,3) to distinguish between the old and new live status
class Solution(object):
    
    def helper(board,i,j):
            lives = 0
            
            for k in range(len(dir)):
                
                   if((i+dir[0])<0 or (i+dir[0])>=rows or (j+dir[1])<0 or (j+dir[1])>=cols):
                          continue
                        
                    if(board[i+dir[0]][j+dir[1]]==1 or board[i+dir[0]][j+dir[1]]==2):
                        lives +=1
                        
                       
                     if(board[i][j]= 1 and (lives<2 or lives> 3)):
                            board[i][j] = 2
                            
                    if(board[i][j]==0 and lives == 3) :
                        board[i][j] = 3
                        
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        dir = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]
        rows = len(nums)
        cols = len(nums[0])
        res = []
        for i in range(len(cols)):
            col = []
            for j in range(len(rows)):
                col.append(0)
                
            res.append(col)
            
        for i in range(len(nums[rows])):
            
            for j in range(len(cols)):
                
                helper(board,i,j)
            
            
        
          return board             
                     
                        
                
                
                
        
