""" Explanation: Initialized an array to keep track of all 8 directions, using 0, 1 and -1. We traverse through the matrix to do an in-place
    manipulation. Using the conditions given in the question, we check and change 0 to 1 and so on, but with increments of 2, because
    ##   0              no change     dead             0
    ##   1              no change     live             1
    ##   0              changed (+2)  live             2
    ##   1              changed (-2)  dead            -1
    Time Complexcity: O(m*n)
    Space Complexcity: O(1)
"""


class Solution(object):
    def gameOfLife(self, b):
        """
        :type board: List[List[int]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        m, n = len(b), len(b[0])
        dirs = [[-1,-1],[-1,0],[-1,1],[0,1],[1,1],[1,0],[1,-1],[0,-1]]
        for i in range(m):
            for j in range(n):
                livecount = 0
                for r, c in dirs:
                    nr, nc = i + r, j + c
                    if 0 <= nr < m and 0 <= nc < n and abs(b[nr][nc]) == 1: # originally 1's
                        livecount += 1
                if b[i][j] == 1:
                    if livecount < 2 or livecount > 3:   
                        b[i][j] = -1
                else:
                    if livecount == 3:  
                        b[i][j] = 2
        
        for i in range(m):
            for j in range(n):
                if b[i][j] == 2:    b[i][j] = 1
                elif b[i][j] == -1: b[i][j] = 0
        