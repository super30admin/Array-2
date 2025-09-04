class Solution(object):
    #     // Time Complexity : 8O(n*m)-> O(n*m)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # given condtions 
        # 1 live cell turns to 0 if there are less then 2 live neighbors or greater then 3 live neighrbors 
        # 1 will be 1 if there are 2-3 live neighbors 
        # 0 dead cell comes to live if it has exact 3 live neighrbors
        # neighbors are determinged by looking at top, bottom, up, right, diagonal right ->up,down, diagonal left -up,down
        # also given update the matrix in live so the determing the next stages based on the current stages only 
        # logic : create a new matrix and update the each new cell stages into that matrix by looking above condtions
        # but follow-up questioon : to do in place so update the current matrix plce itself but if i keep updating in the current matrix
        # it will distrub my next cell stages and the previous neighbors are updated 
        # trick logic if i am gng to change luve cell to dead cell i will update the current matrix as "D" indicating its dead 
        # but also when determing the next neighbors i will consider D means 1 as intially stage it was a live cell 
        # same if i am gng to change 0 to 1 then i wil indicate it as "L" but when checking conditions will check it as 0

        for row in range(len(board)):
            for col in range(len(board[0])):
                count = self.countneighbors(board,row,col)

                if board[row][col] == 0 and count == 3:
                    board[row][col] = "L"
                elif board[row][col] == 1 and (count < 2 or count > 3):
                    board[row][col] = "D"

        
        for row in range(len(board)):
            for col in range(len(board[0])):
                if board[row][col] == "L":
                    board[row][col] = 1
                if board[row][col] == "D":
                    board[row][col] = 0


        
    def countneighbors(self, board, i, j):
        count = 0
        dirs = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)] # all the 8 directions for each neighbors

        for rd, cd in dirs:
            r = i+ rd
            c = j + cd

            if 0 <= r < len(board) and 0 <= c < len(board[0]):
                if board[r][c] == 1 or board[r][c] == "D":
                    count +=1

        return count

                