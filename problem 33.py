# https://leetcode.com/problems/game-of-life/


# Time Complexity : O(mn)
# Space Complexity : O(1) contant because of inplace modification
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
# check all directions and get the count of no of 1's for each cell and based on that we decide 
# if it will be 1 or 0, but since we depend upon the previous values and not the updated values we 
# update the values as 2 and 3 where 2 mean originally 1 changed to 0 and 3 means vice versa
# after that we traverse and change the values back to what it is.

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        for i in range (m):
            for j in range(n) :
                count = self.countalives(board,i,j,m,n)
                if(board[i][j] == 1 and (count < 2 or count > 3)):
                    board[i][j] = 2 # 1 -> 0 = 2
                if(board[i][j] == 0 and count == 3):
                    board[i][j] = 3 # 0 -> 1 = 3
        
        for i in range (m):
            for j in range (n):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
    
    def countalives(self, board: List[List[int]], i: int, j: int, m:int, n:int) -> int:
        dirs = [[0,1], [1,0], [-1,0],[0,-1],[1,1],[-1,1],[1,-1],[-1,-1]]
        count = 0
        for dir in dirs:
            nr = i + dir[0]
            nc = j + dir[1]
            if (nr >= 0 and nr < m and nc >= 0 and nc < n) and (board[nr][nc] == 1 or board[nr][nc] == 2):
                count+=1

        return count
