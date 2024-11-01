class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        new = [[0 for i in range(len(board[0]))]for i in range(len(board))]
        for i in range(len(board)):
          for j in range(len(board[0])):
            new[i][j] = board[i][j]

        for i in range(len(board)):
          for j in range(len(board[0])):
            x = self.Find_Live_neighbors(new, i, j)
            if board[i][j] == 0:
              if x ==3:
                board[i][j] = 1
            elif board[i][j] == 1:
              if x <2:
                board[i][j] = 0
              elif x > 3:
                board[i][j] = 0





    def Find_Live_neighbors(self, board: List[List[int]], i:int, j:int):
        dir = [[-1,0], [1, 0], [0, 1], [0, -1], [-1,1], [1,1], [1,-1], [-1,-1]]
        #         up     Down.  Right.   Left   DUright DDright DUleft   DDleft    
        count = 0
        for dx, dy in dir:
          ni = i + dx
          nj = j + dy
          if 0<= ni < len(board) and 0 <= nj <len(board[0]):
            if board[ni][nj] == 1:
              count += 1

        return count

    
