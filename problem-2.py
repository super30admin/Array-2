# Leetcode Execution: YES
# Time Complexity:O(mn)
# Space Complexity:O(1)
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        """
        # first we creat all the neigbors we are allowed to check for each case
        neighbors=[[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        # loop thourg the matrix 
        for i in range(len(board)):
            for j in range(len(board[0])):
                count=0
                # counting the live neighbors
                # move along all the neighbors check if the neighbor is valid or not
                for x in neighbors:
                    if i+x[0]>=0 and i+x[0]<len(board) and j+x[1]>=0 and j+x[1]<len(board[0]):
             # increment live neighbor only if the neighbor value is 1 or 3, 1 states state not chnaged and still alive 
            # 3 states was alive but not anymore but we need that was aive 
#                 
                        if board[i+x[0]][j+x[1]]==1 or board[i+x[0]][j+x[1]]==3:
                            count+=1
                # now we check the current state and move along 
#                 we have only on case for dead, if live neighbors ==3 then comes to live
                if board[i][j]==0:
                    if count ==3:
                # mark new alive state as 4 for inplace chnages in matrix
                        board[i][j]=4
                else:
                    # for alive neighbors  only if netween 2 and 3 stays alive else die we mark new dead state as 3 in place changes
                    if count <2 or count >3:
                        board[i][j]=3
                        
        # loop to make 3 to 0 and 4 to 1 
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==3:
                    board[i][j]=0
                elif board[i][j]==4:
                    board[i][j]=1