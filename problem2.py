#Space Complexity O(mn)
#Time Complexity O(mn)

import collections
class Solution:
    def gameOfLife(self, board: list[list[int]]) -> None:
    
        m, n, livecells, res = len(board), len(board[0]), 0, []
        modified_board = collections.deque([collections.deque(x) for x in board])
        for rows in modified_board:
            rows.appendleft(0)
            rows.append(0)
        modified_board.appendleft([0] * (n + 2))
        modified_board.append([0] * (n + 2))
        for i in range(1, m + 1):
            temp = []
            for j in range(1, n + 1):
                livecells = 0
                for k in range(i - 1, i + 2):
                    for l in range(j - 1, j + 2):
                        if modified_board[k][l]:
                            livecells += 1
                if modified_board[i][j]:
                    livecells -= 1
                    if livecells < 2:
                        temp.append(0)
                    elif 2 <= livecells <= 3:
                        temp.append(1)
                    else:
                        temp.append(0)
                else:
                    if livecells == 3:
                        temp.append(1)
                    else:
                        temp.append(0)
            res.append(temp)
        for i in range(m):
            for j in range(n):
                board[i][j] = res[i][j]
        
sol= Solution()
board = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0]
]
sol.gameOfLife(board)
print(board)