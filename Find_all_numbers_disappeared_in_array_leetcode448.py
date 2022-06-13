class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # time complexity O(N)
        # Space complexity O(1)
        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] *= -1

        output = []
        for i in range(len(nums)):
            if nums[i] > 0:
                output.append(i + 1)

        return output

    '''
        hash_map = {}
        result = []
        for i in range(len(nums)):
            hash_map[nums[i]] = True

        for  num in range(1, len(nums)+1):
            if num not in hash_map:
                result.append(num)

        return result
    '''

