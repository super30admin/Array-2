class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        m = len(board) #rows
        n = len(board[0]) #column
        
        
        
        for i in range(m):
            for j in range(n):
                
                # 0 -> 1 === 2
                # 1 -> 0 == 3
                
                count = 0
                # check for top element
                if i > 0 and (board[i - 1][j] == 1 or board[i - 1][j] == 3):
                    count += 1
                    
                # check for bottom element
                if i < m-1 and (board[i + 1][j] == 1 or board[i + 1][j] == 3):
                    count += 1

                # check for right element
                if j < n-1 and (board[i][j+1] == 1 or board[i][j+1] == 3):
                    count += 1

                # check for left element
                if j > 0 and (board[i][j-1] == 1 or board[i][j-1] == 3):
                    count += 1

                # check for top - right element
                if i > 0 and j < n-1 and (board[i-1][j+1] == 1 or board[i-1][j+1] == 3):
                    count += 1

                # check for top - left element
                if i > 0 and j > 0 and (board[i-1][j-1] == 1 or board[i-1][j-1] == 3):
                    count += 1
                
                # check for bottom - right element
                if i < m-1 and j < n-1 and (board[i+1][j+1] == 1 or board[i+1][j+1] == 3):
                    count += 1
                
                # check for bottom - left element
                if j > 0 and i < m-1 and (board[i+1][j-1] == 1 or board[i+1][j-1] == 3):
                    count += 1
                  
                print(count,board[i][j])
                if board[i][j] == 1:
                    if count < 2:
                        board[i][j]=3
                    if count > 3:
                        board[i][j]=3
                        
                else:
                    if count == 3:
                        board[i][j]=2
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j]=1
                if board[i][j] == 3:
                    board[i][j]=0
        
        return board
                
                