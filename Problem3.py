# Time Complexity: O(m*n)
# Space Complexity: O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.

        Any live cell with fewer than two live neighbors dies as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population.
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        """
        def get_neighbords(r, c):
          dirs = [
            (0,1),
            (0,-1),
            (1,0),
            (-1,0),
            (-1,-1),
            (-1,1),
            (1,-1),
            (1,1)
          ]
          res = []
          for dir in dirs:
            nr, nc = r + dir[0], c + dir[1]
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]):
              res.append((nr,nc))
          return res

        for r in range(len(board)):
          for c in range(len(board[0])):
            neighbors = get_neighbords(r, c) 
            live_neighbords = list(filter(lambda coord: board[coord[0]][coord[1]] == 1 or board[coord[0]][coord[1]] == -1, neighbors))
            if board[r][c] == 1:
              if len(live_neighbords) != 2 and len(live_neighbords) != 3:
                board[r][c] = -1
            else:
              if len(live_neighbords) == 3:
                board[r][c] = 3
        
        for r in range(len(board)):
          for c in range(len(board[0])):
            if board[r][c] == -1:
              board[r][c] = 0
            elif board[r][c] == 3:
              board[r][c] = 1

        return board

        
