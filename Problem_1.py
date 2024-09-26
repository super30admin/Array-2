class Solution:
	def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
		#return list((set(nums)^set([x for x in range(1,len(nums)+1)])))
		if not nums:
			return []
		for i in range(len(nums)):
			if nums[abs(nums[i])-1]>0:
				nums[abs(nums[i])-1] *= -1    
		ans = []
		for i in range(len(nums)):
			if nums[i]>0:
				ans.append(i+1)
			
		return ans


#Time complexity = O(n) iterating twice through list
#Space complexity = O(1)
#All test cases passed

#Tried using XOR operation on the 2 list and seemed to work fine too.