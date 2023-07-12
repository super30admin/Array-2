# Time: O(mn)
# Space: O(mn), when all the cells needs to be updated
# did the code run successfully: yes
# issues faced: maintaining number of live neighbors

#Approach:
#verify if a cell needs to be updated in the next gen
#store all the indices of cells that needs to be updated and update them

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        nrows, ncols = len(board), len(board[0])
        change = deque()
        #ns = [(i,j) for i in range(-1,2) for j in range(-1,2) if i or j]
        def neighborCount(i, j):
            neighbors=[(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
            live = 0
            for m,n in neighbors:
                    r, c=i+m, j+n
                    if -1<r<nrows and -1<c<ncols:
                        if board[r][c]:
                            live+=1
            return live
        for i in range(nrows):
            for j in range(ncols):
                live = neighborCount(i, j) #gets number of live nerighbors
                if board[i][j]:
                    if live <2 or live>3:
                        change.append((i,j)) #if the cell is live and needs to be changed
                else:
                    if live == 3:
                        change.append((i,j)) #if cell id dead and to be made live
        while change:
            i, j = change.pop()
            board[i][j] = 1^board[i][j] #changing all the cells that needs to be changed
        return