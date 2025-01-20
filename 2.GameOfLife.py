"""
Time Complexity: 0(6*mn) + 0(mn)
Space Complexity: 0(1)
Approach:
    1. Look into base conditions
    2. Mutate the board conditionally
        1 ---> 0 ---- (2) Conditions: count(1) < 2 || count(1) > 3
        0 ---> 1 ---- (1) Conditions: count(1) == 3
"""
class Solution:
    
    def __init__(self):
        self.dirMatrix = [

            [0,1], # N
            [0,-1], # S
            [1,0], # E
            [-1,0], # W

            [1,1], # NE
            [-1,1], # NW

            [1,-1], #SE
            [-1,-1] #SW

        ]

    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        # conditions
        rows = len(board)
        cols = len(board[0])

        """
        1 ---> 0 ---- (2) Conditions: count(1) < 2 || count(1) > 3
        0 ---> 1 ---- (1) Conditions: count(1) == 3
        """


        for x in range(0,rows):
            for y in range(0,cols):

                # get val 
                cal = board[x][y]

                # get count(1) for it's neighbors
                count_1 = 0

                for dir in self.dirMatrix:
                    # dir = [x,y]

                    temp_x = x + dir[0]
                    temp_y = y + dir[1]

                    if (temp_x >= 0 and temp_x < rows) and (temp_y >= 0 and temp_y < cols) and (board[temp_x][temp_y] >= 1):
                        count_1 += 1
                    
                # end of direction for-loop

                # check for count_1 for board[x][y] = 0 i.e. dead and board[x][y] = 1 i.e. alive
                if board[x][y] == 0 and count_1 == 3:
                    # dead-case -- set alive i.e. (-1)
                    board[x][y] = -1
                    continue
                
                elif board[x][y] == 1 and (count_1 == 2 or count_1 == 3):
                    # alive-case -- keep alive i.e. unchanged value
                    continue
                
                elif board[x][y] == 1 and (count_1 < 2 or count_1 > 3):
                    # alive-case -- set dead i.e. (2)
                    board[x][y] = 2

            # end of cols iteration
        # end of rows iteration

        # set the result to original
        for x in range(0,rows):
            for y in range(0,cols):
                if board[x][y] == 2:
                    board[x][y] = 0

                elif board[x][y] == -1:
                    board[x][y] = 1 
        # done

                

