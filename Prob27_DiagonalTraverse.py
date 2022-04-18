#Time Complexity : O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        m = len(mat)
        n = len(mat[0]) if m > 0 else 0
        if n == 0:
            return []

        result = [0 for i in range(m*n)]
        up = True
        row = col = 0

        for i in range(m*n):
            result[i] = mat[row][col]

           
            if up:
                if col == n - 1:
                    row = row + 1
                    up =  not up
                elif row == 0:
                    col = col + 1
                    up = not up
                else:
                    row = row - 1
                    col = col + 1

            
            else:
                if row == m - 1:
                    col = col + 1
                    up = not up
                elif col == 0:
                    row = row + 1
                    up = not up
                else:
                    row = row + 1
                    col = col - 1

        return result