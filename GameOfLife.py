#Time Complexity: O(m*n)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        for i in range(rows):
            for j in range(cols):
                count = self.liveCount(board,i,j)
                if board[i][j]==1:
                    if count<2 or count>3:
                        board[i][j]=2
                else:
                    if count==3:
                        board[i][j]=3
        for i in range(rows):
            for j in range(cols):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
    def liveCount(self, board: List[List[int]],r,c) -> int:
        count=0
        rows = len(board)
        cols = len(board[0])
        dirs = [[-1,0],[-1,-1],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for i in range(8):
            rc = r+dirs[i][0]
            cc = c+dirs[i][1]
            if rc>=0 and cc>=0 and rc<rows and cc<cols and (board[rc][cc]==2 or board[rc][cc]==1):
                count+=1
        return count