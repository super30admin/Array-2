'''
Time Complexity: O(MN), where M is number of rows and N is number of columns
Space Complexity: O(1)
Executed Successfully: Yes
Challenges faced: No
'''


#CODE
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if board == []:
            return []
        m = len(board)
        n = len(board[0])
        dirs = [[0,1],[0,-1],[1,0],[-1,0],[1,-1],[-1,-1],[-1,1],[1,1]]
        for i in range(m):
            for j in range(n):
                count_alive = self.count_alive(board, i, j, dirs, m, n)
                if board[i][j] == 0 and count_alive == 3:
                    board[i][j] = 2
                if board[i][j] == 1 and (count_alive < 2 or count_alive > 3):
                    board[i][j] = 3
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                if board[i][j] == 3:
                    board[i][j] = 0
        return board
    
    def count_alive(self, board, i, j, dirs, m, n):
        res = 0
        for d in dirs:
            r = i + d[0]
            c = j + d[1]
            if r >= 0 and r < m and c >=0 and c < n and (board[r][c] == 1 or board[r][c] == 3):
                res += 1
        return res
            
        
                    
        
        