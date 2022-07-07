

# Time Complexity :O(mn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes



class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        neighbors = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        
        m = len(board)
        n= len(board[0])
        
        for i in range(m):
            for j in range(n):
                live_n=0
                for nei in neighbors:
                    r=i+nei[0]
                    c=j+nei[1]
                    if (r>=0 and r<m) and (c>=0 and c<n) and abs(board[r][c])==1:
                        live_n+=1
                    
                    
                if live_n ==3 and board[i][j] ==0:
                    board[i][j]=2
                
                elif (live_n >3 or live_n < 2) and abs(board[i][j]) ==1:
                    board[i][j]=-1
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] >0:
                     board[i][j] = 1
                else:
                     board[i][j] = 0
                
        return board        
            