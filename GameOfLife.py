class Solution:
    
    def helper(self,r : int,c: int, row: int, col: int, board: List[List[int]]) -> int:
        cnt = 0
        p = [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]
        for x,y in p:
            if 0<= r + y < row and 0<= c + x < col and board[y+r][x+c] == 1:
                cnt += 1
        if board[r][c] == 1:
            if cnt < 2:
                return 0
            elif cnt == 2 or cnt == 3:
                return 1
            else:
                return 0
        else:
            if cnt == 3:
                return 1
            else:
                return 0
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        temp = [[None] * col for _ in range(row)]
        for r in range(row):
            for c in range(col):
                temp[r][c] = self.helper(r,c,row,col,board)
        for r in range(row):
            for c in range(col):
                board[r][c] = temp[r][c]
                    