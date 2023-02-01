# Time Complexity : O(m*n)
# Space Complexity : O(1)

# first need to check all 8 neighbors using direction array 
# count the live neighbors 
# according to that count check the given conditions to change the state of that cell
# to maintain the histrory of the state, will use some dummy numbers instead to change it
# for example, if state is intially 0, and it change to 1. so I will put 2 to that cell, 
# so can have information about intial state and use this information for another neighbors
class Solution:
    # direction array to check neighbous 
    direction = [[0,1],[0,-1],[1,0],[-1,0],[-1,-1],[-1,1],[1,1],[1,-1]]
    def gameOfLife(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])

        for i in range(0,m):
            for j in range(0,n):
                # count the live states in neighbors
                countLive = self.countLiveNeighbors(board,i,j,m,n)
                if countLive == 3 and board[i][j] == 0:
                    # change state from 0 to 1
                    # temporaray set to 2
                    board[i][j] = 2
                if board[i][j] == 1 and (countLive < 2 or countLive > 3):
                    # change state from 1 to 0
                    # temporaray set to 3
                    board[i][j] = 3

        # change tempraray (2 to 1) and (3 to 0)
        for i in range(0,m):
            for j in range(0,n):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0


        
    # function to count live nighbors 
    def countLiveNeighbors(self,board,i,j,m,n):
        result = 0
        for dire in self.direction:
            nr = i + dire[0]
            nc = j + dire[1]
            if nr >= 0 and nc >= 0 and nr < m and nc < n and (board[nr][nc] == 1 or board[nr][nc] == 3):
                result += 1
        return result


    