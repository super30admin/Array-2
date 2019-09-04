
#time complexity : 0(n)
# felt little difficult to track the row and coloumns
class Solution(object):
    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        result = []
        if len(matrix) == 0:
            return result
        tr = 0
        rc = len(matrix[0]) - 1  # 2
        lc = 0
        br = len(matrix) - 1  # 3

        while ((tr <= br) and (lc <= rc)):
            for i in range(lc, rc + 1):
                result.append(matrix[tr][i])
            tr = tr + 1
            for j in range(tr, br + 1):
                result.append(matrix[j][rc])
            rc = rc - 1
            if ((tr <= br)):
                for i in range(rc, lc - 1, -1):
                    result.append(matrix[br][i])
                br = br - 1
            if (lc <= rc):
                for i in range(br, tr - 1, -1):
                    result.append(matrix[i][lc])
                lc = lc + 1
        return result