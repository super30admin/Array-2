#Time Complexity : 0(n*m)
#Space Complexity : o(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        #0->1 2 (which was died and live again)
        #1->0 3 (which was live and dead)
        #1-> 1 (no chnage)
        #0-> 0 (no change)

        for i in range(rows):
            for j in range(cols):
                neighbours = self.liveneighbours(board,i,j,rows,cols)
                if board[i][j] == 1:
                    if  neighbours < 2 or neighbours > 3:
                        board[i][j] = 3
                else:
                    if  neighbours == 3:
                        board[i][j] = 2

        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 2:
                   board[i][j] = 1
                if board[i][j] == 3:
                   board[i][j] = 0

    def liveneighbours(self,board: List[List[int]],crow:int,ccol:int,rows:int, cols:int) -> int:
        count = 0
        list_neighbours = [[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1]]

        for item in list_neighbours:
            nr = crow + item[0]
            nc = ccol + item[1]

            if nr>=0 and nr<rows and nc>=0 and nc<cols:
                if board[nr][nc] in [1,3]:
                    count+=1
        return count