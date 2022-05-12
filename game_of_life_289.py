#Time Complexity O(MN) 8 times search neighbour for all elements
#Space Complexity O(1)
#It successfully runs on the leetcode

def gameOfLife(matrix):
        """
        Do not return anything, modify board in-place instead.
        """
        
        direction =[(-1,-1),(-1,0), (-1,1), (0,-1),(0,1),(1,-1),(1,1),(1,0)]

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                nei = 0
                for x,y in (direction):
                    if (i+x < len(matrix) and j+y < len(matrix[0]) and i+x >= 0 and j+y >= 0):
                        if matrix[i+x][j+y]== 1 or matrix[i+x][j+y]== 3 : 
                            nei+=1
                if matrix[i][j]==0 and nei == 3:
                    matrix[i][j]=2
                if matrix[i][j]==1 and (nei < 2 or nei > 3):
                    matrix[i][j]=3

        print(matrix)


        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 2:
                    matrix[i][j]=1
                if matrix[i][j] == 3 :
                    matrix[i][j]=0

print(gameOfLife([[0,1,0],[0,0,1],[1,1,1],[0,0,0]]))