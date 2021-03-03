#Time Compexity: O(n) its O(2n) because the given array is traversed twice
#Space Complexity: O(1) because no other data structure is used only the input(given) array is used
class Solution():
    def findDisappearedNumbers(self, nums):
        #sanity check
        if (len(nums)==0 or nums==None):
            return None
        #get length of the array
        n = len(nums)
        for i in (range(0,n)):
            #store the value in a variable
            val = abs(nums[i])
            #if the number is +ve
            if nums[val-1] > 0:
                #make the number at the index-1 as -ve
                nums[val-1] = nums[val-1]*(-1)
        result=[]
        for j in (range(0,n)):
            if nums[j] > 0:
                result.append(j+1)
        return result
