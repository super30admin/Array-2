#Running Time Complexity: O(mxn)
#Space Complexity: Constant or O(1)
#Successfully Run and Compiled on leetcode 
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 --> 0 3
        # 0 --> 1 2
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                lives = countLives(board,i,j,m,n)
                # case 1 to 3
                if board[i][j]==1 and (lives<2 or lives>3):
                    board[i][j] = 3
                # case 4
                if board[i][j]==0 and lives == 3:
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1
                    
def countLives(board,i,j,m,n):
    result = 0
    #  #         right  left  down   up    drig   dlow   urig   uleft
    directory = [[0,1],[0,-1],[1,0],[-1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
    for direction in directory:
        r = i + direction[0]
        c = j + direction[1]
        if r>=0 and r<m and c>=0 and c<n and (board[r][c]==1 or board[r][c]==3):
            result +=1
    return result
    