# Time: O(mn)
# Space: O(1)
# did the code run successfully: yes
# issues faced: none

#Approach:
#verify if a cell needs to be updated in the next gen
#maintain new state 2 for live cell that dies in next gen
# similarly new state 3 for dead cell that comes alive in next gen
#compute live neighbor cells if it is state 1 or state 2
#at last change all state 2 cells to state 0 and state 3 cells to state 1

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        nrows, ncols = len(board), len(board[0])
        def neighborCount(i, j):
            neighbors=[(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
            live = 0
            for m,n in neighbors:
                    r, c=i+m, j+n
                    if -1<r<nrows and -1<c<ncols:
                        if board[r][c]==1 or board[r][c]==2:
                            live+=1
            return live
        for i in range(nrows):
            for j in range(ncols):
                live = neighborCount(i, j) #gets number of live neighbors
                if board[i][j]:
                    if live <2 or live>3:
                        board[i][j] = 2 # 1 to 0
                else:
                    if live == 3:
                        board[i][j] = 3 # 0 to 1
        for r in range(nrows):
            for c in range(ncols):
                if board[r][c]==2: board[r][c]=0
                elif board[r][c]==3: board[r][c]=1
        return