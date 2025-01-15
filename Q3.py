####### Game of Life #######

# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Go through and keep checking the neighbouring elements and count the number of live elements.
# based on the live elements and the given conditions add new and prev state indicating values.
# then go through and only keep new state values

def game_of_life(grid):
    rows, cols = len(grid), len(grid[0])

    directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

    for i in range(rows):
        for j in range(cols):
            live_cnt = 0
            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                if 0 <= ni < rows and 0 <= nj < cols:
                    if grid[ni][nj] == 1 or grid[ni][nj] == 2:  
                        live_cnt += 1
                        
            if grid[i][j] == 1:  
                if live_cnt < 2 or live_cnt > 3:
                    grid[i][j] = 2 
            elif grid[i][j] == 0: 
                if live_cnt == 3:
                    grid[i][j] = 3  
                    
    for i in range(rows):
        for j in range(cols):
            if grid[i][j] == 2:
                grid[i][j] = 0  
            elif grid[i][j] == 3:
                grid[i][j] = 1  
