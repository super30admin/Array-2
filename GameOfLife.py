  ---------------------- Game Of Life------------------------------------------------   
# Time Complexity : O(NXM) N is the rows of the matrix and M is the columns of matrix.
# Space Complexity : O(MXN) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# I am using different function to calculate the life of each and every element at the matrix index. 
#In the function , I will calculate the neighbors of that particular element and find the sum of the neighbors. 
#Based on the given conditions in the description of the problem, I will return the live or death of the cell.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        M = len(board)
        N = len(board[0])
        
        def recursion(board, i, j):
            if i<0 or i>len(board) or j<0 or j>len(board[0]):
                return
            neighbors = []
            for k in [-1,0,1]:
                for l in [-1,0,1]:
                    if 0<=i+k<M and 0<=j+l<N:
                        neighbors.append((i+k, j+l))
            
            
            neighbors.remove((i,j))
            
            target = sum([board[r][x] for r,x in neighbors])
            
            return 1 if (target in [2,3] and board[i][j] == 1) or (target==3 and board[i][j] ==0) else 0
        
        
        board[:] = [[dfs(board,i,j) for j in range(N)] for i in range(M)]