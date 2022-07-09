"""
Runtime Complexity:
O(m*n)- because we have 'm' rows and 'n' columns and we iterate over all the elements and check the neighbors.
Space Complexity:
O(1) - because no extra space was created to compute the solution.
Yes, the code worked on leetcode
The idea behind the algorithm is, instead of using an extra space we iterate the board and check the neighbors and update with 2 if dead cell becomes alive else with 3.
We run a loop and update the values for 2(dead->live) and 3(live->dead) in board matrix to 1(alive) and 0(dead) respectively.
"""



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board)
        n = len(board[0])
        #0 -->1 == 2
        #1 -->0 == 3
        for i in range(m):
            for j in range(n):
                neighbors_alive = self.CountLives(board,i,j)
                #if the cell was dead
                if board[i][j]==0:
                    if neighbors_alive ==3:     #when there are exactly 3 neighbors alive
                        board[i][j] = 2
                #if the cell was alive
                else:
                    if neighbors_alive < 2:     #when there is less than 2 neighbors alive
                        board[i][j] = 3
                    if neighbors_alive > 3:     #when there is greater than 3 neighbors alive
                        board[i][j] = 3
        
        for i in range(m):                      #we update the old board with new values
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] ==3:
                    board[i][j] = 0
        
    def CountLives(self,board,r,c):         #function to count the alive neighbors
        count = 0
        m = len(board)
        n = len(board[0])
        #8 neighbor directions in the matrix
        dirs = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        for num in dirs:
            
            nr = r + num[0]     #neighbor row
            nc = c+num[1]       #neighbor column
            if (nr>=0) and (nr<m):
                if(nc>=0) and (nc<n):
                    if (board[nr][nc]==1 or board[nr][nc]==3):
                        count+=1
        return count
        
                
        
        