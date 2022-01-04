# Time Complexity : O(MN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
'''
        The Key Trick Here is 
        encoded = new * k + old
        getOld = encoded  % k
        getNew = encoded // k
'''


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        directions = [(1,1), (-1,-1), (-1,1), (1,-1), (1,0), (0,1),(-1,0),(0,-1)]
        for row in range(len(board)):
            for col in range(len(board[0])):
                alive = 0
                dead = 0
                for d in directions:
                    adjRow, adjCol = row + d[0], col + d[1]
                    if 0 <= adjRow < len(board) and 0 <= adjCol < len(board[0]):
                        if board[adjRow][adjCol] % 2 == 1:
                            alive += 1
                        elif board[adjRow][adjCol] % 2 == 0:
                            dead += 1
                if board[row][col] % 2 == 1:
                    if alive < 2 or alive > 3:
                        board[row][col] = 0 * 2 + 1
                    else:
                        board[row][col] = 1 * 2 + 1
                else:
                    if alive == 3:
                        board[row][col] = 1 * 2 + 0
                    else:
                        board[row][col] = 0 * 2 + 0
        
        for row in range(len(board)):
            for col in range(len(board[0])):
                board[row][col] = board[row][col] // 2
        
        
                
                