/* Time complexity: O(n)
Space complexity: O(1)

1. Using the given array and modifying within the array to check for the missing elements
2. This is achieved by checking for a particular element in the given array and using it as index to make the element in that index negative.
3. To avoid confusion, absolute value of the element present in the array is taken.

*/

class Solution{
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            int temp = nums[i];

            if(temp < 0){
                temp *= -1;
            }

            if(nums[temp-1] >0){
                nums[temp-1] *= -1;
            }
            
        }

        for(int j=0; j<nums.length; j++){
            if(nums[i] > 0){
                result.add(j);
            }
        }

        return result;
    }
}