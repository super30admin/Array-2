# https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
# // Time Complexity : O(nxm)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n, m = len(board), len(board[0])
        Dead_to_Live= 2
        Live_to_Dead = 3
        Live = 1
        Dead = 0
        
        for i in range(n):
            for j in range(m):
                count = 0
                #find live neighbours
                #top left
                if(i != 0 and j!=0):
                    if board[i-1][j-1] == 1 or board[i-1][j-1] == Live_to_Dead:
                        count += 1
                
                #top
                if(i != 0):
                    if board[i-1][j] == 1 or board[i-1][j] == Live_to_Dead:
                        count += 1
                
                #top right
                if(i != 0 and j!=m-1):
                    if board[i-1][j+1] == 1 or board[i-1][j+1] == Live_to_Dead:
                        count += 1
                
                #bottom left
                if(j!=0 and i!=(n-1)):
                    if board[i+1][j-1] == 1 or board[i+1][j-1] == Live_to_Dead:
                        count += 1
                
                #bottom
                if(i!=(n-1)):
                    if (board[i+1][j] == 1 or board[i+1][j] == Live_to_Dead):
                        count += 1
                
                #bottom right
                if(j!=(m-1) and i!=(n-1)):
                    if board[i+1][j+1] == 1 or board[i+1][j+1] == Live_to_Dead:
                        count += 1
                
                #left
                if(j!=0):
                    if (board[i][j-1] == 1 or board[i][j-1] == Live_to_Dead):
                        count += 1
                
                #right
                if(j!=(m-1)):
                    if (board[i][j+1] == 1 or board[i][j+1] == Live_to_Dead):
                        count += 1
                    
                if(board[i][j] == 1):
                    if (2<=count<=3):
                        pass
                    else:
                        board[i][j] = Live_to_Dead
                
                if(board[i][j] == 0):
                    if count==3:
                        board[i][j] = Dead_to_Live
                    else:
                        pass
        for i in range(n):
            for j in range(m):
                if board[i][j] == Live_to_Dead:
                    board[i][j] = 0
                elif board[i][j] == Dead_to_Live:
                    board[i][j] = 1
        return board