# time complexity is o(mn), where mn is the number of elements in the board
# space complexity is o(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        direc = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        for i in range(m):
            for j in range(n):
                livecount = self.neighbcount(i, j, board, direc, m, n)
                # print(i,j)
                if(board[i][j] == 1 and livecount < 2):
                    board[i][j] = 2
                elif(board[i][j] == 1 and livecount > 3):
                    board[i][j] = 2
                elif(board[i][j] == 0 and livecount == 3):
                    board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if(board[i][j] == 2):
                    board[i][j] = 0
                if(board[i][j] == 3):
                    board[i][j] = 1
        
        
    def neighbcount(self,i, j, board, direc, m , n):
        count = 0
        for d in direc:
            r = i
            c = j
            r = r + d[0]
            c = c + d[1]
            if((r > -1 and r < m and c >-1 and c < n) and (board[r][c] == 1 or board[r][c] == 2)):
                count += 1
        return count
                
                
        
        