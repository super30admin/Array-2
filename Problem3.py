#Time Complexity : O(m*n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        row = len(board)
        col = len(board[0])
        count=0
        def countneighbours(r,c):
            count = 0
            for i in range(r-1,r+2):
                for j in range(c-1,c+2):
                    if ((i == r and j==c) or i < 0 or j < 0 or i==row or j==col):
                        continue
                    if board[i][j] in [1,3]:
                        count +=1
            return count
    
        
        for i in range(0,row):
            for j in range(0,col):
                neigh = countneighbours(i,j)
                if board[i][j] and neigh in [2,3]:
                    board[i][j] = 3
                elif neigh == 3:
                    board[i][j] = 2
                    
        for i in range(0,row):
            for j in range(0,col):
                if board[i][j] == 1:
                    board[i][j] = 0
                elif board[i][j] in [2,3]:
                    board[i][j] = 1
                    
        return board
                    
        
                    
                        