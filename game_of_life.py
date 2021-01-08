# Time Complexity : O(m*n) where m and n are dimensions of array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, I had some mistakes in the edge-case conditions. I also
# forgot about the directions array created in the class.

# Your code here along with comments explaining your approach:
# I go through all cells counting alive cells in the 8 neighbour positions and changing 0 to 2 and 1 to 3 to 
# maintain original state of the array.

class Solution:
    def gameOfLife(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        for i in range(len(board)):
            for j in range(len(board[0])):
                alives = self.check_alives(board, i, j)
                if (alives < 2 or alives > 3) and board[i][j] == 1:
                    board[i][j] = 3
                if alives==3 and board[i][j] == 0:
                    board[i][j] = 2
                    
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
        return board
                
    def check_alives(self, board, i, j):
        alives = 0
        if j>0 and i>0 and (board[i-1][j-1] == 1 or board[i-1][j-1] == 3):
            alives += 1
        if i>0 and (board[i-1][j] == 1 or board[i-1][j] == 3):
            alives += 1
        if i>0 and j<len(board[0])-1 and (board[i-1][j+1] == 1 or board[i-1][j+1] == 3):
            alives += 1
        if j>0 and (board[i][j-1] == 1 or board[i][j-1] == 3):
            alives += 1
        if j<len(board[0])-1 and (board[i][j+1] == 1 or board[i][j+1] == 3):
            alives += 1
        if i<len(board)-1 and j>0 and (board[i+1][j-1] == 1 or board[i+1][j-1] == 3):
            alives += 1
        if i<len(board)-1 and (board[i+1][j] == 1 or board[i+1][j] == 3):
            alives += 1
        if i<len(board)-1 and j<len(board[0])-1 and (board[i+1][j+1] == 1 or board[i+1][j+1] == 3):
            alives += 1
        return alives
        
if __name__ == "__main__":
    s = Solution()
    print(s.gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))