class Solution(object):
    def __init__(self):
        self.m=0
        self.n=0
    #classic state change problem
    #O(1) space
    #O(N^2) time as anyways direction array loop is O(8) constant
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if len(board)==0:
            return 
        i=0
        j=0
        lives=0
        self.m=len(board)-1
        self.n=len(board[0])-1
        #function to find live cells amongst 8 neighbours
        def findlive(board,i,j,m,n):
            live=0
            #direction array>>hor+ver+diagonal
            dirs=[[-1,1],[0,1],[1,1],[-1,0],[1,0],[-1,-1],[0,-1],[1,-1]]
            for diri in dirs:
                r=0
                c=0
              ` #for every direction, change coordinate of your test cell to get neighbour in that dir
                r=i+diri[0]
                c=j+diri[1]
                #check bounds for neighbour 
                if r>=0 and r <=m and c>=0 and c<=n:
                    #if neighbour is anyways live or was live before
                    ##very very important to consider previous live cells as well
                    if board[r][c]==1 or board[r][c]==3:
                        live+=1
            #return live count   
            return live
        
        for i in range(self.m+1):
            for j in range(self.n+1):
                #go to function to get live neighbours
                lives=findlive(board,i,j,self.m,self.n)
                #rule 1,3
                if board[i][j]==1 and (lives<2 or lives>3):
                    board[i][j]=3
                #rule 4
                elif board[i][j]==0 and lives==3:
                    board[i][j]=2
                #rule 2:
                #no need to check as live stays live only>> no change
                
        #get modified array
        for i in range(self.m+1):
            for j in range(self.n+1):
                #state changes to original
                if board[i][j]==3:
                    board[i][j]=0
                elif board[i][j]==1 or board[i][j]==2:
                    board[i][j]=1
        
                
                
                    
        
                
                    