# Time complexity : O(n)
# Space complexity : O(1)
class Solution:
    def minmax(self, arr):
        n = len(arr)
        min_num = max_num = 0
        
        # for even numbers, we get the min and max from the first two numbers, and start the index from 2
        if n%2 == 0:
            min_num = min(arr[0],arr[1])
            max_num = max(arr[0],arr[1])
            
            i = 2
        else:
            # for odd numbers, we make the min and max as the first element and start from index 1
            min_num = max_num = arr[0]
            i = 1
        
        # we traverse till the end of the list, and keep on checking the elements in pairs and compare them
        # with the current max and min numbers
        while i < n-1:
            if arr[i] < arr[i+1]:
                min_num = min(min_num,arr[i])
                max_num = max(max_num,arr[i+1])
            else:
                min_num = min(min_num,arr[i+1])
                max_num = max(max_num,arr[i])
            i += 2
        
        # at the end we return the max and min numbers in a list
        return [min_num, max_num]

s = Solution()
arr = [1,-3,4,7,6,3]
res = s.minmax(arr)
print(res)
