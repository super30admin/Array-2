"""
https://practice.geeksforgeeks.org/problems/max-min/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

Time Complexity : O(n) where n is the number of elements in the A
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
1. Declare variables min and max and initialized them to infinity and -infinity
2. Comapre each element of A and update min and max accordingly

Total numberof comparisons:
1 + 2 * (N-2)
"""
class Solution:
    def findSum(self,A,N): 
        #code here
        minimum = float('inf')
        maximum = float('-inf')
        
        for i in range(N):
            if A[i] > maximum:
                maximum = A[i]
            if A[i] < minimum:
                minimum = A[i]
        
        return maximum + minimum