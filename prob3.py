# Time Complexity : O(M * N)
# Space Complexity : O(1) as no extra space, just the output array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : got stuck in the countLive fn, 
# forgot to include if(board[nr][nc] == 3)


class Solution:
    def gameOfLife(self, board) -> None:

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countLive(board, i, j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 3
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1


    def countLive(self, board, i, j) -> int:
        
        res = 0
        m = len(board)
        n = len(board[0])
        dirs = [[0, -1], [0, 1], [1, 0], [-1, 0], [-1, -1], [1, -1], [-1, 1], [1, 1]]
        for d in dirs:
            nr = i + d[0]
            nc = j + d[1]
            if (nr>=0 and nr<m and nc>=0 and nc<n and (board[nr][nc] == 1 or board[nr][nc] == 3)):
                res += 1
        return res 

obj = Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
print('Before')
print(board)
obj.gameOfLife(board)
print('After')
print(board)