class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n, livecells, ans = len(board), len(board[0]), 0, []
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
            ans.append(temp)
        for i in range(m):
            for j in range(n):
                board[i][j] = ans[i][j]
        
#Space Complexity: O(mn)
#Time Complexity: O(mn)