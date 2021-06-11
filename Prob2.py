#Time complexity: O(m*n)   
#Space complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if board is None or len(board) == 0:
            return
        #1->0 is represented by 2
        #0->1 is represented by 3
        
        def numOfAlive(board,i,j):
            num = 0
            m = len(board)-1
            n = len(board[0])-1
            li = [(-1,0),(-1,-1),(-1,+1),(0,-1),(0,+1),(1,-1),(1,0),(1,1)]
            for el1,el2 in li:
                x = i + el1
                y = j + el2
                if x>m or y>n or x<0 or y<0:
                    continue
                if board[x][y] == 1 or board[x][y] == 2:
                    num +=1
            return num
                
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                count = numOfAlive(board,i,j)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif (count>3 or count<2) and board[i][j] == 1:
                    board[i][j] = 2
        
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                elif board[i][j] == 2:
                    board[i][j] = 0
        return

