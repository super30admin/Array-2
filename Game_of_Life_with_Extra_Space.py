# Created by Aashish Adhikari at 10:17 PM 1/7/2021

'''
Time Complexity:
O(m.n) where m and n represent the dimensions of the input matrix.

Space Complexity:
O(m.n) for the copied matrix.

'''

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """



        cop = copy.deepcopy(board)



        for idx in range(len(board)):

            for idxx in range(len(board[0])):

                ul, u, ur, l, r, bl, b, br = 0, 0, 0, 0, 0, 0, 0, 0

                #upper left
                if idx != 0:
                    if idxx != 0:
                        ul = cop[idx-1][idxx-1]

                # up
                if idx != 0:
                    u = cop[idx-1][idxx]


                # upper right
                if idx != 0:
                    if idxx != len(board[0])-1:
                        ur = cop[idx-1][idxx+1]


                # left
                if idxx != 0:
                    l = cop[idx] [idxx-1]


                #right
                if idxx != len(board[0])-1:
                    r = cop[idx][idxx+1]


                # bottom left
                if idx != len(board)-1:
                    if idxx != 0:
                        bl = cop[idx+1][idxx-1]

                # bottom
                if idx != len(board)-1:
                    b = cop[idx+1][idxx]


                # bottom right
                if idx != len(board)-1:
                    if idxx != len(board[0]) - 1:
                        br = cop[idx+1][idxx+1]


                neighbors_sum = ul + u + ur + l + r + bl +  b + br

                if board[idx][idxx] == 1:
                    if neighbors_sum < 2:

                        board[idx][idxx] = 0
                    elif neighbors_sum  == 2 or neighbors_sum == 3:
                        board[idx][idxx] = 1
                    else:
                        board[idx][idxx] = 0
                else:
                    if neighbors_sum == 3:
                        board[idx][idxx] = 1



