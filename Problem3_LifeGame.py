# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# Solution:
"""
1. Count the number of live neighbors for each cell.
2. Based on the count, change the current state of the cell to intermediate state
    (2 => originally live(1) and now dead(0)
     3 => originally dead(0) and now live(1)).
3. Finally, change the intermediate states to final states (2 to 0 and 3 to 1).
"""


def gameOfLife(self, board: List[List[int]]) -> None:
    if not board or len(board) == 0:
        return

    # Directions array to find the 8 neighbors for a given cell
    dirs = [[0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]

    rows = len(board)
    cols = len(board[0])

    # Iterate through board cell by cell
    for row in range(rows):
        for col in range(cols):

            # Count the number of live neighbors for each cell
            live_count = 0
            for dir in dirs:
                r = row + dir[0]
                c = col + dir[1]
                if (0 <= r < rows) and (0 <= c < cols) and (board[r][c] == 1 or board[r][c] == 2):
                    live_count += 1

            # Change the current state to intermediate state as per the live neighbor count
            # 1 -> 0 = 2
            # 0 -> 1 = 3
            if board[row][col] == 1 and (live_count < 2 or live_count > 3):
                board[row][col] = 2
            if board[row][col] == 0 and live_count == 3:
                board[row][col] = 3

    # Change the intermediate states to the final states - live or dead
    for row in range(rows):
        for col in range(cols):
            if board[row][col] == 2:
                board[row][col] = 0
            elif board[row][col] == 3:
                board[row][col] = 1
