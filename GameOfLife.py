# Did it run successfully on LC? YES

class Solution:
    def gameOfLife(self, b):
        """
        Do not return anything, modify board in-place instead.
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

if __name__ == "__main__":
    s = Solution()
    b = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
    print(s.gameOfLife(b))
        