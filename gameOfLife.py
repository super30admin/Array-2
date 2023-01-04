# Time Complexity :O(m*n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No


class Solution(object):
    def alive_count(self,board,m,n,i,j):
        dirr=[[0,1],[1,0],[0,-1],[-1,0],[1,1],[-1,-1],[-1,1],[1,-1]]
        count=0
        for l in dirr:
            r=i+l[0]
            c=j+l[1]
            if(c>=0 and r<m and r>=0 and c<n and (board[r][c]==1 or board[r][c]==2)):
                count+=1
        return count
    
    
    def gameOfLife(self, board):
        # 1->0 2
        # 0->1 3
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                alive_count=self.alive_count(board,m,n,i,j)
                if(board[i][j]==1 and (alive_count <2 or alive_count>3)):
                    board[i][j]=2
                elif(board[i][j]==0 and alive_count==3):
                    board[i][j]=3
        for i in range(m):
            for j in range(n):
                board[i][j]=board[i][j]%2          
       
        return board