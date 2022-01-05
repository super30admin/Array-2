# Time Complexity : O(nm)  where n and m are size of the matrix.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes.
# Any problem you faced while coding this : Class Solution.
class Solution:
    dir = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def countAliveNeighbours(board,i,j):
            rows = len(board)
            columns = len(board[0])
            count = 0
            for d in Solution.dir:
                r = d[0] + i
                c = d[1] + j
                if (r>=0 and c >=0 and r < rows and c < columns and (board[r][c] == 1 or board[r][c] == 3)) :
                    count += 1
            return count
            
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                aliveNeighbours = countAliveNeighbours(board,i,j)
                #  0 -> 1 change indicated by 2
                #  1 -> 0 change indicated by 3
                
                if board[i][j] == 1 and aliveNeighbours <2:
                    board[i][j] = 3
                if board[i][j] == 1 and aliveNeighbours >3:
                    board[i][j] = 3
                if board[i][j] == 0 and aliveNeighbours == 3:
                    board[i][j] = 2
                    
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]  == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
