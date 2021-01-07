# Time Complexity : O(M*N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Needed class for this 
# question to learn about state changing



# Your code here along with comments explaining your approach

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        """
        GO over board and perform a count at each index. If at index it needs to be dead make it to 2
        if at index it needs to be alive make it 3
        iterate over the main board.. and change it.. 
        """
        if not board:
            return
        #go over board and get counts at each cell to determine 2/3
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.checkNeighbors(board,i,j)
                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
        #change 2/3 to respective 0/1 val
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                if board[i][j] == 3:
                    board[i][j] = 1
        
    def checkNeighbors(self, board, i, j):
        count = 0
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1],
                [-1, -1], [-1, 1], [1, -1], [1, 1]]
        
        for direction in directions:
            row = i + direction[0]
            col = j + direction[1]
            if (row >= 0 and row < len(board) and col >= 0 and col < len(board[0])):
                if (board[row][col] == 1 or board[row][col] == 2):
                    count += 1
        return count