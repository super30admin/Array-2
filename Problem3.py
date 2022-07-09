'''
Problem2
Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison


'''

'''
Time Complexity : 
Space Complexity : 

'''
'''
Approach : 
        Do not return anything, modify board in-place instead.
       
        Rules
        >2 nei dies (1->0)
        ==2 0r 3 lives (1->1)
        <3 dies (1->0)
        ==3 lives(0->1)
       
'''

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
 
        m = len(board) 
        n = len(board[0]) 
        for i in range(m):
            for j in range(n):
                countnei = self.getneicount(board,i,j)
                if (board[i][j] == 1):
                    # rule 1
                    
                    if(countnei< 2 or countnei > 3):
                        board[i][j] = 3
                else :
                    if(countnei == 3):
                        board[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if (board[i][j] == 3):
                    
                    board[i][j] = 0
                elif (board[i][j] == 2):
                    board[i][j] = 1
                    
        
        
        
    def getneicount(self,board,r,c):
        m = len(board)
        n = len(board[0])
        count = 0
        dirarr = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,1],[1,0],[1,-1]]
        for diri in dirarr:
            nr = r + diri[0]
            nc = c + diri[1]
            if ((nr<m and nr>=0) and (nc < n and nc >=0)) and (board[nr][nc] == 1 or board[nr][nc] ==3):
                count = count + 1
            
        return count
