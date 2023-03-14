
# Time Complexity - O(mn)
# Space Complexity - O(1)


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        directionArray = [[0,-1],[0,1],[1,0],[-1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        m = len(board)
        n = len(board[0])

        def aliveCells(board,i,j):
            count = 0
            for each in directionArray:
                r = i + each[0]
                c = j + each[1]
                if (r >= 0 and c >=0 and r < m and c < n and (board[r][c] == 1 or board[r][c] == 2)) :
                    count += 1 
            return count


        for i in range(m):
            for j in range(n):
                countAlive = aliveCells(board,i,j)
                if board[i][j] == 1 :
                    if countAlive < 2 or countAlive > 3 :
                        board[i][j] = 2 
                else :
                    if countAlive == 3 :
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j] == 2 :
                    
                        board[i][j] = 0
                if board[i][j] == 3 :
                    
                        board[i][j] = 1
                



     
