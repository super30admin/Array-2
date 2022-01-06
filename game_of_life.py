# TC : O(N)
# SC : O(1)
def check_boundary(grid, row, col):
    return (len(grid) > row and len(grid[0]) > col and row >= 0 and col >= 0)
 
class Solution:
    def gameOfLife(self, grid: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        p = len(grid)
        q = len(grid[0])
        u = [1, -1, 0, 1, -1, 0, 1, -1]
        v = [0, 0, -1, -1, -1, 1, 1, 1]
        for i in range(p):
            for j in range(q):
                # IF the initial value
                # of the grid(i, j) is 1
                if (grid[i][j] > 0):
                    for k in range(8):
                        if (check_boundary(grid, i + u[k], j + v[k]) and grid[i + u[k]][j + v[k]] > 0):
                            # If initial value > 0,
                            # just increment it by 1
                            grid[i][j] += 1

                # IF the initial value
                # of the grid(i, j) is 0
                else:
                    for k in range(8):
                        if (check_boundary(grid, i + u[k], j + v[k]) and grid[i + u[k]][j + v[k]] > 0):
                            # If initial value <= 0
                            # just decrement it by 1
                            grid[i][j] -= 1
        # Generating new Generation.
        
        for i in range(p):
            for j in range(q):
                # If initial value was 1.
                if (grid[i][j] > 0):
                    # Since Any live cell with
                    # < 2 live neighbors dies
                    if (grid[i][j] < 3):
                        grid[i][j] = 0

                    # Since Any live cell with
                    # 2 or 3 live neighbors live
                    elif (grid[i][j] <= 4):
                        grid[i][j] = 1

                    # Since Any live cell with
                    # > 3 live neighbors dies
                    elif (grid[i][j] > 4):
                        grid[i][j] = 0

                else:
                    # Since Any dead cell with
                    # exactly 3 live neighbors
                    # becomes a live cell
                    if (grid[i][j] == -3):
                        grid[i][j] = 1
                    else:
                        grid[i][j] = 0
 
        