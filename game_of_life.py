# // Time Complexity :O(m.n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        #Ostate Nstatew tempState
        #0          0       0
        #1          1       1
        #0          1       -1
        #1          0       -2       
        
        directions=[
                    (-1,-1), #leftup
                    (-1,0), #up
                    (-1,1), #rightup
                    (0,1),  #right
                    (1,1),  #rightdown
                    (1,0),  # down
                    (1,-1), #leftdwn
                    (0,-1)  #left
                   ]
        def countNeighbours(board,i,j):
            m=len(board)
            n=len(board[0])
            livecount=0
            for d in directions:
                x=i+d[0]
                y=j+d[1]
                #check boundry conditions
                if (x>=0 and x<m and y>=0 and y<n):
                    if board[x][y]== -2 or board[x][y]==1:
                        livecount+=1
            return livecount
        
        
        m=len(board)
        n=len(board[0])
           #step 1 to convert the state after visiting the original grid 
        for i in range(m):
            for j in range(n):
                tempcount= countNeighbours(board,i,j)
                
                #curren live
                if board[i][j]==1:
                    #check if live count for this state is <2 or >3
                    if tempcount > 3 or tempcount<2:
                        #so make cell dead
                        board[i][j]=-2
                    
                else:
                    #current dead
                    if tempcount == 3:
                        #make it alive
                        board[i][j]=-1
            #step2 for updating grid based on new state            
        for i in range(m):
            for j in range(n):
                
                if board[i][j]==-1:
                    board[i][j]=1
                    
                if board[i][j]== -2:
                    board[i][j]=0
                