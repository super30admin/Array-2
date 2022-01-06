# Time Complexity:O(MN)

class Solution:
    dirs = [[0,1],[0,-1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # if board == None:return None     
        for a in range(len(board)):
            for b in range(len(board[0])):
                count = self.countAlive(board,a,b)
                print(count)
                if board[a][b] == 1 and  (count <2 or count >3) :
                    board[a][b] = 2
                elif board[a][b] == 0 and count == 3 :
                    board[a][b] = 3
                 
        for a in range(len(board)):
            for b in range(len(board[0])):
                if board[a][b] == 2:
                    board[a][b] = 0
                elif board[a][b] == 3:
                    board[a][b] = 1
        
    def countAlive(self,board,a,b):
        count = 0 
        for x in self.dirs:
            # print(x)
            r =  a + x[0]
            c = b + x[1]
            
            if(r >= 0 and c >= 0 and r < len(board) and c < len(board[0])):
                if board[r][c]==1 or board[r][c]==2:
                    count += 1
        return count
            
                    
                    
                
        