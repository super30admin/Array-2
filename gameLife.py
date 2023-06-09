class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == None or len(board) == 0:
            return
        m = len(board)
        n = len(board[0])
        #if a live cell changes to dead cell 1->2
        #if a dead cell changes to live cell 0->3
        for i in range(m):
            for j in range(n):
                liveCount = self.getLiveCount(board,i,j)
                #if current cell is a live cell
                if board[i][j] == 1:
                    if liveCount < 2 or liveCount > 3:
                        board[i][j] = 2
                else:
                    if liveCount == 3:
                        board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    def getLiveCount(self,board: List[List[int]], row: int, col:int) -> int:
        count =0
        dirs=[[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,-1],[1,1]]

        for Dir in dirs:
            nr = row + Dir[0]
            nc = col + Dir[1]
            if nr>=0 and nr < len(board) and nc >=0 and nc < len(board[0]) and (board[nr][nc]==1 or board[nr][nc]==2):
                count +=1
        return count

    
#time complexity -> O(m*n)
#Space complexity -> O(1)