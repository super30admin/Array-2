# Created by Aashish Adhikari at 11:18 AM 1/8/2021

'''
Time Complexity:
O(m . n)

Space Complexity:
O(1)
'''

class Solution(object):
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        for idx in range(len(board)):

            for idxx in range(len(board[0])):

                ul, u, ur, l, r, bl, b, br = 0, 0, 0, 0, 0, 0, 0, 0

                #upper left
                if idx != 0:
                    if idxx != 0:

                        if board[idx-1][idxx-1] == 2:
                            ul = 1
                        elif board[idx-1][idxx-1] == 3:
                            ul = 0
                        else:
                            ul = board[idx-1][idxx-1] # no change

                # up
                if idx != 0:

                    if board[idx-1][idxx] == 2:
                        u = 1
                    elif board[idx-1][idxx] == 3:
                        u = 0
                    else:
                        u = board[idx-1][idxx]



                # upper right
                if idx != 0:
                    if idxx != len(board[0])-1:

                        if board[idx-1][idxx+1] == 2:
                            ur = 1
                        elif board[idx-1][idxx+1] == 3:
                            ur = 0
                        else:
                            ur = board[idx-1][idxx+1]



                # left
                if idxx != 0:


                    if board[idx] [idxx-1] == 2:
                        l = 1
                    elif board[idx] [idxx-1] == 3:
                        l = 0
                    else:
                        l = board[idx] [idxx-1]



                #right
                if idxx != len(board[0])-1:


                    if board[idx][idxx+1] == 2:
                        r = 1
                    elif board[idx][idxx+1] == 3:
                        r = 0
                    else:
                        r = board[idx][idxx+1]



                # bottom left
                if idx != len(board)-1:
                    if idxx != 0:


                        if board[idx+1][idxx-1] == 2:
                            bl = 1
                        elif board[idx+1][idxx-1] == 3:
                            bl = 0
                        else:
                            bl = board[idx+1][idxx-1]



                # bottom
                if idx != len(board)-1:


                    if board[idx+1][idxx] == 2:
                        b = 1
                    elif board[idx+1][idxx] == 3:
                        b = 0
                    else:
                        b = board[idx+1][idxx]



                # bottom right
                if idx != len(board)-1:
                    if idxx != len(board[0]) - 1:

                        if board[idx+1][idxx+1] == 2:
                            br = 1
                        elif board[idx+1][idxx+1] == 3:
                            br = 0
                        else:
                            br = board[idx+1][idxx+1]




                neighbors_sum = ul + u + ur + l + r + bl +  b + br

                if board[idx][idxx] == 1:

                    if neighbors_sum < 2:

                        board[idx][idxx] = 2
                    elif neighbors_sum  == 2 or neighbors_sum == 3:
                        board[idx][idxx] = 1
                    else:
                        board[idx][idxx] = 2
                else:
                    if neighbors_sum == 3:
                        board[idx][idxx] = 3



        for idx in range(0, len(board)):
            for idxx in range(0, len(board[0])):

                if board[idx][idxx] == 2:
                    board[idx][idxx] = 0
                if board[idx][idxx] == 3:
                    board[idx][idxx] = 1
