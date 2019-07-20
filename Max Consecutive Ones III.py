class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        # 1. Iterate through the array until we have K zeros. This is first window that is solution
        # 2. To find the longest subarray, Slide the start pointer such that first zero is excluded so that we can find next subarray with some other zero.
        # Time Complexity: O(N)
        # Space Complexity: O(1)
        
        start = 0
        end = 0
        max_len = 0
        zero_counter = 0
        while (start < len(A) and end < len(A)):
            # Slide until we find K zeros
            while (end < len(A) and zero_counter < K):
                if A[end] == 0:
                    zero_counter += 1
                end += 1
            # In case of we have some 1s after K zeros 
            while (end < len(A) and A[end] == 1):
                end += 1
            max_len = max(max_len,end-start)
            # Find the first zero in the current window to exclude
            while (start< len(A) and A[start] != 0):
                start += 1
            start += 1
            # Zero Counter Decrement
            zero_counter -= 1  
        return max_len
