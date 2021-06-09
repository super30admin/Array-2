class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def finder(board, i , j , m , n):
            dirs = [[0,1], [0,-1], [-1,0], [1,0], [-1,-1], [-1,1], [1,-1], [1,1]]
            count =0
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                
                if (r >=0 and r<m and c>=0 and c<n and (board[r][c] == 1 or board[r][c] == 3)):
                    count += 1
            return count
        
        if board:
            # 0 -> 1 is 2
            # 1 -> 0 is 3
            m = len(board)
            n = len(board[0])
            
            for i in range(m):
                for j in range(n):
                    c = finder(board, i,j,m,n)
                    if board[i][j] ==1 and (c<2 or c>3):
                        board[i][j] = 3
                    if board[i][j] ==0 and c == 3:
                        board[i][j] = 2
            
            for i in range(m):
                for j in range(n):
                    if board[i][j] == 3:
                        board[i][j] = 0
                    if board[i][j] == 2:
                        board[i][j] = 1

#Time complexity is O(m*n) where m is the length of row and n is length of elements
#Space complexity is O(1) 
#Approach used is setting the dead element state to 3 and alive element transition to 2 and based on the count modified the board