# // Time Complexity : O(n*m) 
# // Space Complexity : O(1)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : understanding the logic how to keep the track of changed value while calculating the new change for current position.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 0-> 1 = 3
        #1 -> 0 = 4
        dir = [(0,1),(1,0),(0,-1),(1,-1),(-1,0),(-1,1),(1,1),(-1,-1)]

        def countAlive(board,i,j):
            count = 0
            for x in range(len(dir)):
                print(x,dir[0][0])
                nr = i + dir[x][0]
                nc = j + dir[x][1]
                
                if ((nr >= 0 and nr < len(board)) and (nc >= 0 and nc < len(board[0]))) and (board[nr][nc] == 1 or board[nr][nc] == 4):
                    count += 1
            return count

        for i in range(len(board)):
            for j in range(len(board[0])):
                alives = countAlive(board, i,j)
                if board[i][j] == 1:
                    if alives > 3 or alives < 2:
                        board[i][j] = 4
                else:
                    if alives == 3:
                        board[i][j] = 3
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 1
                if board[i][j] == 4:
                    board[i][j] = 0

Approach:
1. Count the number of alive cells around the current cell. For that I used directions array to check all 8 directions from current position.
From this I return the count of ones around current position.
2. If the current cell is alive and the count of alive cells around it is greater than 3 or less than 2 convert it to 4.
3. Or else if the board value for current position is 0 and  the count is 3 we change the 0 to 1 by putting value 3.ValueError
4. Finally we change the 3 to 1 and 4 to 0.