#Time Complexity : O(M*N), N being the length of the array and M being the width. 
#Space Complexity : O(1), because not array is used. 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Kept mixing i and j while typing and then 
#having to find the mistype while debugging. 

#Your code here along with comments explaining your approach in three sentences only
'''Create a direction array and use it to find the 8 neighbor values. Then add the 
live values and use the given conditions to change the array values to new values. 
'''
class Solution:
    #initialize direction array. 
    def __init__(self):
        self.directions = [[-1,0], [1,0], [0,-1], [0,1], [1,1], [-1,1], [-1,-1], [1, -1]]

    #to change a single value on board if needed. 
    def change(self, board, i, j):
        live = 0
        for d in self.directions:
            d_i = i+d[0]
            d_j = j+d[1]
            if d_i>=0 and d_i<len(board) and d_j>=0 and d_j<len(board[0]):
                if board[d_i][d_j]==1 or board[d_i][d_j]==3:
                    live = live + 1
        #new values that are not 1 or 0. 
        if board[i][j]==1 and live<2:
            board[i][j]=3
        if board[i][j]==1 and live>3:
            board[i][j]=3
        if board[i][j]==0 and live==3:
            board[i][j]=2


    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows = len(board)
        cols = len(board[0])

        #1->0: 3
        #0->1: 2

        #call change function for each value in board. 
        for i in range(rows):
            for j in range(cols):
                self.change(board, i, j)
        #change values that are 2/3 to 1/0. 
        for i in range(rows):
            for j in range(cols):
                if board[i][j]==3:
                    board[i][j]=0
                if board[i][j]==2:
                    board[i][j]=1