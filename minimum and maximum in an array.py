# TC-O(n)
# SC-O(1)
def mini_maxi(nums):
    mini =float('inf')
    maxi =float('-inf')
    if len(nums)==0:
        return -1
    if len(nums)==1:
        return (nums[0],nums[0])
    if len(nums )==2:
        if nums[0]>nums[1]:
            mini =nums[1]
            maxi =nums[0]
        else:
            mini =nums[0]
            maxi =nums[1]
    if len(nums) % 2==0 :
        i=0
        while(i<len(nums)):
            if nums[i] > nums[i + 1]:
                if mini > nums[i + 1]:
                    mini = nums[i + 1]
                if maxi < nums[i]:
                    maxi = nums[i]
            else:
                if mini > nums[i]:
                    mini = nums[i]
                if maxi < nums[i + 1]:
                    maxi = nums[i + 1]
            if i==len(nums)-1:
                break
            i=i+2
    else :
        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                if mini>nums[i+1]:
                    mini=nums[i+1]
                if maxi<nums[i]:
                    maxi=nums[i]
            else:
                if mini>nums[i]:
                    mini=nums[i]
                if maxi<nums[i+1]:
                    maxi=nums[i+1]
            i=i+2
        if nums[-1] > maxi:
            maxi = nums[-1]
        if nums[-1]<mini:
            mini =nums[-1]

    return (mini,maxi)
# n=[2,3,4,5]
# sub=mini_maxi(n)
# print(sub)