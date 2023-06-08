"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Comparing the values in the input array in pair in order to minimize the comparison, if the next element is greater than the last
then comparing it with max and comparinf the previous element with min and repeating until we reach the end of the array

"""

# Maximum and minimum of an array

class Solution:
    def findSum(self,A,N): 

        mini=A[0]
        maxi=A[0]
        
        for i in range(0,N,2):
            
            if i<N-1:
                if A[i]>A[i+1]:
                    maxi=max(A[i],maxi)
                    mini=min(A[i+1],mini)
                else:
                    maxi=max(maxi,A[i+1])
                    mini=min(mini,A[i])
            
            elif i==N-1:

                maxi=max(A[i],maxi)
                mini=min(mini,A[i])
                
        return maxi+mini