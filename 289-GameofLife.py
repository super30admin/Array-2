#Time Complexity : O(m * n) where m is number of row and n is number of columns
# Space Complexity : O(1) as we are using input array for output also
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
    def getCount(board,r,c,m,n):
        # Directins for right,left,top,botoom,lefttop,righttop,leftbottom,rightbottom
        dirs = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
        total = 0
        for k in dirs:
            nr = r+k[0]
            nc = c+k[1]

            if (nr >= 0 and nr < m and nc >=0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                total = total + 1
        return total
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        # 1 --> 0 === 2
        # 0 --> 1 === 3
        for i in range(0,m):
            for j in range(0,n):
                countLiveCells = Solution.getCount(board,i,j,m,n) 
                if board[i][j] == 1:
                    if countLiveCells < 2 or countLiveCells > 3:
                        board[i][j] = 2
                else:
                    if countLiveCells == 3:
                        board[i][j] = 3
                        
        
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:   
                    board[i][j] = 1
                    
        return board     
    
    