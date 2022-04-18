#game of life
# // Time Complexity : O(n^2)
# // Space Complexity : O(1) as we are using the same board
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no

        

def getCount(board, row, col):                          #counts the neighbor and returns the total number of live cells
    directions=[[1,0], [-1,0], [0,1], [0,-1], [1,1],[-1,-1],[1,-1],[-1,1]]
    total=0
    for i in directions:
        new_row = row+i[0]
        new_col = col+i[1]
        if(new_row >=0 and new_row <len(board) and new_col>=0 and new_col < len(board[0]) and board[new_row][new_col]>=1):
            total+=1
    return total


def gameOfLife( board) :
    for i in range(len(board)):
        for j in range(len(board[0])):
            count = getCount(board, i, j)
            if(board[i][j] >= 1):                       
                if(count<2 or count>3):                                     #changing live to dead
                    board[i][j] = 2
                
            else:
                if(count ==3):                                              #changing dead to live
                    board[i][j] = -1
    
                    
    for i in range(len(board)):                                             #changing the values of the temporary assigned ones
        for j in range(len(board[0])):
            if (board[i][j]==-1):
                board[i][j]=1
            elif(board[i][j]==2):
                board[i][j]=0


    print(board)
        
#testing   
(gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))