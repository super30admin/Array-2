/**

nums = [1,2,3,4,0,0,7,8]

[1,3,2,7,8,2,3,4]

counter = 7

1+2+3+4+5+6+7+8 = 


list = [1,2,3,4,0,0,7,8]

[4,3,2,7,8,2,3,1]

max = 8
min = 2
diff = 0
list = [5,6]

 [1,1]
 
 n = 8
 
 [1,1]
 
 2
 
 [0,2,3,4,8,2,7,1]



solution 1: Sort and iterate through the array to find missing number O(nlogn) + O(n) = O(nlogn)
solution 2: modifying the array in place.
TC - O(n)
SC - O(1)

**/
class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int i = 0;
        
        while(i < nums.length)
        {
            if (i == nums[i] - 1 || nums[i] == 0)
            {
                i++;
                continue;
            }
            
                if(nums[nums[i] - 1] == nums[i])
                {
                    nums[i] = 0;
                    i++;
                    continue;
                }
            
               int temp = nums[i];
               nums[i] = nums[nums[i] - 1];
               nums[temp - 1] = temp;
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int k=0; k<nums.length; k++)
        {
            if (nums[k] == 0)
            {
                result.add(k+1);
            }
        }
               
        return result;
    }
}