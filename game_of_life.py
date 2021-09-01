# // Time Complexity : O(m*n) where m*n: number of elements in the matrix
# // Space Complexity : updated input array in-place
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        directions = [[1,0],[0,1],[-1,0],[0,-1],[-1,-1],[1,1],[-1,1],[1,-1]]
        rows = len(board)
        cols = len(board[0])
        
        arr = [2,-2]
        hashmap = {2:1,-2:0}
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = 0
                for dx,dy in directions:
                    if 0 <= i+dx < rows and 0 <= j+dy < cols and board[i+dx][j+dy] in [-2,1]:
                        count += 1
                if count < 2 or count > 3: # cell dies if not already dead
                    if board[i][j] == 1:
                        board[i][j] = arr[1] 
                else: # 3 <= 2 and <= 3
                    if count == 3 and board[i][j] == 0:
                        board[i][j] = arr[0] # comes alive in next state
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = hashmap[2]
                elif board[i][j] == -2:
                    board[i][j] = hashmap[-2]
        
                        
                