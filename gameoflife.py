# time complexity is o(M*N)
# no doubts
# brute force methord is create an extra matrix, count the number of live cell around it and update the particular position in the new ,matrix. But we are not supposed to use extra matrix
# was getting an error because of error in the direction list. I had written the same tuple twice
#ran on leetcode after struggling too mcuh
# so we mark the matrix with markings. WE can't make all 1's and
# zeros and go ahead beacuse it will affect the other cells. So we are marking the live cell as dead cell by marking it as 2(1 ->2)
# so we wil know this is the cell which is supposed to be dead. Likewise, make a dead cell mark alive by marking the 0 as 3 (0->3).
# So all the 3's will tell us that these cells were supposed to be 1

# in the end we iterate through the matrix and make all 2's into 0 and all 3's into 1


class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0], [-1, 1], [1, 1], [1, -1],
                     [-1, -1]]  # making a list of directions
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = 0

                for d in direction:

                    if (i + d[0] < 0 or i + d[0] >= len(board) or j + d[1] < 0 or j + d[1] >= len(board[0])):
                        continue
                    if board[i + d[0]][j + d[1]] == 1 or (board[i + d[0]][j + d[1]] == 2):  # index out of range
                        count = count + 1

                if board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2
                if (board[i][j] == 0 and count == 3):
                    board[i][j] = 3

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1






