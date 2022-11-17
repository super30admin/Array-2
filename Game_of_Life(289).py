# Time Complexity: O(m*n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here the approach is:
# We need to make changes to the existing board and if we change 0->1 and 1->0
# the current state of the board will be changed and won't be able to make accurate evals
# So , For every dead element that was changed to live we make it -1 so that it is not counted
# as a current live element
# and for every live element that was changed to dead we make it 2 so that we can still count
# it towards the current live elements

# one approach is to compare the current element with all of the surrounding elements which would
# increase the comparisons
# what we do is maintain a count of the live elements surrounding the current element using the
# countLive method
class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows:int = len(board)
        cols:int = len(board[0])

        for row in range(rows):
            for col in range(cols):
                live = self.countLive(board,row,col)

                if board[row][col] == 0:
                    if live==3:
                        board[row][col] = -1
                else:
                    if live<2 or live>3:
                        board[row][col] = 2

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == 2:
                    board[row][col] = 0
                elif board[row][col] == -1:
                    board[row][col] = 1

    # we use the directions array to make changes to the array to check the elements
    # in all directions
    def countLive(self,board:List[List[int]] ,row,col) -> int:
        count = 0
        rows:int = len(board)
        cols:int = len(board[0])
        # compare = list([[row-1,col-1],[row-1,col],[row-1,col+1],[row,col-1],[row,col+1],[row+1,col-1],[row+1,col],[row+1,col+1]])
        directions = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        for elem in directions:
            # x = elem[0]
            # y = elem[1]
            x = row + elem[0]
            y = col + elem[1]
            if (x>=0 and x<rows) and (y>=0 and y<cols):
                # since we are making changes to the array in place, 1 and 2 both account for the
                # current live count
                if board[x][y] >0:
                    count+=1
        return count