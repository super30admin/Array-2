# gameOfLife
# time complexity: O(N)
# space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        So what we have is matrix and there are certian rules for that matrix
        We have the initial state as the input and now we need to transfor it to the 
        next state by the above rules. Make sure it is done simultaneously 
        """
        neighbors = [(1,0), (1,-1), (0,-1), (-1,-1), (-1,0), (-1,1), (0,1), (1,1)]
        rows = len(board)
        cols = len(board[0])
        copy_board = [[board[row][col] for col in range(cols)]for row in range(rows)]
        for row in range(rows):
            for col in range(cols):
               
                live_cells = 0
                for n in neighbors:
                    r = (row+n[0])
                    c = (col +n[1])
                    
                    if (r< rows and r >= 0 )and (c <cols and c >=0):
                        if abs(copy_board[r][c]) == 1:
                            live_cells += 1
                
                if board[row][col] == 1 and (live_cells < 2 or live_cells > 3):
                    board[row][col] = -1
                
                if board[row][col] == 0 and live_cells==3:
                    board[row][col] = 2
        
        for row in range(rows):
            for col in range(cols):
                if board[row][col] <= 0:
                    board[row][col] = 0
                else:
                    board[row][col] = 1
        
        return board