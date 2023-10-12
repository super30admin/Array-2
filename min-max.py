# // Time Complexity : O(N) - Single pass
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def findSum(self,A,N): 
        #code here
        if N == 1:
            return A[0] + A[0]
            
        myMin, myMax = float('inf'), -float('inf')
        if A[0] > A[1]:
            myMax = A[0]
            myMin = A[1]
        else:
            myMax = A[1]
            myMin = A[0]
        
        for i in range(2, N):
            if A[i] > myMax:
                myMax = A[i]
            elif A[i] < myMin:
                myMin = A[i]
            
        
        return myMin + myMax