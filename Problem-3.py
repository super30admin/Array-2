"""
# Problem3 (https://leetcode.com/problems/game-of-life/)
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input:

[


  [0,1,0],


  [0,0,1],


  [1,1,1],


  [0,0,0]


]

Output:

[


  [0,0,0],


  [1,0,1],


  [0,1,1],


  [0,1,0]


]

Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?


"""
# brutforce will be create a new matrix by applying these rules and space and time complexity will be O(mn)
# we can optimize the space to O(1) by doing in place


#optimal solution
def Game_life(Matrix):
    if len(Matrix)==0 or Matrix==None:
        return
    rows=len(Matrix)
    cols=len(Matrix[0])
    for i in range(rows):
        for j in range(cols):
            # get count
            count = Count_Live(Matrix, i , j , rows, cols)   # function to count the live cells/neighbors #VERY IMPORTANT
            # live
            if Matrix[i][j]==1 and (count < 2 or count>3):
                Matrix[i][j]=5  # previously alive currently dead
            # dead
            elif Matrix[i][j]==0 and count==3:
                Matrix[i][j]=3   # previously dead currently alive
   #convert back 5 to 0 and 3 to 1
    for i in range(rows):
        for j in range(cols):
            if Matrix[i][j]==5:
                Matrix[i][j]=0
            elif Matrix[i][j]==3:
                Matrix[i][j] = 1

    return Matrix

def Count_Live(Matrix, x ,y, rows, cols):
    directions=[[0,1], [1,0] , [-1,0], [0,-1] , [1,1], [-1,1], [1,-1], [-1,-1]]
    count=0
   # if we choose if statements then we have to use 8 if statements like-- if x-1 >= 0 and x-1 < rows and y>=0 and y < cols:
    for direction in directions:
        r = x + direction[0]
        c = y + direction[1]

        # check out of bound conditiosn for 8 directions here and increase count accordingly
        if r >=0 and r < rows and c >=0 and c < cols and ( Matrix[r][c]==1 or Matrix[r][c]==5): # 5 means previosuly alive
            count += 1
    return count


print(Game_life([


  [0,1,0],


  [0,0,1],


  [1,1,1],


  [0,0,0]


]))