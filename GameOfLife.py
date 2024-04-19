#TC: O(m*n)
#SC: O(1)

'''Game Of Life Rules:
1. 1 -> 0 if <2 or >3 live neighbors
2. 1 -> 1 if 2 or 3 live neighbors
3. 0 -> 1 if 3 live neighbors
'''

class Solution(object):

    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """

        #To modify current board, below logic follows state change so that current modification does not affect other cells decision
        #2 = live (previously dead)
        #3 = dead (previously live)

        self.m=len(board)    #rows
        self.n=len(board[0]) #columns

        for i in range(self.m):
            for j in range(self.n):
                live_count = self.countNeighbors(board,i,j)

                if board[i][j] == 1 and (live_count < 2 or live_count > 3):
                    board[i][j] = 3
                elif board[i][j] == 0 and live_count == 3:
                    board[i][j] = 2

        for i in range(self.m):
            for j in range(self.n):

                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0 
        print(board)


    def countNeighbors(self,board,i,j):
        count = 0
                   #UpperLeft | Up | UpperRight| Left | Right | BottomLeft | Bottom | BottomRight
        direction = [[-1,-1], [-1,0], [-1,1],   [0,-1], [0,1],    [1,-1],    [1,0],    [1,1]]
        m_dir = len(direction)      #8 rows

        live=0

        for dir_row in range(m_dir):
                row = i+direction[dir_row][0]
                col = j+direction[dir_row][1]

                if row >=0 and col>=0 and row<self.m and col<self.n:
                    if board[row][col] == 1 or board[row][col] == 3:
                        live +=1
        return live

obj = Solution()
board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
obj.gameOfLife(board)
        