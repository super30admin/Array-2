## Problem3 (https://leetcode.com/problems/game-of-life/)

class Solution:
    def gameOfLife(self, b: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        r, c = len(b), len(b[0])

        for i in range(r):
            for j in range(c):
                t1, t0 = 0, 0
                
                #top
                if i > 0:
                    if b[i-1][j] == 1 or b[i-1][j] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                
                #left
                if j > 0:
                    if b[i][j-1] == 1 or b[i][j-1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                
                #down
                if i < r-1:
                    if b[i+1][j] == 1 or b[i+1][j] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                #right       
                if j < c-1:
                    if b[i][j+1] == 1 or b[i][j+1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                #topleft  
                if i > 0 and j > 0:
                    if b[i-1][j-1] == 1 or b[i-1][j-1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                # downright       
                if i < r-1 and j > 0:
                    if b[i+1][j-1] == 1 or b[i+1][j-1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                #bottomright        
                if i < r-1 and j < c-1:
                    if b[i+1][j+1] == 1 or b[i+1][j+1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                #topright
                if i > 0 and j < c-1:
                    if b[i-1][j+1] == 1 or b[i-1][j+1] == "-":
                        t1 += 1
                    else:
                        t0 += 1
                
                if b[i][j] == 1 and (t1 < 2 or t1 > 3):
                    b[i][j] = "-"
                if b[i][j] == 0 and (t1 == 3):
                    b[i][j] = "+"

        for i in range(r):
            for j in range(c):
                if b[i][j] == "+":
                    b[i][j] = 1
                if b[i][j] == "-":
                    b[i][j] = 0
                    
        <!-- #Time Complexity: O(mn)
        #Space Complexity: O(1) -->