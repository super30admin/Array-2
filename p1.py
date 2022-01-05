class Solution:
    def findDisappearedNumbers( nums: list[int]) -> list[int]:
        """
        create hashmap: keep track of 1 to num length
        increment numbers in array in map
        return numbers in hashmap = 0

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode :
    // Any problem you faced while coding this :


// Your code here along with comments explaining your approach
        """
        arrMap = (nums)
        array = [0] * len(nums)
        
        return [i for i in range(1,len(nums)+1)if i not in arrMap]


    arr = [1,1,4,4]
    print(findDisappearedNumbers(arr))