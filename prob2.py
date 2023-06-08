# Time Complexity :O(n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def findSum(self,A,N): 
        #code here
        if N==1:
            return 2*A[0]
        else:
            maximum = A[0]
            minimum = A[0]
            for i in range(N-1):
                if A[i] <= A[i+1]:
                    minimum = min(minimum, A[i])
                    maximum = max(maximum, A[i+1])
                else:
                    minimum = min(minimum, A[i+1])
                    maximum = max(maximum, A[i])
                    
            return minimum+maximum