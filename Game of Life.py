class Solution:
    L_to_D = -1
    L = 1
    # leetcode URL : https://leetcode.com/problems/game-of-life/
    # Problem : 289. Game of Life
    # Time Complexity : O(mn)
    # Space Complexity : O (1)
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        D_to_L = 2
        L_to_D = -1
        L = 1
        D = 0
        
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                live_count = self.get_live_count(board , i, j)
                if board[i][j] == L and (live_count <2 or live_count>3): # under-population & over population
                    board[i][j] = L_to_D
                if board[i][j] == D and live_count == 3:# reproduction
                    board[i][j] = D_to_L
        print(board)
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j] == D_to_L:
                    board[i][j] = L
                if board[i][j] == L_to_D:
                    board[i][j] = D
        
    def get_live_count(self,board , i, j):
        count = 0
        row = 0
        col = 0
        directions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        for (a,b) in directions:
            row = i+a
            col = j+b
            if 0<=row<len(board) and 0<=col<len(board[0]):
                if board[row][col] == self.L or board[row][col] == self.L_to_D:
                    count = count+1
        return count