# Time Complexity : O(n^2)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to check the value in all 8 directions and make the value as 0 or 1 based on the condition given.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        m,n = len(board),len(board[0])
        newboard = copy.deepcopy(board);
        # tl,tc,tr,cr,br,bc,bl,cl
        directions = [[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1]]
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                count = 0
                for dir in directions:
                    x = i+dir[0]
                    y = j+dir[1]
                    if( x >= 0 and y >=0 and x < m and y < n):
                        if(board[x][y] == 1 ):  count += 1
                if(board[i][j] == 1 and (count<2 or count >3 ) ):
                        newboard[i][j] = 0
                elif(board[i][j] == 0 and count == 3 ):
                        newboard[i][j] = 1
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                board[i][j] = newboard[i][j]