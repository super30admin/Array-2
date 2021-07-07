//time - O(n)
//space  - constant
//manipulated the input array, if asked changed all signs back to positive 
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //given - an array of size n has only elements in range [1, n]
        //some elements could be seen multiple time ans some will be missing - find all missing
        
        //brute force - have a set with all numbers from 1 to n
        //iterate through array and remove the corresponding element from set
        //at the end all elements in set is the result
        //space - O(n) and time is O(n)
        
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<Integer>();
        }
        
        //approach - if element X is seen in nums, then its respective index is x - 1
        //since x is seen make the element in index x - 1 as negative 
        //eventually for all the elements in nums, the respective indices values will be set negative
        //the only indices which have positive values belong to the result
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++)
        {
            int equivalentIndex = Math.abs(nums[i]) - 1;
            if(nums[equivalentIndex] > 0)
            {
                nums[equivalentIndex] = -nums[equivalentIndex];
            }
        }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] > 0)
            {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
