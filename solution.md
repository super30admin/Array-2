# Problem 1
## Time Complexity :
O(n**2)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Solution 1 used extra space, but ran all testcases on leetcode.
Solution 2 did not use extra space, but did not run all testcases. It was successfully compiled, but resulted in run time exceeded.
## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution 1:
      def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # checking if length of array is greater than 0
        if len(nums)!=0:
            c=len(nums)
            # creating new list
            b=[]
            # adding all numbers from 1 to n in new list
            for i in range(1,c+1):
                b.append(i)
            # finding the numbers missing in given list, and storing in result list.
            result=list(set(b) - set(nums))
            return result
        else:
            return nums


### Solution 2:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n=len(nums)
        # checking if length of array is greater than 0
        if n > 0:
            #Check if numbers from 1 to n are present in nums
            for i in range(1,n+1):
                # If all numbers not present, we add the missing numbers at the end of the list
                if i not in nums:
                    nums.append(i)
                    #Return appended numbers
            return nums[n:]
        else:
            return nums

# Problem 2
## Time Complexity : 
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
N/A

## Any problem you faced while coding this :
No. 

## Your code here along with comments explaining your approach
### Solution:
def getMinMax(low, high, a): 
    # Initializing max and min value as the low value
    a_max=a[low]
    a_min=a[low]
    # If there is only one element  
    # Max and Min value will be the same
    if low == high: 
        a_max = a[low] 
        a_min = a[low] 
        print (a_max, a_min)
    # If there are only two elements
    # The higher value is assigned as max and other as min
    elif high == low + 1:
        if a[low] > a[high]: 
            a_max = a[low] 
            a_min = a[high] 
        else: 
            a_max = a[high] 
            a_min = a[low] 
        return (a_max, a_min)
    else: 
        # If there are more than 2 elements 
        # Dividing the list in 2 parts (Binary Search)
        mid = int((low + high) / 2) 
        # Find max and min in first half of the list
        a_max1, a_min1 = getMinMax(low, mid, a) 
        # Find max and min in second half of the list
        a_max2, a_min2 = getMinMax(mid + 1, high, a) 
        # returning maximum of the 2 max value returned and same for the min value
    return (max(a_max1, a_max2), min(a_min1, a_min2))
    
# Problem 3
  
## Time Complexity :
## Space Complexity :
## Did this code successfully run on Leetcode :
## Any problem you faced while coding this :
Yes. Couldn't understand how to approach the problem.

## Your code here along with comments explaining your approach
