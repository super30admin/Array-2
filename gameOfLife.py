class Solution:
    # TC: O(m*n)
    # SC: O(1)
    def getCountLiveNeighbors(self,board : List[List[int]],i:int,j:int) -> int:
        directions = [(-1,0),(1,0),(0,-1),(0,1),(-1,-1),(-1,1),(1,-1),(1,1)]
        m,n = len(board),len(board[0])
        ct = 0
        for dx,dy in directions:
            x,y = i+dx,j+dy
            if 0<=x<m and 0<=y<n and (board[x][y] == 1 or board[x][y] == 2):
                ct += 1
        return ct

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0:
            return 
        m,n = len(board),len(board[0])
        # if we change 1 to 0 replace with 2 
        # if we change 0 to 1 replace with 3
        
        for i in range(m):
            for j in range(n):
                ct = self.getCountLiveNeighbors(board,i,j)
                if board[i][j] == 1:
                    if ct < 2 or ct > 3:
                        board[i][j] = 2
                elif  board[i][j] == 0:
                    if ct == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

        