# Loop through each element in the array and check if it is alive:
# Iterate through all its 8 neigbours to count the number of dead and live neighbpurs:
# If the element ==1 and live<2, change the cell to 2
# If the element ==1 and live> 3, change the cell to 2
# If the element ==0 and live==3, change the cell to 3

# In the end, loop through all the elements and change the cells with 2 to 0 and 3 to 1 
# and return the matrix
# Time complexity:O(n)
# Space complexity:(1)


class Solution(object):
    def isAlive(self,r, c, board):
        current_state=board[r][c]
        dir = [[-1,0],[1,0],[0,1],[0,-1],[-1,1],[1,1],[1,-1],[-1,-1]]
        live=0
        dead=0
        for i in dir:
            nr = r+i[0]
            nc= c+i[1]
            if 0<=nr<len(board) and 0<=nc<len(board[0]):
                if board[nr][nc] in [1,2]:
                    live+=1
                else:
                    dead+=1
        print("live", live,"dead",dead)
        if current_state==1 and live<2:
            return 2
        elif current_state==1 and live in [2,3]:
            return 1
        elif current_state==1 and live>3:
            return 2
        elif current_state==0 and live==3:
            return 3
        return current_state

        
        

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        r=len(board)
        c=len(board[0])
       
        for i in range(r):
            for j in range(c):
                x=self.isAlive(i,j,board)
                board[i][j]= x
        print(board)
        for i in range(r):
            for j in range(c):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j] == 3:
                    board[i][j] =1
                



