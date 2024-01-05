#time complexity : O(n)
#space complexity :O(1)


class Solution:
    def findMinMax(self,A,N): 
        #code here
        max = 0
        min = 0
        i = 0
        
        if N%2 != 0:
            max = A[0]
            min = A[0]
            i = 1
        else:
            if A[0] < A[1]:
                max = A[1]
                min = A[0]
            else:
                max = A[0]
                min = A[1]
            i = 2
            
        while i < N:
            if A[i] < A[i+1]:
                if A[i] < min:
                    min = A[i]
                if A[i+1] > max:
                    max = A[i+1]
            else:
                if A[i] >max:
                    max = A[i]
                    
                if A[i+1] < min:
                    min = A[i+1]
            
            i = i+2
        
        result = [min,max]
        return result
                    
                
sol = Solution()
arr = [-2, 1, -4, 5, 3]
n = len(arr)
res = sol.findMinMax(arr,n)
print("Maximun and minimum element of this list is:",res)
        


