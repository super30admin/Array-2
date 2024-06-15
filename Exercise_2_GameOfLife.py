# Time Complexity :

# O(m*n) 


# Space Complexity :  

# O(1) 


# Approach:
# Encode the state transitions using the constraints, 
# then reiterate the board array, to bring back the state values to 0 or 1, depending on the live or dead state 
# they were supposed to transition into



class Solution(object):
    def __init__(self):
        self.rows = 0
        self.cols = 0
    def gameOfLife(self, board):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        if not board or len(board)==0:
            return
        
        #encoding: 2 (live===>dead)
        #encoding:3 (dead===>live)
        self.rows = len(board)
        self.cols = len(board[0])

        # ===> iterate through the array to manipulate the cell states
        for i in range(0, self.rows):
            for j in range(0, self.cols):
                countLiveNb = self.countLiveNbs(board, i, j)
                # Check if current cell is live or dead
                if board[i][j] == 1:
                    # check acc to countLiveNb
                    if countLiveNb < 2 or countLiveNb > 3:
                        # encode it with value for making dead (live ===> dead)
                        board[i][j] = 2
                else:
                    if countLiveNb == 3:
                        # encode it with value for making live (dead ===> live)
                        board[i][j] = 3
        
        # ===> reiterate through the array to make the encoded values back to 0 or 1 depending on the
        #      new "cell state" they transitioned into, 
        # ===> i.e 2 becomes 0, 3 becomes 1
        for i in range(0, self.rows):
            for j in range(0, self.cols):
                if board[i][j] == 2:
                    board[i][j] = 0
                
                if board[i][j] == 3:
                    board[i][j] = 1

        return board


    def countLiveNbs(self, board, row, col):
        count = 0

        # 8 neighbors(direction)
        dirs = [[-1,0], [-1,-1], [-1,1], 
               [0,-1], [0, 1],
               [1,-1], [1,0], [1, 1]]

        for dir in dirs:
            nr = row + dir[0]
            nc = col + dir[1]

            if (nr >= 0 and nr < self.rows) and (nc >=0 and nc < self.cols) :
                # 1's are live, and 2's were encoded for new state"dead", meaning they were "live" before
                if board[nr][nc] == 1 or board[nr][nc] == 2:
                    count+=1 

        return count

        