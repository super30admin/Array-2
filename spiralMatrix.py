#Leetcode Problem 54
class Solution:
    def spiralOrder(self, matrix):
        nums=[]
        if len(matrix)==0:
            return nums
        top=0
        bottom=len(matrix)-1
        left=0
        right=len(matrix[0])-1
        size=(bottom+1)*(right+1)
        while(len(nums)<size):
            for i in range(left,right+1):
                if len(nums)<size:
                    nums.append(matrix[top][i])
            top+=1
            
            for i in range(top,bottom+1):
                if len(nums)<size:
                    nums.append(matrix[i][right])
            right-=1
            
            for i in range(right,left-1,-1):
                if len(nums)<size:
                    nums.append(matrix[bottom][i])
            bottom-=1
            
            for i in range(bottom,top-1,-1):
                if len(nums)<size:
                    nums.append(matrix[i][left])
            left+=1
            
        return nums

#TC: O(m*n)
#SC: O(1) no extra space used.
            