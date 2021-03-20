class Solution:
    # Start from the end of each List and Take two pointer approach to compare elements. 
    # Time Complexity: O(n+m)
    # Space Complexity: O(1)
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        idx1 = m-1
        idx2 = n-1
        end = m+n-1
        while idx1 >= 0 and idx2 >= 0:
            if nums1[idx1] >= nums2[idx2]:
                nums1[end] = nums1[idx1]
                idx1-= 1
                end -= 1
            else:
                nums1[end] = nums2[idx2]
                idx2-=1
                end -= 1
        nums1[:idx2+1] = nums2[:idx2+1]
        
                
                
            
        
