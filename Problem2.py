class Solution:
    def gameOfLife(self, b: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        #0->1 * 10
        #1->0 / 11
        ROWS, COLS = len(b), len(b[0])
        nei = [(1,0), (0, 1), (-1, 0), (0, -1), (1, 1), (1, -1), (-1, 1), (-1,-1)]
        for i in range(ROWS):
            for j in range(COLS):
                surrounding_ones = 0
                for r, c in nei:
                    ni, nj = i+r, j+c
                    if  0 <= ni < ROWS and 0 <= nj < COLS:
                        if not b[ni][nj] == 10 and b[ni][nj]!=0:
                            surrounding_ones += 1

                if b[i][j] == 1:
                    if surrounding_ones < 2 or surrounding_ones > 3:
                        b[i][j] = 11
                else:
                    if surrounding_ones == 3:
                        b[i][j] = 10
        print(b)

        for i in range(ROWS):
            for j in range(COLS):
                if b[i][j] == 10: b[i][j] = 1
                elif b[i][j] == 11: b[i][j] = 0

        
        
        
        
        
        
        
        
        



























        
        
        
        
        
        
        
        
        
        
        
        
        
