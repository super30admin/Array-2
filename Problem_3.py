# Game of Life

# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 16 ms and Memory Usage: 13.6 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Following the rules of iteration as in problem making sure that initial state of the input while processing the board cells
is not lost new constants can be taken indicating value transitions. When 0 -> 1, it is put as 2 and 1->0 is put as 3. 
This way,from 2, we imput 0 for the current state and 1 for change of state,
which is going to be output.

"""
class Solution(object):
    def __init__(self):
        self.m=0
        self.n=0
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if (len(board)==0 or board==None): # Edge Cases
            return 
        i=0
        j=0
        lives=0
        self.m=len(board)-1
        self.n=len(board[0])-1
        def countLives(board,i,j,m,n): # this function will count live cells amongst 8 neighbours
            count=0  # return live count 
            neighbors=[[-1,1],[0,1],[1,1],[-1,0],[1,0],[-1,-1],[0,-1],[1,-1]] # directions
            for direction in neighbors:
                r=0
                c=0
                r=i+direction[0] 
                c=j+direction[1] 
                if r>=0 and r <=m and c>=0 and c<=n:  # check bounds for neighbour
                    # if neighbour is live or was live before consider previous live cells as well
                    if board[r][c]==1 or board[r][c]==3:
                        count+=1  
            return count
        
        for i in range(self.m+1):
            for j in range(self.n+1):
                # going to function to get count/live neighbours
                liveCells=countLives(board,i,j,self.m,self.n)
                if board[i][j]==1 and (liveCells<2 or liveCells>3): # rule 1,3
                    board[i][j]=3
                elif board[i][j]==0 and liveCells==3:     # rule 4
                    board[i][j]=2
                # rule 2: live stays live so no change
    
        for i in range(self.m+1):         # get new array
            for j in range(self.n+1):
                if board[i][j]==3: 
                    board[i][j]=0
                elif board[i][j]==1 or board[i][j]==2:
                    board[i][j]=1
        