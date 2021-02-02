#TimeComplexity:O(MN) (3N/2)+2 Comparisions 
#SpaceComplexity: Constant Space (No extra space taken).
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
class MinMAx():
    def MinMAxFinding(self,nums):
        if len(nums)==0:
            return None
        if len(nums)==1:
            return nums[0],nums[0]
        if nums[0]<=nums[1]:
            min=nums[0]
            max=nums[1]
        else:
            max=nums[0]
            min=nums[1]  
        for i in range(1,len(nums)//2):
            if nums[2*i]>nums[2*i+1]:
                if nums[2*i]>max:
                    max=nums[2*i]
                if nums[2*i+1]<min:
                    min=nums[2*i+1]
            else:
                if nums[2*i+1]>max:
                    max=nums[2*i+1]
                if nums[2*i]<min:
                    min=nums[2*i]
        if len(nums)%2==1:
            if nums[-1]>max:
                max=nums[-1]
            if nums[-1]<min:
                min=nums[-1]
        return max,min
X=MinMAx()
print(X.MinMAxFinding([2]))
                
            
