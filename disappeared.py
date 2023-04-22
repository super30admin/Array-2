class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # d = {i:0 for i in range(1,len(nums)+1)}
        # res=[]
        # for i in nums:
        #     d[i]+=1
        # for i,j in d.items():
        #     if j==0:
        #         res.append(i)
        # return res
        # gives unique elements in the input array
        # m = list(set(nums))
        # m.sort()
        # counter = 1
        # miss = []
        # i = 0
        # while i < len(m):
        #     if m[i] == counter:
        #         i+=1
        #         counter+=1
        #     elif m[i] != counter:
        #         miss.append(counter)
        # return miss


        res = []
        for i,j in enumerate(nums):
            if j > 0:
                nums[abs(j)-1] *= -1
        for i,j in enumerate(nums):
            if j > 0:
                res.append(i+1)
            else:
                nums[i] = j * -1
        return res

