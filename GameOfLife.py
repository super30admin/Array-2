from pip import List


class Solution:
    #Time Complexity = O(n^2)
    #Space Complexity = O(1)
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if(len(board)==0):
            return []
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                countLiveNeighbours = self.countLives(board,i,j)
                if(board[i][j] == 0):
                    if(countLiveNeighbours == 3):
                        board[i][j] = 2
                else:
                    if(countLiveNeighbours <2):
                        board[i][j] = 3
                    elif(countLiveNeighbours >3):
                        board[i][j] = 3
                
        for i in range(m):
            for j in range(n):
                if(board[i][j] == 2):
                    board[i][j] = 1
                elif(board[i][j] == 3):
                    board[i][j] = 0
        
        
    def countLives(self,board: List[List[int]], i: int, j: int):
        count = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[1,1],[-1,1],[1,-1]]
        m = len(board)
        n = len(board[0])
        for x in dirs:
            nr = i + x[0]
            nc = j + x[1]
            if((nr>=0 and nr<m) and (nc>=0 and nc<n) and (board[nr][nc]==1 or board[nr][nc]==3)):
               count+=1
        return count
                                