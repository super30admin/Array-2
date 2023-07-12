# // Time Complexity : O(8*m*n) -> O(m*n), where m is number of rows and n is number of cols.
# Above, we get 8 from the 8 directions we need to iterate for each element
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YEs
# // Your code here along with comments explaining your approach
# Instead of using another matrix, we do it inplace, by marking newly dead and newly alive elements by 2 and 3 respectively.
# For each element we get neighbours count from all 8 directions.
# This is done by findNeighbours fucntion which uses a direction array to visit all 8 neighbours and we take care of edge conditions, by checking if new row and col index is between 0 (included) and m,n respectively. Also, we need to check if board[new_row][new_col] is 1 or 3 (originaly alive or still alive). 
# Once we get our neighbour count, we modify the element according to the provided rules.
# After all iteration, make all 3s to 0 and all 2s to 1.

class Solution:
    def __init__(self): #directions array to change direction each time conviently, instead of repating it for each element
            self.directions=[(0,1), (1,0), (1,1), (-1,0),(0,-1), (-1,-1), (-1, 1), (1, -1)]
        
    
    def findNeighbours(self,board,row,col):
        c=0
        for dr,dc in self.directions:
            new_r=dr+row
            new_c=dc+col
            if 0<=new_r<len(board) and 0<=new_c<len(board[0]) and board[new_r][new_c] in {1,3}: #1 or 3 (originaly alive or still alive)
                c+=1
        return c
            
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                count=self.findNeighbours(board,i,j) #get the neighbour count
                if board[i][j]==1:
                    if count<2 or count>3: #if element is alive and neighbours are less than 2(under-pop) or more than 2 (over-pop) we mark it as dead by marking it as 3
                        board[i][j]=3
                else:
                    if count==3: #if element is dead and neighbours count is 3, mark it as alive by marking it as 2
                        board[i][j]=2
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j]==3: #now, after all iterations are done, if element is 3 make it 0 and if element is 2 make it 1
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1   

        
