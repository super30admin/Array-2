from typing import List

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if board is None or len(board)==0 or len(board[0])==0: return
        row=len(board)
        column=len(board[0])
        for rindex in  range(row):
            for cindex in range(column):
                count=self.getthecount(board=board,rwindex=rindex,cindex=cindex,row=row,column=column)

                if board[rindex][cindex]==1 and count <2 or count>3:
                    board[rindex][cindex]=3
                if board[rindex][cindex] == 0 and count == 3:
                    board[rindex][cindex] = 2

        for rindex in range(row):
            for cindex in range(column):

                if board[rindex][cindex] == 3:
                    board[rindex][cindex] = 0
                if board[rindex][cindex] == 2:
                    board[rindex][cindex] = 1
        return board








        """
        Do not return anything, modify board in-place instead.
        """
    def getthecount(self,board,rwindex,cindex,row,column):
        DIRECTIONS = [[1, 0], [-1, 0], [1, 1], [-1, 1], [0, 1], [0, -1], [-1, -1], [1, -1]]
        result=0

        for direct in DIRECTIONS:
            r=rwindex+direct[0]
            c=cindex+direct[1]
            if r>=0 and r <row and c>=0 and c<column and(board[r][c]==1 and board[r][c]==3):result+=1

        return result








if __name__ == '__main__':
    print(Solution().gameOfLife(board= [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))
