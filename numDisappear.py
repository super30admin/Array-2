"""
For each number val, make nums[abs(val) - 1] as negative : shows presence
Loop again, find indices i where nums[i] is still positive : means i + 1 is not there
Return collected missing numbers
"""
"""
Time Complexity:
O(n) — 2 passes over the array
Space Complexity:
O(1) — In-place
"""

class numDisappear:
    def findDisappearedNumbers(self, nums: list[int]) -> list[int]:

        for i in range(len(nums)):
            idx = abs(nums[i]) - 1
            if nums[idx] > 0:
                nums[idx] *= -1
        
        res = []
        for i in range(len(nums)):
            if nums[i] > 0:
                res.append(i + 1)
        
        return res
if __name__=="__main__":
    obj = numDisappear()
    nums = [4,3,2,7,8,2,3,1]
    print(obj.findDisappearedNumbers(nums))


        