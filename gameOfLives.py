"""
//Time Complexity : O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""




class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if len(board)==0:
            return 
        m = len(board)
        n=len(board[0])
        #1-->0 ==2
        #0-->1 == 3
        
        for i in range(0,m):
            for j in range(0,n):
                count = self.countLives(board,i,j,m,n)
                #1.rule if count is less than 2 and greater than 2 replace it with 0.
                if (board[i][j]==1 and (count<2 or count >3)):
                    board[i][j] = 2
                if (board[i][j]==0 and (count==3)):
                    board[i][j] = 3
        for i in range(0,m):
            for j in range(0,n):
                if(board[i][j]==3):
                    board[i][j]=1
                if(board[i][j]==2):
                    board[i][j] =0
    def countLives(self,board,i,j,m,n):
            result = 0
            dirs = [[0,1],[-1,0],[1,0],[0,-1],[1,1],[-1,-1],[-1,1],[1,-1]]
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                if (r>=0 and r<m and c>=0 and c<n and(board[r][c]==1 or board[r][c]==2)):
                    result+=1
            return result
            
        