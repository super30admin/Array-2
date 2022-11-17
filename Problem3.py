# // Time Complexity : O(mxn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yess
# // Any problem you faced while coding this : I didn't understand why the new defined function has to includ 'self' in it!


# // Your code here along with comments explaining your approach


#here we are couting live neighbours then after checking the conditions we are making the cell live or dead.
#insted of defining a new matrix we are replacing new live cells with 3 and dead cells with 2
#then we are running a for loop to reassign 1's and 2's 

class Solution:
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        
        #for each row and column of matrix we are checking if cell is alive and based of given neighbouring coditions we are replacing new dead and alive with 2's and 3's 
        for i in range(rows):
            for j in range(cols):
                count = self.countLive(board,i,j)
                if (board[i][j]==1):
                     if (count < 2 or count > 3):
                        board[i][j]=2
                else:
                    if (count == 3):
                        board[i][j]=3
                        
        #replacing 2's and 3's with 0's and 1's
        
        for i in range(rows):
            for j in range(cols):
                if (board[i][j]==2):
                    board[i][j]=0
                elif (board[i][j]==3):
                    board[i][j]=1
                    
    #definging a method/function to count live neighbours
    
    def countLive(self,board: List[List[int]], r, c):
        rows = len(board)
        cols = len(board[0])
        count = 0
        direc = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]

        for i in range(len(direc)):
            nr = r + direc[i][0]
            nc = c + direc[i][1]
            if (nr >= 0 and nc >= 0 and nr<rows and nc<cols and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                count=count+1
        return count