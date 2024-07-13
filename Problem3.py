#I implemented the Game of Life rules by first creating a function to count live neighbors for each cell. This function carefully checks all eight adjacent cells, accounting for edge cases. Then, I iterate through the entire board, applying the rules to each cell. Instead of modifying the board immediately, I store the changes in a separate list called 'points'. This approach prevents changes from affecting subsequent calculations in the same iteration. Finally, I apply all the stored changes to the board at once. This method allows me to update the board in-place without using extra space for a complete copy of the board, adhering to the problem's constraint of modifying the input board directly.


class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """

        m = len(board)
        n = len(board[0])

        def getNeighbourLivesCount(x, y):
            count = (
                (board[x-1][y] if x>0 else 0) +
                (board[x-1][y-1] if x>0 and y>0 else 0) +
                (board[x-1][y+1] if x>0 and y<n-1 else 0) +
                (board[x+1][y] if x<m-1 else 0) +
                (board[x+1][y-1] if x<m-1 and y>0 else 0) +
                (board[x+1][y+1] if x<m-1 and y<n-1 else 0) +
                (board[x][y-1] if y>0 else 0) +
                (board[x][y+1] if y<n-1 else 0)
            )
            return count

        points = []
        for i in range(m):
            for j in range(n):
                count = getNeighbourLivesCount(i, j)
                if count<2 or count>3:
                    if board[i][j] != 0:
                        points.append((i,j,0))
                elif count==3:
                    if board[i][j] != 1:
                        points.append((i,j,1))
        
        for (i,j,val) in points:
            board[i][j] = val

