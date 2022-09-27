'''
Time Complexity: O(M*N)
Space Complexity: O(1)
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        def getLiveNeighBour(i, j):
            count = 0
            direction = [
                [0, -1],
                [0, 1],
                [-1, 0],
                [1, 0],
                [-1, -1],
                [-1, 1],
                [1, -1],
                [1,1]
            ]
            for k in direction:
                nr = i+k[0]
                nc = j+k[1]
                if(nr>=0 and nc>=0 and nr<row and nc<col and (board[nr][nc]==1 or board[nr][nc]==2)):
                    count += 1
            return count
        
        for i in range(0, row):
            for j in range(0, col):
                live_neigh_ct = getLiveNeighBour(i, j)
                if(board[i][j]==1 and (live_neigh_ct <2 or live_neigh_ct>3)):
                    board[i][j] = 2
                elif(board[i][j] == 0 and live_neigh_ct==3):
                    board[i][j] = 3
        
        for i in range(0, row):
            for j in range(0, col):
                if(board[i][j] == 2):
                    board[i][j] = 0
                elif(board[i][j] == 3):
                    board[i][j] = 1
        return board
        
                    
        