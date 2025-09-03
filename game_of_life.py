'''
iterate over the grid, count live neighbors around the curr element as center.
Apply the rules to change the state. We can follow the state/state change as
        Original 
            1 - live, 
            0 - dead
        Transition state change
            live to dead : 3
            dead to live : 4
When counting the live neighbors, we check for '1' or '3' as they were originally live. 
Make a second iteration over the board, and replace the transition state with 0/1 as their 
final expected state. 
Time complexity: O(8*N^2) ~ O(N^2)
Space Complexity: O(1): No auxilary space (just integer variables)
'''
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        '''
        Original 
            1 - live, 
            0 - dead
        live to dead : 3
        dead to live : 4
        '''
        rows = len(board)
        cols = len(board[0])

        for i in range(rows):
            for j in range(cols):
                # get live neighbors count
                live_neighbhors = self.count_live_neighbors(board,i,j)

                # curr cell was originally live
                if board[i][j] == 1:
                    if live_neighbhors <2:
                        board[i][j] = 3
                    elif live_neighbhors > 3:
                        board[i][j] = 3
                # curr cell was originally dead
                elif board[i][j] == 0:
                    if live_neighbhors == 3:
                        board[i][j] = 4
        
        # finally update the states as expected
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 4:
                    board[i][j] = 1
    
    def count_live_neighbors(self,board,r,c):
        count = 0 # count of live neighbors
        for i in [-1,0,1]:
            for j in [-1,0,1]:
                if i==0 and j==0:
                    continue # curr element whose neighbors are to be checked. 
                n_r = r + i # neighbor row
                n_c = c + j # neighbor col

                # sanity check of boundary conditions
                if 0<=n_r<len(board) and 0<=n_c<len(board[0]):
                    if board[n_r][n_c] == 1 or board[n_r][n_c] == 3:
                        count+=1
        return count 

