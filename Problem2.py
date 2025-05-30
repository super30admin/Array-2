'''
Time Complexity: O(m*n)
Space Complexity: O(m*n)

Approach: 
    1. Create a copy of the board
    2. Iterate through the board and check if the cell is alive or not
    3. If the cell is alive, check the number of live neighbours
    4. If the cell is dead, check the number of live neighbours
    5. If the number of live neighbours is 2, the cell is alive
    6. If the number of live neighbours is 3, the cell is alive
    7. If the number of live neighbours is not 2 or 3, the cell is dead
'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        ROWS, COLS = len(board), len(board[0])

        current = [[0 for i in range(COLS)] for i in range(ROWS)]

        for r in range(ROWS):
            for c in range(COLS):
                current[r][c] = board[r][c]

        for r in range(ROWS):
            for c in range(COLS):
                liveNeighbours = 0
                neighbours = [
                    (r - 1, c),
                    (r + 1, c),
                    (r, c + 1),
                    (r, c - 1),
                    (r - 1, c + 1),
                    (r + 1, c - 1),
                    (r - 1, c - 1),
                    (r + 1, c + 1),
                ]
                for dr, dc in neighbours:
                    if dr >= 0 and dr < ROWS and dc >= 0 and dc < COLS:
                        if current[dr][dc] == 1:
                            liveNeighbours += 1

                # current[r][c] = board[r][c]
                print("Live Neighbours", liveNeighbours)

                if current[r][c] == 1:
                    if liveNeighbours < 2 or liveNeighbours > 3:
                        board[r][c] = 0
                else:
                    if liveNeighbours == 3:
                        board[r][c] = 1


