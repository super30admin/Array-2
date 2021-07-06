class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #Time O(mn)
        #Space O(mn)
        #Haven't done the followup question of not using any extra space
        #https://leetcode.com/problems/game-of-life/
        #Also, we are not returning anything as in leetcode it is automatically done
        liveCells=dict()
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j]==1:
                    liveCells[tuple([i,j])]=True
        direction=[(-1,0),(1,0),(0,-1),(0,1),(-1,-1),(-1,1),(1,-1),(1,1)]
        for i in range(m):
            for j in range(n):
                live=0
                for x,y in direction:
                    if 0<=i+x<m and 0<=j+y<n and tuple([i+x,j+y]) in liveCells:
                        live+=1
                
                if live<2 and board[i][j]==1:
                    board[i][j]=0
                
                elif live>3 and board[i][j]==1:
                    board[i][j]=0
                elif live==3 and board[i][j]==0:
                    board[i][j]=1
                    
