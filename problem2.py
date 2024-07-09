# time: O(m.n)
# space: O(1)
class Solution:
    def getLiveNeighbors(self, board, row, col, dirn):
        count=0
        m = len(board)
        n = len(board[0])
        for d in dirn:
            r = row + d[0]
            c = col + d[1]
            
            if r>=0 and c>=0 and r<m and c<n and (board[r][c]==1 or board[r][c]==2):
                count+=1
        return count
        
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])
        
        # 1--0-->2
        # 0--1-->3
        dirn = [[0,1],[0,-1],[1,0],[-1,0],[-1,1],[1,1],[1,-1],[-1,-1]]
        for row in range(rows):
            for col in range(cols):
                count = self.getLiveNeighbors(board,row,col,dirn)
                
                # rule1 and 3: less than two live neighbors--2, more than three neighbors then dies--2
                if board[row][col] ==1 and (count<2 or count>3):
                    board[row][col] = 2
                
                # rule4: dead cell with more than three neighbors becomes ive--3
                if board[row][col] ==0 and count==3:
                    board[row][col] = 3
        
        for row in range(rows):
            for col in range(cols):
                
                if board[row][col]==2:
                    board[row][col]=0
                if board[row][col]==3:
                    board[row][col]=1
        
        
        
        