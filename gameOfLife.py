'''
// Time Complexity : O(mxn)
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
https://leetcode.com/problems/game-of-life/

// Your code here along with comments explaining your approach

Used directions array to keep tab of all 8 directions we need to check for each given cell
used that to get the liveCount around each node and if:
1) A cell is alive, liveCount <2 or live Count >3 - It dies
2) If a cell is live and live count is ==2 or ==3 - > it lives
3) If live count is ==3 and cell was dead -> it will come alive

To modify matrix in place, we change 1-> -2 ->0 and 0 -> -3 -> 1
So to get liveCount we can look at all cells with value 1 and value -2
Then do a final pass whenre we change -2 to 0 and -3 to 1.
'''


class Solution:
    # If we are asked in an interview to just take 4 directions we can remove few items from this dirs list
    dirs =[[1,0], [0,1], [-1,0], [0,-1], [-1,1], [1,-1],[1,1],[-1,-1]]

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # if board was to be infinite, we will have to process mxn at a time
        # but in this case its finite
        for m in range(len(board)):
            for n in range(len(board[0])):
                lc = self.getLiveCount(board, m, n)
                if lc <2 or lc >3:
                    if board[m][n]==1 :
                        board[m][n] = -2
                elif lc == 3:
                    if board[m][n]==0:
                        board[m][n] = -3

        for m in range(len(board)):
            for n in range(len(board[0])):
                if board[m][n] == -2:
                     board[m][n] = 0
                elif board[m][n] == -3:
                     board[m][n] = 1
                        
    def getLiveCount(self, board, i, j) -> int:
        count = 0
        for d1,d2 in self.dirs:
            if (i+d1 >= 0 and j+d2 >=0 # check if both values are >=0 so its not out of bound or in python -ve index means reverse traversal of array, we want to avoid that
                and i+d1 < len(board) and j+d2 < len(board[0]) # check it is less than len of board and board[0] i.e. row len and col len
                and (board[i+d1][j+d2] == 1 # if the board location has value 1 or -2 -> increase count by 1
                or board[i+d1][j+d2] == -2)):
                count += 1

        return count
            
            