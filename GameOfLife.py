# Time complexity: O(M*N) m is the number of rows in the board, and n is the number of columns in the board.
#Space Complexity: O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board==None or len(board)==0:
            return
        
        m=len(board)
        n=len(board[0])
        # 1->0 ===>2
        # 0->1 ==>3
        for i in range(m):
            for j in range(n):
                liveCount=self.getLiveCount(board, i, j)
                if board[i][j]==1:
                    if liveCount<2 or liveCount>3:
                        board[i][j]=2
                else:
                    if liveCount==3:
                        board[i][j]=3
        
        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1
        
    def getLiveCount(self, board:List[List[int]],row :int, col:int) ->int:
        Dirs=[[-1,0], [1,0], [0,-1], [0,1], [-1,-1], [-1,1], [1,-1], [1,1]]
        countOfLiveNeighbors=0
        m=len(board)
        n=len(board[0])
        for dir in Dirs:
            nr=row+dir[0]
            nc=col+dir[1]
            if nr>=0 and nr<m and nc>=0 and nc<n and (board[nr][nc]==1 or board[nr][nc]==2):
                countOfLiveNeighbors +=1
        return countOfLiveNeighbors