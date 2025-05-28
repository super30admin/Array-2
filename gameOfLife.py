"""
Count live neighbors using 8-directions for every cell
Mark 1->0 as -1, and 0->1 as 2 to keep previous state
In second pass, convert -1->0, and 2->1 to finalize the board
"""
"""
Time Complexity: O(m * n * 8) = O(m * n)
Space Complexity: O(1) - in-place
"""

class gameOfLife:
    def gameOfLifes(self, board: list[list[int]]) -> None:
       
        rows, cols = len(board), len(board[0])
        directions = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]

        for r in range(rows):
            for c in range(cols):
                live_neighbors = 0
                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < rows and 0 <= nc < cols and abs(board[nr][nc]) == 1:
                        live_neighbors += 1

                if board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                    board[r][c] = -1  
                elif board[r][c] == 0 and live_neighbors == 3:
                    board[r][c] = 2  

        for r in range(rows):
            for c in range(cols):
                if board[r][c] > 0:
                    board[r][c] = 1
                else:
                    board[r][c] = 0
        print(board)

if __name__=="__main__":
    obj = gameOfLife()
    board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    obj.gameOfLifes(board)
