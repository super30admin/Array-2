#Time Complexity:O(mn)
#Space Complexity:O(1)
class Solution():
    def countLives(self, board, i, j, m, n):
        result = 0
        direction=[[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]

        for d in direction:
            r = i + d[0]
            c = j + d[1]
            if (r >= 0 and r < m and c >= 0 and c < n and (board[r][c]==1 or board[r][c]== 3)):
                result += 1
        return result


    def gameOfLife(self, board):
        if (board == None or len(board)==0 or len(board[0])==0):
            return None
        # 1 ----> 0 = 3
        # 0 ----> 1 = 2
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                count = Solution.countLives(object,board,i,j,m,n)
                if (board[i][j]==1 and (count < 2 or count > 3)): #it dies
                    board[i][j] = 3
                if (board[i][j]==0 and count == 3): #lives
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if (board[i][j] == 3):
                    board[i][j] = 0
                if (board[i][j] == 2):
                    board[i][j] = 1
