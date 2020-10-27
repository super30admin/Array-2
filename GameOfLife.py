#Time Complexity : O(n*m) 
#Space Complexity : o(1)

#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english: Iterate linearly through the given array and if the rules given are encountered then change the value at that according to the following mapping initially dead -> alive = 2 or initially alive -> dead = 3. Then go through the changed array again and change the values back to 0 or 1 according to the mapping. We need to maintain this mapping so the states changed do no affect the other elements.

#Your code here along with comments explaining your approach


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #0 -> 1 = 2
        #1 -> 0 = 3

        def countLives(board, i, j):
            count = 0
            dirs = [[0,1], [1,0], [-1, 0], [0, -1], [1,1], [-1,-1], [1,-1], [-1,1]]
            #iterate through all 8 directions
            for x,y in dirs:
                r,c = i+x, j+y
                if r >= 0 and r < len(board) and c>=0 and c<len(board[0]) and (board[r][c]==1 or board[r][c]==3):
                    count += 1

            return count

        #Iterate through the array and all the places the rules given are followed change the element according to the mapping.
        for i in range(len(board)):
            for j in range(len(board[0])):
                lives = countLives(board, i, j)
                if board[i][j] == 1 and (lives < 2 or lives > 3):
                    board[i][j] = 3
                if board[i][j] == 0 and (lives == 3):
                    board[i][j] = 2

        #Change array back to 0&1 according to new state
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 3:
                    board[i][j] = 0
                if board[i][j] == 2:
                    board[i][j] = 1
