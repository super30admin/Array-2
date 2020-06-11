# Time Complexity : O(m x n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# 1 -> 0 = 3 (dies)
# 0 -> 1 = 2 (lives)
class Solution:
    def gameOfLife(self,board):
        result = []
        if not board:
            return result 
        for i in range(len(board)):
            for j in range(len(board[0])):
                live = self.checklives(board,i,j)
                if board[i][j] == 1:
                    if live > 3 or live < 2:
                        board[i][j] = 3
                else:
                    if live == 3:
                        board[i][j] = 2
                        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0 
                elif board[i][j] == 2:
                    board[i][j] = 1 

    def checklives(self,board,i,j):
        # dir = [[-1,0],[-1,-1],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,1],[1,1],[1,-1],[-1,-1]]
        count = 0 
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            if r >= 0 and c >= 0 and r < len(board) and c < len(board[0]) and (board[r][c] == 1 or board[r][c] == 3):
                count += 1 
        return count 

if __name__ == "__main__":
    s = Solution()
    board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    s.gameOfLife(board)
    print(board)
            