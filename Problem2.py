#Time Complexity-O(n)
#Space Complexity-O(1)

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        """
        #Method-1
        dict1={}
        res=[]
        if (len(nums)==0 or nums==0):
            return res
        
        n=len(nums)
        for i in range(1,n+1):
            dict1[i]=0
        print(dict1)
        
        for i in nums:
            dict1[i]+=1
        else:
            dict1[i]=1
        
        print(dict1)
        
        res=[]
        for key in dict1.keys():
            if(dict1[key]==0):
                res.append(key)
        
        return (res)"""
        
      
        
        t=set()
        
        n=len(nums)
        for i in range(1,n+1):
            t.add(i)
        return (t-set(nums))
        