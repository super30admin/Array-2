'''
Time complexity: O(m*n) because we traverse through the matrix
Space Complexity: O(1) because we are not using any extra space --> smae board and only res variable for count that keeps updating
Leetcode: Sucess!
Problem: None. Just developing the concept a little
'''

class Solution:
    def gameOfLife(self, board) -> None:
        """
        Rules:
        R1. <2 alive --> dies
        R2. >3 alive --> dies
        R3. ==3 alive --> lives
        Do not return anything, modify board in-place instead.
        """
        # initialize the m and n
        m = len(board)
        n = len(board[0])

        # 1 ---> 0 :: 3
        # 0 ---> 1 :: 2

        # checking the board and if any node complies with the rules of the game
        for i in range(m):
            for j in range(n):
                count = self.countLives(board, i, j, m, n)
                if board[i][j]==1 and (count<2 or count > 3): # Rule 1 and Rule 2 from comments above
                    board[i][j] = 3
                if board[i][j]==0 and count == 3:
                    board[i][j] = 2
        print(board)
        # change the values changed in the matrix back to original value i.e., where there is 3 it should be 0 and 2 should turn to 1
        for i in range(m):
            for j in range(n):
                if board[i][j]==3:board[i][j] = 0
                if board[i][j]==2:board[i][j] = 1

        # returns the board
        return board

    def countLives(self, board, i, j, m, n):
        res = 0
        # initialize dirs list with co-ordinated of the neighbors
        dirs = [[0,1],[0,-1],[1,0],[-1,0],
                [1,1],[1, -1],[-1,1],[-1,-1]]
        r = 0
        c = 0
        for dir in dirs:
            print("i: ",i)
            r = i + dir[0]
            print("r: ",r)
            print("j: ", j)
            c = j + dir[1]
            print("c: ",c)
            # checking for alive neighbors
            if (r>=0 and r < m and c >= 0 and c < n and (board[r][c]==1 or board[r][c]==3)):
                # add to the count the resultant count
                res +=1
        # return result
        return res


board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
s = Solution()
print("After playing Game of Life ----> \n",s.gameOfLife(board))
