# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : NA
#   
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        res=board
        m=len(board)
        n=len(board[0])
        surround=[(0,-1),(-1,-1),(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1)]

        for i in range(m):
            for j in range(n):
                live_around=0
                for s in surround:
                    r=i+s[0]
                    c=j+s[1]

                    if r<m and r>=0 and c<n and c>=0 and abs(board[r][c])==1:
                        live_around+=1
                    
                if board[i][j]==0 and live_around==3:
                    board[i][j]=2
                
                if board[i][j]==1 and (live_around>3 or live_around<2):
                    board[i][j]*=-1

        for i in range(m):
            for j in range(n):
                if board[i][j]<=0:
                    board[i][j]=0
                else:
                    board[i][j]=1

