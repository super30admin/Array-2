# ## Problem3 (https://leetcode.com/problems/game-of-life/)
# // Time Complexity :O(m*n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


def count_alives(board, directions, i, j):
    # variable to count alives
    alive_count = 0
    # going through each direction
    for direc in directions:
        # finding new row and new column
        nr = i + direc[0]
        nc = j + direc[1]
        if (nr > 0 and nc > 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3)):
            alive_count += 1
    return alive_count


def gameOfLife(board):
    m = len(board)
    n = len(board[0])
    # directions array to check all 8 directions
    #             right     left    down    up
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0),
                  # upleft  upright  downleft downright
                  (-1, -1), (-1, 1), (1, -1), (1, 1)]
    # iterating over the board
    for i in range(m):
        for j in range(n):
            # counting the number of alives
            count = count_alives(board, directions, i, j, m, n)
            # rule 1 and 3
            if board[i][j] == 1 and count < 2 and count > 3:
                board[i][j] = 3
            # rule 1 and 3
            elif board[i][j] == 0 and count == 3:
                board[i][j] = 2

    # iterating through the board again and changing to 0 and 1
    for i in range(m):
        for j in range(n):
            if board[i][j] == 2:
                board[i][j] = 1
            elif board[i][j] == 3:
                board[i][j] = 0


# S1: Read Question
# 1 -> live
# 0 -> dead
# 8 neighbours --> directions
# 1 --> < 2 live --> 0
# 1 --> < 2 or 3 live --> 1
# 1 --> > 3 live --> 0
# 0 --> == 3 live --> 1

# S2: Constraints
# initial state needs to be known to change it to others
# S3: Test Cases
# S4: Solution without code
# 0 --> 1 --> 2
# 1 --> 0 --> 3
