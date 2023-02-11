"""
Rasika Sasturkar
Time Complexity: O(n*m)
Space Complexity: O(1)
"""


def gameOfLife(board):
    """
    Do not return anything, modify board in-place instead.
    Using temporary state change pattern and writing conditional
    statements for the given rules.
    """
    m = len(board)
    n = len(board[0])

    # null case
    if board is None:
        return

    # 1->0 mark as 3
    # 0->1 mark as 2

    for i in range(m):
        for j in range(n):
            live_neighbors = countAlive(board, i, j, m, n)
            if board[i][j] == 1 and (live_neighbors < 2 or live_neighbors > 3):
                board[i][j] = 3
            if board[i][j] == 0 and live_neighbors == 3:
                board[i][j] = 2

    for i in range(m):
        for j in range(n):
            if board[i][j] == 3:
                board[i][j] = 0
            if board[i][j] == 2:
                board[i][j] = 1
    return board


def countAlive(board, i, j, m, n):
    """
    Calculates the no. of alive neighbors of an element on board at i,j position
    """
    dirs = [[-1, 0], [1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, 1], [1, -1]]
    result = 0
    for direction in dirs:
        new_r = i + direction[0]
        new_c = j + direction[1]

        if 0 <= new_r < m and 0 <= new_c < n and (
                board[new_r][new_c] == 1 or board[new_r][new_c] == 3):
            result += 1

    return result


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    board1 = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    print(gameOfLife(board1))  # returns [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]
    board2 = [[1, 1], [1, 0]]
    print(gameOfLife(board2))  # returns [[1, 1], [1, 1]]


if __name__ == "__main__":
    main()
