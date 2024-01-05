'''

Time Complexity : O(n^2)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach:
The original board is transformed, by checking the neighbors for each cell, and the board is updated in-place based on
the transitions. 0 -> 0 to 0, 1 -> 0 to 1, 2 -> 1 to 0 and 3 -> 1 to 1
'''




class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.        """

        col = len(board[0])
        row = len(board)

        def count_neighbors(num,i,j):
            zero = 0
            one = 0

            if j+1 >=0 and j+1 <= col - 1 and i >=0 and i <= row - 1:
                if board[i][j+1] == 2 or board[i][j+1] == 3:
                    one += 1
                else:
                    zero += 1

            if j-1 >=0 and j-1 <= col - 1 and i >=0 and i <= row - 1:
                if board[i][j-1] == 2 or board[i][j-1] == 3:
                    one += 1
                else:
                    zero += 1

            if j-1 >=0 and j-1 <= col - 1 and i-1 >=0 and i-1 <= row - 1:
                if board[i-1][j-1] == 2 or board[i-1][j-1] == 3:
                    one += 1
                else:
                    zero += 1

            if j >=0 and j <= col - 1 and i-1 >=0 and i-1 <= row - 1:
                if board[i-1][j] == 2 or board[i-1][j] == 3:
                    one += 1
                else:
                    zero += 1

            if j+1 >=0 and j+1 <= col - 1 and i-1 >=0 and i-1 <= row - 1:
                if board[i-1][j+1] == 2 or board[i-1][j+1] == 3:
                    one += 1
                else:
                    zero += 1

            if j-1 >=0 and j-1 <= col - 1 and i+1 >=0 and i+1 <= row - 1:
                if board[i+1][j-1] == 2 or board[i+1][j-1] == 3:
                    one += 1
                else:
                    zero += 1

            if j >=0 and j <= col - 1 and i+1 >=0 and i+1 <= row - 1:
                if board[i+1][j] == 2 or board[i+1][j] == 3:
                    one += 1
                else:
                    zero += 1

            if j+1 >=0 and j+1 <= col - 1 and i+1 >=0 and i+1 <= row - 1:
                if board[i+1][j+1] == 2 or board[i+1][j+1] == 3:
                    one += 1
                else:
                    zero += 1

            print([zero,one])
            return [zero,one]


        def check_neighbor(num,i,j):
            print(num,i,j)
            arr = count_neighbors(num,i,j)

            if num == 2 or num == 3:
                if arr[1] == 2 or arr[1] == 3:
                    return 3
                else:
                    return 2
            else:
                if arr[1] == 3:
                    return 1
                else:
                    return 0

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 1:
                    board[i][j] = 3
                if board[i][j] == 0:
                    board[i][j] = 0

        for i in range(len(board)):
            for j in range(len(board[0])):
                board[i][j] = check_neighbor(board[i][j],i,j)

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 1 or board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 0 or board[i][j] == 2:
                    board[i][j] = 0