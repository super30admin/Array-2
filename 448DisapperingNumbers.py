from typing import List

def findDisappearingNumbers(nums:List[int]) -> List[int]:
    # iterate each number from the list first 
    for number in nums:
        index = abs(number)-1
        if index < len(nums) and nums[index] > 0:
            nums[index] *= -1
        
    missing_numbers = [i+1 for i, x in enumerate(nums) if x > 0]
    return missing_numbers

print(findDisappearingNumbers([1,1]))