# Time Complexity : O(2MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# Take the count of live cells and if a cell goes from livde to dead make it 2
# if a cell goes from dead to live make it 3 and at the end do a modulo 2 to all the elements

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        dir = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1,],[1,0],[1,1]]
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                live_count = 0
                for d in dir:
                    if ( (i+d[0] < 0) or (i+d[0] >= len(board)) or (j+d[1] < 0) or (j+d[1] >= len(board[0]))):
                        continue
                    if((board[i+d[0]][j+d[1]] == 1) or (board[i+d[0]][j+d[1]] == 2)):
                        live_count+=1
                if(board[i][j] == 1 and (live_count < 2 or live_count > 3)):
                    board[i][j] = 2
                if(board[i][j] == 0 and (live_count == 3)):
                    board[i][j] = 3
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                board[i][j]%=2
        
