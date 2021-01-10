# Time Complexity: O(mn)
# Space Complexity: O(1)
# Accepted on Leetcode
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.check_neigs(board, i ,j)
                #print(count)
                if board[i][j]==1 and( count < 2 or count > 3): # die = 2 alive --> dead
                    board[i][j] = 2
                if board[i][j]==0 and count == 3: # revive dead --> alive
                    board[i][j] = 3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j]==3:
                    board[i][j]=1
    
    def check_neigs(self, board, i ,j):
        count = 0
        dirs = [[-1,0],[1,0],[0,1],[0,-1],[-1,1],[-1,-1],[1,1],[1,-1]]
        m = len(board)
        n = len(board[0])

                
        for d in dirs:
            r = i + d[0]
            c = j + d[1]

            if 0<=r<m and 0<=c<n and (board[r][c]==1 or board[r][c]==2):
                count += 1
        return count
        
        