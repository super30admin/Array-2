"""
https://leetcode.com/problems/game-of-life/
Live Cell with fewer than two live neighbours or greater than 3 dies so the state needs to be changed from 1-0 so we mark it with 3.
For dead cells going alive- from 0 -1 we mark them as 2. We iterate all the array and at each place we we judge and mark 2 or 3 as calculated.
In the end we convert 2,3 back to 0 and 1 respectively. In calculating the live cell we check if we have any3 too in the array.
1-0 recording as 3, 0-1 recording as 2, 3 means the cell is alive as its original position was 2
live neighbour dies
Time Complexity-m*n
Space complexity O(1)

1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

"""
class Solution:
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        if board==None or len(board)==0:
            return
        dirs=[[0,1], [0,-1], [1,0], [-1,0], [-1,-1], [1,1], [1,-1], [-1,1]]
        m= len(board)
        n= len(board[0])
        for i in range(m):
            for j in range(n):
                count=self.countLive(board, i,j, dirs,m, n)
                ##converting 1 -0 applying rules 1 and 3
                if board[i][j]==1 and (count<2 or count>3):
                    board[i][j]=3
                if board[i][j]==0 and count==3:
                    board[i][j]=2

        for i in range(m):
            for j in range(n):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1



    def countLive(self, board, i, j, dirs, m ,n ):
        result=0
        for dir in dirs:
            nr=dir[0]+i
            nc=dir[1]+j
            if nr>=0 and nc>=0 and nr<m and nc<n and (board[nr][nc]==1 or board[nr][nc]==3):
                result+=1

        return result





board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
solve=Solution()
solve.gameOfLife(board)
