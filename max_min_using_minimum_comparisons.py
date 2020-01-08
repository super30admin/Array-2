from typing import List


class Solution:

    def find_max_min_using_minimum_comparisons(self, nums: List[int]) -> tuple:
        """
          // Time Complexity : O(3((N-1)/2))
                    No comparison for the first element. So N-1.
                    The number of pairs is N-1/2.
                    For each pair we have three comparisons.
                    So, 3 * no. of pairs.
          // Space Complexity : O(1)
          // Did this code successfully run on Leetcode : N/A
          // Three line explanation of solution in plain english
                !!! Think in pairs !!!
                - Take a pair, find cur_min and cur_max among them.
                - Don't need to compare both elements of the pair with
                  both max_val and min_val.
                - Just compare cur_max with max_val and cur_min with min_val
         // Brute force:
                We will have 4 comparisons for each pair:
                    - compare each element in the pair with max_val
                    - compare each element in the pair with min_val
                Time: O(2N-1)
        """
        max_val = nums[0]
        min_val = nums[0]

        length = len(nums)

        for i in range(1, length, 2):
            # last index, no pair
            if i == length - 1:
                max_val = max(max_val, nums[i])
                min_val = min(min_val, nums[i])
            # if first element in the pair is greater
            # then second element in pair is lesser
            elif nums[i] > nums[i + 1]:
                max_val = max(max_val, nums[i])
                min_val = min(min_val, nums[i + 1])
            # else second element in the pair is greater
            # first element in the pair is lesser
            else:
                max_val = max(max_val, nums[i + 1])
                min_val = min(min_val, nums[i])

        return max_val, min_val

    def find_max_min_using_divide_and_conquer(self, nums: List[int]) -> tuple:
        """
            // Time Complexity : O(logn)
            // Space Complexity : O(logn)
            // Did this code successfully run on Leetcode : N/A
            // Three line explanation of solution in plain english
                - Divide the array into two halves.
                - Search for the min and max both in the left and right halves
                  recursively and compare each time when we have 3 values (odd case)
                  and 4 values (even case) from both the halves.
                - Using Divide and Conquer startegy
        """
        return self._helper(nums, 0, len(nums) - 1)

    def _helper(self, nums: List[int], start: int, end: int) -> tuple:

        mid = (start + end) // 2

        # base case
        # there are two elements
        if end - start == 1:
            return max(nums[start], nums[end]), min(nums[start], nums[end])
        # there is single element
        if start == mid:
            return nums[start], nums[start]

        # logic
        # min, max from the left half
        max_1, min_1 = self._helper(nums, start, mid)
        # min, max from the right half
        max_2, min_2 = self._helper(nums, mid, end)
        return max(max_1, max_2), min(min_1, min_2)


if __name__ == '__main__':
    h = Solution()
    print(h.find_max_min_using_divide_and_conquer([2, 5, 6, 4, 9, 10]))
    print(h.find_max_min_using_divide_and_conquer([2, 5, 6, 10, 3]))
    print(h.find_max_min_using_divide_and_conquer([12, 5, 6, 10, 3]))
    print(h.find_max_min_using_divide_and_conquer([12, 5, 6, 10, -3]))
    print(h.find_max_min_using_divide_and_conquer([-12, -5, -6, -10, -3]))
    print(h.find_max_min_using_minimum_comparisons([2, 5, 6, 4, 9, 10]))
    print(h.find_max_min_using_minimum_comparisons([2, 5, 6, 10, 3]))
    print(h.find_max_min_using_minimum_comparisons([12, 5, 6, 10, 3]))
    print(h.find_max_min_using_minimum_comparisons([12, 5, 6, 10, -3]))
    print(h.find_max_min_using_minimum_comparisons([-12, -5, -6, -10, -3]))
