#Problem 289. GAME OF LIFE
# TIME COMPELXITY: O(M * N) where M is the number of rows and N is the number of columns
# SPACE COMPLEXITY: O(1) given that all the changes are being done on the same matrix itself


class Solution(object):

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        directions=[(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]

        def countOnes(i,j):
            counter=0
            for dx,dy in directions:
                r,c=i+dx, j+dy
                if 0<=r<(len(board)) and 0<=c<(len(board[0])):
                    if board[r][c]==1 or board[r][c]==2:
                        counter+=1
            return counter

        for i in range(len(board)):
            for j in range(len(board[0])):
                countOfOnes=countOnes(i,j)
                if board[i][j]==0 and countOfOnes==3:
                    board[i][j]=3
                elif board[i][j]==1 and (countOfOnes<2 or  countOfOnes>3):
                    board[i][j]=2

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1