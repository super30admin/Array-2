class Solution:
    def minimumDeletions(self,nums):
        n=len(nums)
        min_i=nums.index(min(nums))
        max_i=nums.index(max(nums))

        if min_i>max_i:
            min_i,max_i=max_i,min_i

        front=max(min_i,max_i)+1
        back=max(n-min_i,n-max_i)
        both=min(min_i+1+(n-max_i),max_i+1+(n-min_i))

        return min(front,back,both)
    
sol=Solution()
print(sol.minimumDeletions(nums=[2,10,7,5,4,1,8,6]))
print(sol.minimumDeletions(nums=[0,-4,19,1,8,-2,-3,5]))
print(sol.minimumDeletions(nums=[101]))