#Time Complexity:O(mn)
#Space Complexity:O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board)==0:                                                       #if board is empty return
            return
        m=len(board)                                                            #obtain number of rows
        n=len(board[0])                                                         #obtain number of columns
        for i in range(m):                                                      #for the ith row
            row=board[i]
            for j in range(n):                                                  #and jth column
                count=self.countAlive(board,m,n,i,j)                            #count the number of alive neighbors
                if (count<2 or count>3) and row[j]==1:                          #if current element is alive and count is less than 2 or greater than 3
                    row[j]=2                                                    #kill the element using 2
                if (count==3 and row[j]==0):                                    #if current element is dead and count is 3
                    row[j]=3                                                    # bring the element alive using 3
        for i in range(m):
            row=board[i]
            for j in range(n):
                if row[j]==3:                                                   #replace all 3s by 1s and 2s by 0s
                    row[j]=1
                elif row[j]==2:
                    row[j]=0
        
    def countAlive(self, board:List[List[int]], m:int, n:int ,r:int, c:int)->int:
        count=0
        dirs=[[0,1],[0,-1],[-1,0],[1,0],[1,1],[1,-1],[-1,1],[-1,-1]]            #consider 8 possible neighbors of an element
        for elem in dirs:                                                       #at each neighbor
            row=r+elem[0]
            col=c+elem[1]
            if(m>row>=0 and n>col>=0):                                          #if neighbor exists
                k=board[row]
                if k[col]==1 or k[col]==2:                                      #and element is alive
                    count+=1                                                    #increment the count of alive
        return count                                                            #return count to function call