// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
 def findMinMax(A,n) : # find min and mix by incrementing in pairs of 2
    int max, min
    int i
    if ( n %2!=0 ): #if odd number of elements,only last element is in single pair
        max = A[0]
        min = A[0]
        i = 1
    
    else:
    
        if ( A[0] < A[1] ): # else everything is in pairs
        
            max = A[1]
            min = A[0]
        
        else:
        
            max = A[0]
            min = A[1]
        
        i = 2
    
    while ( i < n ): # traverse through the array, update max and min accordingly

        if ( A[i] < A[i+1] ):
        
            if ( A[i] < min ):
                min = A[i]
            if ( A[i+1] > max ):
                max = A[i+1]
        
        else:

            if ( A[i] > max ):
                max = A[i]
            if ( A[i+1] < min ):
                min = A[i+1] 

        i = i + 2

    // By convention, we assume ans[0] as max and ans[1] as min
   ans = [max, min] 
   return ans # return final answer

                
