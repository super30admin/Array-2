# Runs on Leetcode
# Runtime complexity:  O(mn)
# Memory complexity: O(mn)-used dictionary
# Faced problem to do in space changes

class Solution:
    def count_helper(self,board,row,col,rows,cols):
        count = 0
        c = [(0,1),(0,-1),(1,0),(-1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
        for i in c:
            if row+i[0] >=0 and row+i[0]<rows and col+i[1]>=0 and col+i[1]<cols:
                if board[row+i[0]][col+i[1]] is 1:
                    count+=1
                else:
                    continue
        return count
    
    def live_helper(self,a):
        if a<2 or a>3:
            return False
        elif a==2 or a==3:
            return True
        
    def dead_helper(self,a):
        if a==3:
            return True
        else:
            return False
        
    def gameOfLife(self, board):
        if not board:
            return []
        rows = len(board)
        cols = len(board[0])
        d = {}
        for i in range(rows):
            for j in range(cols):
                if board[i][j] is 1:
                    d[(i,j)] = self.live_helper(self.count_helper(board,i,j,rows,cols))
                else:
                    d[(i,j)] = self.dead_helper(self.count_helper(board,i,j,rows,cols))
                   
            
        for i in range(rows):
            for j in range(cols):
                if d[(i,j)] is False:
                    board[i][j] = 0
                else:
                    board[i][j] = 1

