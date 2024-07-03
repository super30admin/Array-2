#time = O(m×n)
#space = O(m×n)
def game_of_life(board):
    # Define the eight possible directions around a cell (row, column)
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)]
    rows, cols = len(board), len(board[0])

    # Create a copy of the board to apply the rules on
    copy_board = [[board[r][c] for c in range(cols)] for r in range(rows)]
    print(copy_board)

    for r in range(rows):
        for c in range(cols):
            # Count the number of live neighbors
            live_neighbors = 0
            for direction in directions:
                nr, nc = r + direction[0], c + direction[1]
                if 0 <= nr < rows and 0 <= nc < cols and abs(copy_board[nr][nc]) == 1:
                    live_neighbors += 1
            
            # Apply the rules of the Game of Life
            if copy_board[r][c] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[r][c] = 0  # Die due to underpopulation or overpopulation
            if copy_board[r][c] == 0 and live_neighbors == 3:
                board[r][c] = 1  # Become a live cell due to reproduction

    return board

# Example usage:
board = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0]
]

new_board = game_of_life(board)
for row in new_board:
    print(row)