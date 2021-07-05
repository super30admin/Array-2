class SolutionTwo(object):
    def findDisappearedNumbers(self, nums):
        retList = []
        for i in range(len(nums)):
            index=abs(nums[i])-1
            if nums[index] >0:
                nums[index]=-nums[index]
        for i in range(len(nums)):
            if nums[i]>0:
                retList.append(i+1)
        return retList
nums = [4,3,2,7,8,2,3,1]
sol2 = SolutionTwo()
print(sol2.findDisappearedNumbers(nums))


