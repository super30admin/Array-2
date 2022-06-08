# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        
        iterate thru matrix, run count alive fn on each cell and based on that
        apply the rules and change the cells. 
        for 
        0 -> 1 -> 2, 
        1 -> 0 -> 3,
        then iterate thru matrix again and whatever is 
        2 -> 1, 
        3 -> 0
        
        count alive fn(m,n){
        gotta check all 8 neighbours. 
        have a neighbors arr [[-1,0],[0,1],[1,0],[0,-1],[-1,-1],[-1,1],[1,1],[1,-1]]
        then
        then row and col indices to check neighbors.
        for indxs in arr:
            rdx = m + indxs[0]
            cdx = n + indxs[1]
            if rdx and cdx are within bounds and its 1 count++
            return count
        }
        """
        
        
        def countAlive(i,j,m,n,neigh):
            count = 0
            for indx in neigh:
                rdx = i + indx[0]
                cdx = j + indx[1]
                if rdx > -1 and rdx < m and cdx > -1 and cdx < n and (board[rdx][cdx] == 1 or board[rdx][cdx] == 3):
                    count += 1
            #print(count,)
            return count
        
        m = len(board)
        n = len(board[0])
        neigh_arr = [[-1,0],[0,1],[1,0],[0,-1],[-1,-1],[-1,1],[1,1],[1,-1]]
        for i in range(m):
            for j in range(n):
                count = countAlive(i,j,m,n,neigh_arr)
                if (board[i][j] == 1 or board[i][j] == 3) and (count < 2 or count > 3):
                    board[i][j] = 3
                elif (board[i][j] == 0 or board[i][j] == 2) and (count == 3):
                    board[i][j] = 2
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0
        
        