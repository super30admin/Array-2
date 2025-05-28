# // Time Complexity : approach 1 - o(m*n) approach 2 - o(m*n)
# // Space Complexity : approach1 - o(m*n) approach 2 - o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : faced issues when doing deepcopy and some syntax error


# // Your code here along with comments explaining your approach
# approach 1 idea create a copy of the matrix and then apply rules without mutating copy matrix and finding live neighbours
# approach 2 idea is to transform the mutated matrix to something other than 1 or 0 so that we can return to the same state again , make sure when counting the 1s you alos compare with mutated value

from typing import List
import copy
# approach 1:
# class Solution:
#     def gameOfLife(self, board: List[List[int]]) -> None:
#         """
#         Do not return anything, modify board in-place instead.
#         """
#         copyList = copy.deepcopy(board)
#         neighbours = [(0,1),(1,0),(-1,0),(0,-1),(-1,1),(-1,-1),(1,-1),(1,1)]
#         def countLive(r,c):
#             res =0
#             for i,j in neighbours:
#                 a,b = r+i, c+j
#                 if a>=0 and a <len(copyList) and b>=0 and b<len(copyList[0]) and copyList[a][b] == 1:
#                     res+=1
#             return res

#         for i in range(len(copyList)):
#             for j in range(len(copyList[0])):
#                 liveNeighbours = countLive(i,j)
#                 # Alive cell
#                 if copyList[i][j] == 1:
#                     if liveNeighbours < 2 or liveNeighbours >3:
#                         board[i][j] = 0
#                 elif copyList[i][j] == 0:
#                     if liveNeighbours == 3:
#                         board[i][j] = 1
         

        
# approach 2:
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        neighbours = [(0,1),(1,0),(-1,0),(0,-1),(-1,1),(-1,-1),(1,-1),(1,1)]
        def countLive(r,c):
            res =0
            for i,j in neighbours:
                a,b = r+i, c+j
                if a>=0 and a <len(board) and b>=0 and b<len(board[0]) and (board[a][b] == 1 or board[a][b] == 5):
                    res+=1
            return res

        for i in range(len(board)):
            for j in range(len(board[0])):
                liveNeighbours = countLive(i,j)
                # Alive cell
                if board[i][j] == 1 and (liveNeighbours < 2 or liveNeighbours >3):
                        board[i][j] = 5
                elif board[i][j] == 0 and liveNeighbours == 3:
                        board[i][j] = 4
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 4:
                    board[i][j] = 1
                if board[i][j] == 5:
                    board[i][j] = 0
            
         

        