"""
Time: O(n^2)
Space: O(1)
Leet: Accepted
Problems: None
"""



def gameOfLife(self, board):
    """
    :type board: List[List[int]]
    :rtype: void Do not return anything, modify board in-place instead.
    """
    m, n = len(board), len(board[0])
    def count(i,j):
        res = 0
        for p in range (max(i-1, 0), min(i+2, m)):
            for q in range(max(j-1,0), min (j+2, n)):
                if p!=i or q!=j:
                    res+=board[p][q]%2
        return res

    for i in range (m):
        for j in range (n):
            live = count(i,j)
            #just keep track of what needs to change
            if board[i][j] == 0 and live ==3:
                board[i][j] = 2
            if board[i][j] == 1 and (live < 2 or live >3):
                board[i][j] = 3
    for i in range (m):
        for j in range(n):
            if board[i][j]==2: board[i][j] = 1
            if board[i][j]==3: board[i][j] = 0
