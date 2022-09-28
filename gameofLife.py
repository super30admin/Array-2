"""
https://leetcode.com/problems/game-of-life/

Approach--
a. 
- 1 -> 0 change we mark it as 2
- 0 -> 1 change we mark it as 3
This approach is used sice we need to keep a track of 0's and 1's
b. We create a direction array to keep a track of all 8 neighbours of an element in matrix
This array is used to check if an element is 1
c. Traverse and check live or dead element and update to 3 and 2 and required
d. Change all the elements back to 1 and 0 before returning the result

TC - O(mn) - m,n size of matrix
SC - O(n)
"""

b = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]


def gameofLife(board):
    m = len(board)
    n = len(board[0])

    # 1->0 then 2
    # 0->1 then 3

    def countNeighbors(board, i, j):
        count = 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]]
        for dir1 in dirs:
            r = i + dir1[0]
            c = j + dir1[1]
            if 0 <= r < m and 0 <= c < n and (board[r][c] == 1 or board[r][c] == 2):
                count += 1

        return count

    for i in range(0, m):
        for j in range(0, n):
            neighbors = countNeighbors(board, i, j)
            # current element is 1 or live
            if board[i][j] == 1:
                if neighbors < 2 or neighbors > 3:
                    # current element is 0 or dead
                    board[i][j] = 2
            else:
                if neighbors == 3:
                    board[i][j] = 3

    # finally change 2's to 0 and 3's to 1
    for i in range(0, m):
        for j in range(0, n):
            if board[i][j] == 2:
                board[i][j] = 0
            elif board[i][j] == 3:
                board[i][j] = 1
    return board


print(gameofLife(b))
