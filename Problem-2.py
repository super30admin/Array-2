# Time Complexity :O(m*n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                #for each entry calculate number of neighbours = 1
                neighbors = self.getNeighbors(i,j,board,m,n)
                #do the rules of the game but if 1 and going to be zero change to 3 and if 0 and going to be one change to 2
                if neighbors <2 or neighbors >3:
                    if board[i][j] == 1:
                        board[i][j] = 3
                elif neighbors == 3:
                    if board[i][j] == 0:
                        board[i][j] = 2
        #change all 3 to 0 and all 2 to 1
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
                    
    def getNeighbors(self,i,j,board,m,n):
        positions = [(-1,0),(1,0),(0,-1),(0,1),(-1,-1),(-1,1),(1,1),(1,-1)]
        neighbors = 0
        for position in positions:
            x = position[0]+i
            y = position[1]+j
            
            if (x >=0) and (x <m) and (y >=0) and (y <n):
                if board[x][y] == 1 or board[x][y] == 3:
                    neighbors+=1
        return neighbors