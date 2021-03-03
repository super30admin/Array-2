#Time Complexity:O(mn), all the elements are accesses twice, O(2mn)
#Space Complexity:O(1), no other data structure used other that the given array

class Solution():
     #make a function to count lives around a cell
        #i and j are row and col indices of the cell in the board
        #m and n are the size of the board for out of bound check
    def countLives(self, board, i, j, m, n):
        result = 0
        #order of indices: left, right, up, down, left up diagonal, right up diagonal, left down diagonal, right down diagonal
        direction=[[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for d in direction:
            #r and c are indices of the neighbor cell for each direction
            #print(d)
            r = i + d[0] 
            c = j + d[1]

            #out of bound check, to check if any of the indices lie outside of the board
            # 3 states the original state was 1 and will be updated to 0
            if (r >= 0 and r < m and c >= 0 and c < n and (board[r][c]==1 or board[r][c]==3)):
                result +=1
        #print ("result=",result)
        #print ("i=",i)
        #print ("j=",j)
        return result
    
    
    def gameOfLife(self, board):
        
        #sanity check
        if (board == None or len(board)==0 or len(board[0])==0):
            return None
        #dummy values: 
        # 1 ----> 0 = 3
        # 0 ----> 1 = 2
        #row
        m = len(board)
        
        #column
        n = len(board[0])
        
        #traverse the board
        for i in range(m):
            for j in range(n):
                count = Solution.countLives(object,board,i,j,m,n)
                if (board[i][j]==1 and (count < 2 or count > 3)): #it dies
                    board[i][j] = 3
                if (board[i][j]==0 and count == 3): #lives
                    board[i][j] = 2 
        for i in range(m):
            for j in range(n):
                if (board[i][j] == 3):
                    board[i][j] = 0
                if (board[i][j] == 2):
                    board[i][j] = 1
                    
        return board
