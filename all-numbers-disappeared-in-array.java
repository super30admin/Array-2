//Time complexity: O(n), where n is the number of elements in the given array
//Space complexity:O(1), used the array given
//running on leetcode: yes
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums==null || nums.length==0)
        {
            return new ArrayList<Integer>();
        }
        
        //create a new empty list
        List<Integer> result = new ArrayList<>();
        //traverse thru the array and see what is the index
        //size of the array is n so there will be n-1 elements
        //and elements are from 1 to n
        //to get index from the array integers, -1 from the integers to get the respective array
        //example: elements are : 1 to 8.    Indices are : 0 to 7
        for (int i=0; i<nums.length; i++)
        {
            //get index from the element
            int index = Math.abs(nums[i])-1;
            if (nums[index]>0)
            {
                //convert all elements which appear, their associated indices -ve
                nums[index]= nums[index]*-1;
            }
        }
        
        //second pass to get the missing values
        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] > 0)
            {
                result.add(i+1);
            }
            else
            {
                //change the -ve numbers to +ve to get the original array
                nums[i]=nums[i]*-1;
            }
        }
        return result;
    }
}
