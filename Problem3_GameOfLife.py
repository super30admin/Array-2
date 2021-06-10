'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 289. Game of Life

#-----------------
# Time Complexity: 
#-----------------
# O(M*N): Where M is the no. of rows and N is no. of columns 
#         in the given board. Need to iterate over each element once
#         and compare with 8 (constant) of its neighbors.

#------------------
# Space Complexity: 
#------------------
# O(1): Not using any auxiliary data structure. In-place substitution

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             : 28 ms  (90.88 %ile)
# Space            : 14.2 MB (88.66 %ile)



from typing import List
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # imagine current index = board[i][j], then neighboring indices 
        # are board[i+0][j-1] (left),... and so on.

        neighbors = \
        [(-1, 0), (-1, 1), (0,1), (1,1), (1,0), (1, -1), (0,-1), (-1, -1)]
        # 0°         45°    90°    135°   180°    225°     270°     315°
        # Top(T)     TR      R      BR     L      BL        L       TL
        m = len(board)
        n = len(board[0])


        # The idea is to transform cells that go from Dead to Live as 0 -> 2
        # and Live to Dead as 1 -> -1.
        # Then, for current iteration consider 0 and 2 as Dead
        #       and 1 and -1 as Alive
        # In the next iteration consider 2 as 1 and -1 as 0
        for i in range(m):
            # O(M)

            for j in range(n):
                # O(N)
                count_1 = 0
                for k in range(len(neighbors)): # = 8 -> Constant
                    neighbor_i = i + neighbors[k][0]
                    neighbor_j = j + neighbors[k][1]

                    if(neighbor_i >= 0 and neighbor_j >= 0 \
                        and neighbor_i <= m-1 and neighbor_j <= n-1):
                        # Check if neighbor is within bounds
                        if abs(board[neighbor_i][neighbor_j])%2 == 1 :
                            # If it is 1 or -1, consider it as a 1
                            # If it is 0 or 2, consider it as a 0
                            count_1 += 1

                if abs(board[i][j])%2 == 1:
                    # If it is 1 or -1, consider it as a 1
                    # If it is 0 or 2, consider it as a 0
                    if count_1 < 2:
                        board[i][j] = -1
                    elif count_1 > 3:
                        board[i][j] = -1


                elif abs(board[i][j])%2 == 0:
                    if count_1 == 3:
                        board[i][j] = 2

        for i in range(m):
            for j in range(n):
                if board[i][j] > 1:
                # If it is 2 convert it to 1 in next step

                    board[i][j] = 1

                elif board[i][j] < 0:
                # If it is -1 convert it a 0 in next step

                    board[i][j] = 0

obj = Solution()
input_arr = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
expect_op = [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
obj.gameOfLife(input_arr)

# Not a typo. in-place change to input arr gives output
print(f"\nOutput: {input_arr}\nExpected:{expect_op}") 