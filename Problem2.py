# find min comparisions to find min and max
# brute force iterate throught the loop update min and max variable, once we find the min and max, by the end we get the min, max tc : O(n), sp = O(1)
# but the number of comparisions is n elements compared with min , max variables total 2n comparisions
# ok lets have this logic lets compare nums[i] and nums[i-1] which is less we update min by comparing the current min and the new min, rest value to max 
# number of comparisions for this logic is dng 3 comparisions but half of the loop only as index updated with 2 steps so total 3*n/2 = 1.5n comparisions 

# tc : O(n)
# sc : O(1)

class Solution:
    def get_min_max(self, arr):
        
        if len(arr) == 0:
            return [-1,-1]
        
        if len(arr) == 1:
            return [arr[0], arr[0]]
        
        # if we have even number of elements in arr
        if len(arr)%2 == 0:
            if arr[0] < arr[1]:
                min_val = arr[0]
                max_val = arr[1]
            else:
                min_val = arr[1]
                max_val = arr[0]
            i = 2
        else:
            min_val = max_val = arr[0]
            i = 1
            
        while i < len(arr)-1: # till we reach end of the array
            if arr[i] < arr[i + 1]:
                min_val = min(min_val, arr[i])
                max_val = max(max_val, arr[i + 1])
            else:
                min_val = min(min_val, arr[i + 1])
                max_val = max(max_val, arr[i])
            i += 2

        return [min_val, max_val]
        
        
            
            
    