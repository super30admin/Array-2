#Time Complexity : O(m*n)

#Space Complexity : O(1) 

#Did this code successfully run on Leetcode : Yes

#Any problem you faced while coding this :None

# =============================================================================
# Solution: First count the live neighbirs for every elemnt, keeping in mind the index out of bound. Once you know the live neighbors then based on the conditions given in question
# make inplace changes, if element goes from dead to alive then make it 2 and if state of element changes from alive to dead then make it -1.
#after this trverse the matrix and whereever you find -1 chnage it to 0 and change 2 to 1.
# =============================================================================

def isvalid(board,row,col):
    return row >=0 and col >= 0 and row <len(board) and col <len(board[0])
l1= [-1,-1,-1,0,0,1,1,1]
l2= [-1,0,1,-1,1,-1,0,1]
def countneighbors(board,i,j):
    neighbors = 0
    for k in range(8):
        row = i +l1[k]
        col = j +l2[k]
        if isvalid(board,row,col):
            if board[row][col] == 1 or board[row][col] == -1:
                neighbors += 1
    return neighbors
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        if not board:
            return 
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = countneighbors(board,i,j)
                if board[i][j] == 1:
                    if count <2 or count >3:
                        board[i][j] = -1
                else:
                    if count==3:
                        board[i][j] = 2
        for i in range(len(board)):
            for j in range(len(board[0])):
                    if board[i][j] == -1:
                        board[i][j] = 0
                    if board[i][j] == 2:
                        board[i][j] = 1

