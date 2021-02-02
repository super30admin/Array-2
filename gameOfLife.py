#TimeComplexity:O(MN) 
#SpaceComplexity: Constant Space (No extra space taken).
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        def Count(board,i,j,m,n):
            N=[[i-1,j-1],[i-1,j],[i-1,j+1],[i,j+1],[i+1,j+1],[i+1,j],[i+1,j-1],[i,j-1]]
            count=0
            for K in N:
                if K[0]>=0 and K[1]>=0 and K[0]<m and K[1]<n and (board[K[0]][K[1]]==1 or board[K[0]][K[1]]==2) :
                    count+=1
            return count
        m=len(board);n=len(board[0])
        for i in range(m):
            for j in range(n):
                count=Count(board,i,j,m,n)
                if board[i][j]==1 :
                    if count<2 or count>3:                     
                        board[i][j]=2
                if board[i][j]==0 :
                    if count==3:
                        board[i][j]=3

        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                if board[i][j]==3:
                    board[i][j]=1
        return board
        
