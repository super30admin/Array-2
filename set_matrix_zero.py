# Time Complexity : O(2MN)
# Space Complexity : O(M+N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# Just remember which rows and col needs to be made zero while iterating through the array
# and then just make them zeroes in the new iterationg

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        row_zero= [0]*len(matrix)
        col_zero= [0]*len(matrix[0])
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                if (matrix[i][j] == 0):
                    row_zero[i] = 1
                    col_zero[j] = 1
        for x in range(0,len(row_zero)):
            if(row_zero[x] == 1):
                for j in range(0,len(matrix[0])):
                    matrix[x][j]=0
        for y in range(0,len(col_zero)):
            if(col_zero[y] == 1):
                for i in range(0,len(matrix)):
                    matrix[i][y]=0
                    
        
            
    
