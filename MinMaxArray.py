class Solution:
    """
    Time complexity - O(n). n - size of nums
    Space complexity - O(1)
    no of comparisions - 3 * (n/2)
    """
    def findMinMax(self, nums):
        result = []
        mini = 0
        maxi = 0
        if len(nums) % 2 == 0:
            mini = min(nums[0], nums[1])
            maxi = max(nums[0], nums[1])
            i = 2
        else:
            mini = nums[0]
            maxi = nums[0]
            i = 1
        while i < len(nums)-1:
            if nums[i] < nums[i+1]:
                mini = min(nums[i], mini)
                maxi = max(nums[i+1], maxi)
            else:
                mini = min(nums[i+1], mini)
                maxi = max(nums[i], maxi)
            i += 2
        print(" min - ", mini)
        print(" max - ", maxi)
    
def main():
    s =Solution()
    s.findMinMax([0,90,-90,100])
main()