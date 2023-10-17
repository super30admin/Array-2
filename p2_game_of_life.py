class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Time Complexity: O(m x n)
        Space Complexity: O(1)
        Did this code successfully run on Leetcode: Yes 

        Any problem you faced while coding this:
        Your code here along with comments explaining your approach:
        The approach:
            - The rules:
                - x = 1 -> 0 if neigh < 2 or neigh > 3
                - x = 1 -> 1 if 2 <= neigh <= 3
                - x = 0 -> 1 if neigh = 3
                - x = 0 -> 0 if neigh != 3 
            - create a hash map for keeping track of the changes
                - if live cell changes to dead cell we put value 2 
                - if dead cell changes to live cell we put the value 1
            - So we create the hash_map = {0: 0, 1: 1, 2: 1, 3: 0}
 
            - Traverse the Matrix 
            - Check the neighbors of the element and return no of live cells
                - we use hashmap to get the actual live cell in the neighbors 
                - since we change the matrix on the go, we need to use hashmap to 
                get the original value 
                - if the count == 3 and element value = 0 then change the value to 3 
                - if the count < 2 or count > 3 and element value = 1 then change the value to 2
                - we keep the rest of the values as it is 
            - We get the matrix in the transformed form 
            - Now to get the final matrix, traverse the matrix again and do the following:
                - change the value 2 -> 0
                - change the vlaue 3 -> 1 
            - return the board
        """
        hash_map = {
            0 : 0,
            1 : 1,
            2 : 1,
            3 : 0}        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                count = self.AliveOrNot(board, i, j, hash_map)
                if board[i][j] == 0 and count == 3:
                    board[i][j] = 3
                elif board[i][j] == 1 and (count < 2 or count > 3):
                    board[i][j] = 2

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1
        return board
    
    def AliveOrNot(self, board, row, col, hash_map):
        upper_left = (row-1, col-1)
        upper_center = (row -1, col)
        upper_right = (row-1, col+1)
        center_left = (row, col-1)
        center_right = (row, col+1)
        lower_left = (row+1, col-1)
        lower_center = (row+1, col)
        lower_right = (row+1, col+1)
        neighbor_list = [
            upper_left,
            upper_center,
            upper_right,
            center_left,
            center_right,
            lower_left,
            lower_center,
            lower_right,
        ]
        count = 0
        for x, y in neighbor_list:
            if x < 0 or x > len(board) - 1  or y > len(board[0]) -1 or y < 0:
                pass
            else:
                count += hash_map[board[x][y]]
        return count
        