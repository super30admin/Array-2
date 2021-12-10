'''
// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Approach:
1.  have a another function checklives to calc lives in all 8 dirs
2.  1 will turn 2 if neighbors lives < 2 or > 3
    0 will turn 3 if neighbors exactly 3
3. do 1 last loop to change 2 to 0 and change 3 to 1
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        #TC: O(8mn) -> O(mn), SC: O(1)
        
        row, col = len(board), len(board[0])
        for i in range(row):
            for j in range(col):
                lives = self.checklives(board, i, j)
                if board[i][j] == 1 and (lives < 2 or lives > 3):
                    board[i][j] = 2
                elif board[i][j] == 0 and (lives == 3):
                    board[i][j] = 3
                    
        for i in range(row):
            for j in range(col):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
    
    def checklives(self, board, r, c):
        paths = [[1,0], [0,1], [-1,0], [0,-1], [-1,1], [1,1], [1,-1], [-1,-1]]
        count = 0
        m, n = len(board), len(board[0])
        for path in paths:
            nr = r + path[0]
            nc = c + path[1]
            if nr >=0 and nr < m and nc >= 0 and nc < n and (board[nr][nc] == 1 or board[nr][nc] ==2):
                count += 1
        return count