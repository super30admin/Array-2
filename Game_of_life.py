// Time Complexity : O(mn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
#traverse through every element in the 2d array and check the neighbours of the element at 8 locations.since the problem asked to do an #inplace we have replaced the position with the value 3 when the value changes from 1 to 0 and replace the value with 5 when the value #changes from 0 to 1 so that we can have a track at what was the previous value and current value at that position.


class Solution(object):
    
    def pos_count(self,board,i,j):
        list_loc=[[-1,0],[-1,-1],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        count=0
        for pos in list_loc:
            r=i+pos[0]
            c=j+pos[1]
            if 0<=r<=len(board)-1 and 0<=c<=len(board[0])-1:
                if board[r][c]==1 or board[r][c]==3:
                    count=count+1
        return count
    
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if len(board)==0:
            return []
        for i in range(len(board)):
            for j in range(len(board[0])):
                posi=self.pos_count(board,i,j)
                if board[i][j]==0 and posi==3:
                    board[i][j]=5
                elif board[i][j]==1 and (posi<2 or posi>3):
                    board[i][j]=3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==3:
                    board[i][j]=0
                elif board[i][j]==5:
                    board[i][j]=1
        return board
