# As taught in class, Ii traversed the matrix in linear fashion abiding to the rules to geet the requested output.
# Time Complexity: O(rows*cols)
# Space Complexity: O(rows*cols)
def gameOfLife(arr):
    if (arr is None or len(arr)==0):
        return 0
    rows = len(arr)
    cols = len(arr[0])
    for i in range(rows):
        for j in range(len(arr[0])):
            lives = countLives(arr,i,j)
            if (arr[i][j] == 1 and (lives< 2 or lives > 3)):
                arr[i][j] = 2
            if (arr[i][j] == 0 and (lives == 3)):
                arr[i][j] = 3
    for i in range(rows):
        for j in range(cols):
            if (arr[i][j] == 3):
                arr[i][j] = 1
            if (arr[i][j] == 2):
                arr[i][j] = 0

def countLives(arr,i,j):
    count  = 0
    dirs = [{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}]
    for dirrection in dirs:
        neighborRow = i + dirs[0]
        neighborCol = j + dirs[1]
        if (neighborRow>=0 and neighborCol>=0 and neighborRow<len(arr) and neighborCol<len(arr[0]) and (arr[neighborRow][neighborCol] == 1 or arr[neighborRow][neighborCol] == 2)):
            count = count + 1

    return count
            
arr = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
gameOfLife(arr)