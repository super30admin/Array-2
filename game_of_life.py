# Time Complexity : O(m * n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # 1 --> 0 2
        # 0 --> 1 3
        
        if board == None or len(board) == 0:
            return
        
        m = len(board) - 1
        n = len(board[0]) - 1
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                count = self.countLives(board, i, j, m, n)
                # Rule 1 and 3
                if (board[i][j] == 1 and (count < 2 or count > 3)):
                    board[i][j] = 2
                # Rule 4 (no need of rule 2)
                if (board[i][j] == 0 and count == 3):
                    board[i][j] = 3
        print(board)
        for i in range(len(board)):
            for j in range(len(board[0])):
                # board 2 die so convert to die by 0
                if board[i][j] == 2:
                    board[i][j] = 0
                 # board 3 live so convert to die by 1
                elif board[i][j] == 3:
                    board[i][j] = 1
            #print(board)
        
    def countLives(self, board, i, j, m, n):
        count = 0
        #scalable 
        dirs = [[0,1] , [0,-1], [-1,0], [1,0], [-1,-1], [-1,1], [1,1], [1, -1]]
        for dir in dirs:
            r = i + dir[0]
            c = j + dir[1]
            
            #boundary condition
            if (r >= 0) and (c >= 0) and (r <= m) and (c <= n):
                if(board[r][c] == 1 or board[r][c] == 2):
                    count += 1
            
                
        return count
