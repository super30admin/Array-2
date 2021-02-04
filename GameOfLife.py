# Time Complexity : O(n*m) - n is length and m is width of matrix
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach
class Solution:
    
    # gives total alive cells in surroundings
    def getCount(self, board: List[List[int]], x: int, y: int ):
        
        count =0
        
        directions = [
        [0, -1],    # up
        [1, -1],    # up right
        [1, 0],     # right
        [1, 1],     # down right
        [0, 1],     # down
        [-1, 1],    # down left
        [-1, 0],    # left
        [-1, -1],   # left up
        ]
        
        for d in directions:
            if 0<=x+d[0]<len(board) and 0<=y+d[1]<len(board[x]) and (board[x+d[0]][y+d[1]]==1 or board[x+d[0]][y+d[1]]==2):
                count+=1
                
        return count
            
        
        
    def gameOfLife(self, board: List[List[int]]) -> None:
        
        # 2 = alive->dead
        # 3 = dead->alive
        """
        Do not return anything, modify board in-place instead.
        """
        for x in range(len(board)):
            for y in range(len(board[x])):
                count = self.getCount(board,x,y)
                
                if board[x][y]==1 and (count <2 or count >3):
                    board[x][y]=2
                    
                elif board[x][y]==0 and count ==3 :
                    board[x][y]=3
                    
                    
        for x in range(len(board)):
            for y in range(len(board[x])):
                if board[x][y] ==2:
                    board[x][y]=0
                elif board[x][y] ==3:
                    board[x][y]=1
                    
                    
                
                
                
        