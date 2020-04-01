#Time Complexity - O(m,n)
#Space Complexity - O(1)

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if not board: 
            return board
        
        row, col = len(board), len(board[0])
        prev = copy.deepcopy(board)
        for i in range(row):
            for j in range(col): 
                # if the cell is live
                if prev[i][j] == 1:
                    live = self.getLiveNeighbors(prev, i, j)
                    if live < 2 or live > 3:
                        board[i][j] = 0
                        
                # if the cell is dead
                else:
                    live = self.getLiveNeighbors(prev, i, j)
                    if live == 3:
                        board[i][j] = 1                  
                        
                    
    def getLiveNeighbors(self, prev, x, y):
        row, col = len(prev), len(prev[0])
        count = 0
        shift = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for tup in shift:
            dx, dy = tup[0], tup[1]
            if 0 <= x+dx < row and 0 <= y+dy < col and prev[x+dx][y+dy] == 1:
                count += 1
                
        return count
