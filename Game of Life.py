# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 -> 0 is 2 : die
        # 0 -> 1 is 3 : alive
        for i in range(len(board)):
            for j in range(len(board[0])):
                c = self.getCount(board,i,j,len(board),len(board[0]))
                if board[i][j] == 1:
                    if c < 2:
                        board[i][j] = 2
                    elif c > 3:
                        board[i][j] = 2
                else:
                    if c == 3:
                        board[i][j] = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1


    def getCount(self,board,i,j,totalRows,totalCols):
        count = 0
        for (p,q) in self.dirs:
            if (i+p >= 0 and i+p < totalRows and j+q >= 0 and j+q < totalCols):
                if board[i+p][j+q] == 1 or board[i+p][j+q] == 2:
                    count += 1
        return count
