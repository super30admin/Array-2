# T.C => O(m * n)
# S.C => O(1)  Since we did in place changes
#approach => In this approach we are traversing throug all the neighbouring elements of an element. if the neighbouring elements have value(1) which are less than 2 and greater then 3 we can replace the current value with 2, and if neighbouring elements count upto 3 we change current value to 3. Then in the next pass we change the value of 2 to 0 and the 3 to 1. To compute the neighbouring elements 1 add upto 3 or less than 2 or greater then 3 we made a countLives function. Where there is dir 2 array which goes through all the neighbouring elements.

class Solution:

    def gameOfLife(self, board: List[List[int]]) -> None:
        def countLives(board, r, c):
            dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[-1,-1],[-1,1],[1,-1]]
            count = 0
            for di in dirs:
                nr = r + di[0]
                nc = c + di[1]
                if(nr >= 0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 2)):
                    count+= 1
            return count
        if len(board) == None: return
         # No of rows
        m = len(board)    
        # # No of column
        n = len(board[0]) 
        #1 -> 0 ==> 2
        # 0 -> 1 ==> 3
        for i in range(0, m):
            for j in range(0, n):
                lives = countLives(board, i ,j)
                if(board[i][j] == 1):
                    if(lives < 2 or lives > 3):
                        board[i][j] = 2
                else:
                    if(lives == 3):
                        board[i][j] == 3
                        
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

                    
                    
                        
                        
                        