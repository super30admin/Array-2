#Arrays-2
#Problem 3 : https://leetcode.com/problems/game-of-life/
#Test Cases Passed on LeetCode
#Time Complexity-O(m*n)
#Space Complexity-O(1)

class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        dir=[[1,-1],[1,0],[1,1],[0,-1],[-1,-1],[-1,0],[-1,1],[0,1]]
        for i in range(len(board)):
            for j in range(len(board[0])):
                live=0
                #to find live neighbours
                for d in dir:
                    if i+d[0]<0 or i+d[0]>=len(board) or j+d[1]<0 or j+d[1]>=len(board[0]):
                        continue
                    if board[i+d[0]][j+d[1]]==1 or board[i+d[0]][j+d[1]]==3:
                        live+=1
                    
                #go to cell and update
                #Case1 and 3 
                #Case1:Any live cell with fewer than two live neighbors dies, as if caused by under-population.
                #Case3:Any live cell with more than three live neighbors dies, as if by over-population
                if board[i][j]==1 and (live<2 or live>3):
                    #ransitions from 1->0:3
                    board[i][j]=3
                #Case 4:Any dead cell with exactly three live neighbors becomes a live cell,as if by reproduction.
                if board[i][j]==0 and live==3:
                    #transition from 0->1
                    board[i][j]=2
                #in Case 2:Any live cell with two or three live neighbors lives on to the next generation.,
                #no transition is required
                
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                     board[i][j]=1
                        
sol=Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
sol.gameOfLife(board)
print(board)          
        


        
        















