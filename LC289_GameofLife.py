"""
Leetcode link : https://leetcode.com/problems/game-of-life/

considering only rules that change the state of the cell and using custom labels to restore it's original state.
if board[i][j] == 1 and AliveNeighbors < 2 \or AliveNeighbors> 3: next state = 0
if board[i][j]==0 and AliveNeighbors ==3 : next state = 1
    
Rule number 2 => no change to the state, so it can be ignored

 
            current state   alive neighborsm    next state
Rule 1 :                1            < 2                 0
Rule 3 :                1            > 3                 0
Rule 4 :                0              3                 1

To solve it without using extra space, we store the state changes using numbers other than 0,1 (any values will work)
0-->1    2
1-->0    3

TC = 8*O(mn) = as we find counfAlive traversing through all 8 neighbors for m*n elements
SC = O(1) = as we are doing in place operations

"""

# TC- O(8*m*n) = O(m*n), SC- O(1)
class Solution:
    def __init__(self) -> None:
        
        self.m= None
        self.n = None
        
        # 8 directions - top left, top, top right, left, right, bottom left, bottom, bottom right
        self.directions = [[0,1],[1,1],[1,0],[1,-1],[0,-1],[-1,-1],[-1,0],[-1,1]]
        
    def gameOfLife(self, board: list[list[int]]) -> None:
        
            if board is None:
                return board
            
            self.m = len(board)
            self.n = len(board[0])
            
            countAlive= 0

            for i in range(self.m):
                for j in range(self.n):
                    countAlive= self.countNeighbors(self.directions, board, i, j)
                    # Overpopulation or underpopulation
                    if board[i][j]==1 and (countAlive<2 or countAlive>3):
                        board[i][j]=3
                
                    if board[i][j]==0 and  countAlive==3:
                        board[i][j]=2
                        
            for i in range(self.m):
                for j in range(self.n):
                    if board[i][j]==3:
                        board[i][j]=1
                    if board[i][j]==2:
                        board[i][j]=0
                        
                    

    def countNeighbors(self, directions, board: list[list[int]], m : int, n: int)->int:
        countAlive = 0
            
        for dirr in directions:
            # for j in len(directions[0]):
            r = m+dirr[0]
            c = n+dirr[1]
            if r>=0 and c>=0 and r<self.m and c<self.n and (board[r][c]==1 or board[r][c]==3) :
                countAlive+=1
                    
        return countAlive
    
board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
print('Initial state:' ,board)

Solution().gameOfLife(board)
print('Next state of the board: ', board)
expected = [[0, 0, 0], [1, 0, 1], [0, 1, 1], [0, 1, 0]]
print('expected: ', expected)
                    

