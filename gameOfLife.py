# Time Complexity : O(n*m)
# Space Complexity : O(1), no extra space required
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
def gameOfLife(board):
        
    if board == None or len(board)==0 or len(board[0])==0:
        return
    
    n = len(board)
    m = len(board[0])
    
    for i in range(n):
        for j in range(m):
            live = liveCount(board, n, m, i, j)
        
            #set the live to 2 if it were once live and now dead
            #this will solve our problem of losing the previous state in any direction
            #else acc to the rules, set dead to 4 if it were once dead and now live
            if board[i][j] == 1 and (live < 2 or live > 3):
                board[i][j] = 2
            elif board[i][j] ==0 and live ==3:
                board[i][j] = 4
    
    #change back values of 2 and 4 to 0 and 1
    for i in range(n):
        for j in range(m):
            if board[i][j]==2:
                board[i][j] = 0
            elif board[i][j] == 4:
                board[i][j] = 1
    
    return board
            
            
#gives the count of live cells around a particular cell    
def liveCount(board, n, m, i,j):
    cnt = 0
    
    # defining the 8 directions where the interactions are allowed
    dirn = [[1,-1],[1,0],[1,1],[0,-1],[0,1],[-1,-1],[-1,0],[-1,1]]
    
    # for every direction, calculate the row and column of the direction we are in.
    for dirs in dirn:
        r = i + dirs[0]
        c = j + dirs[1]
        
        if (r >= 0 and r<n and c>=0 and c<m and (board[r][c]==1 or board[r][c]==2)):
            cnt +=1
    
    return cnt

print(gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))