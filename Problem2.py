#
# Time Complexity = O(m*n)
# Space Complexity = O(1) We are manipulating the input matrix
#
def alive(b,x,y):
    m=len(b)
    n=len(b[0])
    if x>=0 and x<m and y>=0 and y<n:
        a= b[x][y]
        if a==10 or a==1:
            return 1
        else:
            return 0
    else:
        return 0

def checkNeighbors(board,x,y):
    l=0
    l+=alive(board,x-1,y-1)
    l+=alive(board,x-1,y)
    l+=alive(board,x-1,y+1)
    l+=alive(board,x+1,y-1)
    l+=alive(board,x+1,y)
    l+=alive(board,x+1,y+1)
    l+=alive(board,x,y-1)
    l+=alive(board,x,y+1)
    return l
        
        
        
def gameOfLife(board):
    if len(board)==0 or len(board[0])==0:
        return
    m=len(board)
    n=len(board[0])
    for i in range(m):
        for j in range(n):
            l = checkNeighbors(board,i,j)
            if board[i][j]==1:
                if l<2:
                    board[i][j]=10
                elif l>3:
                    board[i][j]=10
            else:
                if l==3:
                    board[i][j]=100
    for i in range(m):
        for j in range(n):
            if board[i][j]==100 or board[i][j]==1:
                board[i][j]=1
            else:
                board[i][j]=0
