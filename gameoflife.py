class Solution:
     def gameOfLife(self, board: List[List[int]]) -> None:
         if not board:
             return 
         for i in range(len(board)):
             for j in range(len(board[0])):
                 live = self.validneighbours(board,i,j)
                  if board[i][j] == 0 and live == 3:
                      board[i][j] = 3
                  if board[i][j] == 1 and (live < 2 or live > 3):
                       board[i][j] = 2
         for i in range(len(board)):
             for j in range(len(board[0])):
                 board[i][j] = board[i][j] % 2
    def validneighbours(self, board,i,j):
        directions  = [(-1,0), (0,-1),(1,0),(0,1),(-1,-1),(-1,1),(1,-1),(1,1)]
        lives = 0
        for direction in directions:
            nr = i + direction[0]
            nc = j + direction[1]
            if nr >= 0 and nr < len(board) and nc >= 0 and nc < len(board[0]): 
                if board[nr][nc] == 1 or board[nr][nc] == 2:
                    lives += 1
        return lives 
                

