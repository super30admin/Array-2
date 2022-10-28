#Time Complexity - O(m*n)
#Space Complexity - O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        live = 1
        dead = 0
        live_dead = 2
        dead_live = 3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                noOfLive = self.calculateLive(board, i, j)
                print(noOfLive)
                if board[i][j] == 1:
                    if noOfLive < 2 or noOfLive > 3:
                        board[i][j] = live_dead
                else:
                    if noOfLive == 3:
                        board[i][j] = dead_live
        print(board)
    
    def calculateLive(self, board, i, j):
        count = 0
        
        if (i - 1) >= 0 and (j - 1) >= 0:
            count += board[i - 1][j - 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
            
        if (i - 1) >= 0:
            count += board[i - 1][j] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
        
        if (i - 1) >= 0 and (j + 1) < len(board[0]):
            count += board[i - 1][j + 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
            
        if (j - 1) >= 0:
            count += board[i][j - 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
            
        if (j + 1) < len(board[0]):
            count += board[i][j + 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
        
        if (i + 1) < len(board) and (j - 1) >= 0:
            count += board[i + 1][j - 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
        
        if (i + 1) < len(board):
            count += board[i + 1][j] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
        
        if (i + 1) < len(board) and (j + 1) < len(board[0]):
            count += board[i + 1][j + 1] if (board[i - 1][j - 1] == 2 or board[i - 1][j - 1] == 1) else 0
            
        return count
            
            
        
            
        