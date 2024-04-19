
# // Time Complexity : O(n * m)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

#create a helper function to give you the count of alive in neighbouring elements
# iterative through every element , it if 1  or zero , check the condition in question with invlouves count
# after updating the elements in matrix satifying the condition ,
# loop through the matrix again to update the states , without using extra space 



class Solution:

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
       
        
        for r in range(rows):
            for c in range(cols):
                count = self.countAlive(board, r ,c )
                if board[r][c] == 0:
                    if count == 3 :
                        board[r][c] = 2
                
                elif board[r][c] == 1:
                    if count < 2 or count > 3 :
                        board[r][c] = 3

        for r in range(rows):
            for c in range (cols) :

                if board[r][c] == 2:
                    board[r][c] = 1
                elif board[r][c] == 3 :
                    board[r][c] = 0 

    def countAlive(self,board, r , c) :
        count = 0
        rows = len(board)
        cols = len(board[0])
        dirs = [(-1,-1),(-1,0), (-1,1), (0,1), (0,-1), (1,0), (1,-1), (1,1)]

        for i,j in dirs:
            row = r+ i
            col = c + j
            if row >= 0 and col >= 0 and row < rows and  col < cols:
                if board[row] [col] == 1 or board [row][col] == 3:
                    count += 1
        return count


