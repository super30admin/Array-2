'''
Problem: Game of Life
Time Complexity: O(m * n ), where m is rows and n is cols
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        traverse the array and count alive neighbors
        apply rules, if transition 1->0 the replace with 2 and 0->1 with 3
        traverse again to change back 2 and 3
'''

class Solution:
    def countAlive(sel, board, i , j , dirs, m, n):
        count = 0
        for d in dirs:
            r = i+d[0]
            c = j+d[1]
            if r >=0 and c>=0 and r<m and c<n:
                if board[r][c]==1 or board[r][c]==2:
                    count+=1
        
        return count


    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        dirs=[(0,1), (1,0), (0,-1), (-1,0),(-1,-1), (-1,1), (1,-1), (1,1)]

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                count = self.countAlive(board, i , j, dirs, m, n)
                if board[i][j]==1:
                    if count<2 or count>3:
                        board[i][j] = 2
                else:
                    if count==3:
                        board[i][j] = 3

        for i in range(m):
            for j in range(n):
                if board[i][j]==2:
                    board[i][j]=0
                elif board[i][j]==3:
                    board[i][j]=1

