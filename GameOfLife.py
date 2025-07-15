# Time Complexity : It is O(m*n) since we are iterating with the m*n matrix.
# Space Complexity : It is O(1) since no extra space.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List
class Solution:
    def boardCheck(self,board,row, col):
        # created the list to iterate through all the 8 neighbours
        neighbour = [[-1,-1],[-1,0],[-1,1],[1,-1],[1,0],[1,1],[0,-1],[0,1]]
        countLive=0
        countDead=0
        for neigh in neighbour:
            neighrow = neigh[0]+row
            neighcol = neigh[1]+col
            if neighrow < 0 or neighcol <0 or neighrow > len(board)-1 or neighcol > len(board[0])-1:
                continue
            #checking 2 value since we have update the live value to 2
            if(board[neighrow][neighcol] == 1 or board[neighrow][neighcol]==2 ):
                countLive+=1
            #checking 3 value since we have update the dead value to 3
            if(board[neighrow][neighcol] == 0 or board[neighrow][neighcol]==3 ):
                countDead+=1
                
        # if live then mark dead based on the condition
        if board[row][col]==1:
            if countLive < 2:
                    board[row][col]=2
            elif countLive >3:
                board[row][col]=2
        #if dead then mark live based on the condition 
        if board[row][col]==0:
            if countLive == 3:
                    board[row][col]=3
            
                
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        rowLen = len(board)
        colLen = len(board[0])
         
        for i in range(rowLen):
            for j in range(colLen):
                 self.boardCheck(board,i,j)        
         #updating the values of 2 to dead and 3 to live        
        for i in range(rowLen):
            for j in range(colLen):
                if board[i][j] == 2:
                    board[i][j] =0
                elif board[i][j]==3:
                    board[i][j]=1    
                 
        print(board)
        
         
        
        
obj = Solution();
print(obj.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))
print(obj.gameOfLife([[1,1],[1,0]]))