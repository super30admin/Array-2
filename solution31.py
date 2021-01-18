#Time Complexity:O(2n)
#Space Complexity:O(1)
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        for elem in nums:					#for every element in the array
            idx=abs(elem)-1				
            nums[idx]=abs(nums[idx])*(-1)	#negating the element at position elem-1
        arr=[]
        for i in range(len(nums)):			#for every any element in the array
            if nums[i]>0:					#if element is positive
                arr.append(i+1)				#return its index+1 value
        return arr