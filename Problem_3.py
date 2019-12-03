# Runs on Leetcode
# Runtime complexity:  O(mn)
# Memory complexity: O(mn)-used dictionary
# Faced problem to do in space changes

# will submit O(1) memory solution by evening

'''
Count_helper function helps counting the live cells surrounding a particular cell irrespective of its state.

While iterating through array, count is calculated and decision will be made based on the conditions given to live 
and dead cells. This decision is saved in a dictionary with index -(row,col) as key and true/false as value.

True indicates next state is 1
False indicates next state is 0

Iterating through the array again, the values are manipulated based on the dictionary values.
'''


class Solution:
    def count_helper(self,board,row,col,rows,cols):
        count = 0
        # saving different directions in c to calculate the live neighbors count
        c = [(0,1),(0,-1),(1,0),(-1,0),(-1,-1),(-1,1),(1,-1),(1,1)]
        for i in c:
            if row+i[0] >=0 and row+i[0]<rows and col+i[1]>=0 and col+i[1]<cols:
                if board[row+i[0]][col+i[1]] is 1:
                    count+=1
                else:
                    continue
        return count
    
    # live cells conditions check
    def live_helper(self,a):
        if a<2 or a>3:
            return False
        elif a==2 or a==3:
            return True
    
    # dead cells conditions check
    def dead_helper(self,a):
        if a==3:
            return True
        else:
            return False
        
    def gameOfLife(self, board):
        # edge case
        if not board:
            return []
        rows = len(board)
        cols = len(board[0])
        # dictionary to save updates states of cells
        d = {}
        for i in range(rows):
            for j in range(cols):
                if board[i][j] is 1:
                    # if the present cell is 1 calling live cells condition check on live neighbors count
                    d[(i,j)] = self.live_helper(self.count_helper(board,i,j,rows,cols))
                else:
                    # if the present cell is 0 calling live cells condition check on dead neighbors count
                    d[(i,j)] = self.dead_helper(self.count_helper(board,i,j,rows,cols))
                   
        
        # Changing original array based on saved values
        for i in range(rows):
            for j in range(cols):
                if d[(i,j)] is False:
                    board[i][j] = 0
                else:
                    board[i][j] = 1

